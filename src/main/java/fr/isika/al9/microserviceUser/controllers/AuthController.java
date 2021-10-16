package fr.isika.al9.microserviceUser.controllers;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.slf4j.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.isika.al9.microserviceUser.dao.RoleRepository;
import fr.isika.al9.microserviceUser.dao.UserRepository;
import fr.isika.al9.microserviceUser.models.Erole;
import fr.isika.al9.microserviceUser.models.Role;
import fr.isika.al9.microserviceUser.models.User;
import fr.isika.al9.microserviceUser.payload.request.LoginRequest;
import fr.isika.al9.microserviceUser.payload.request.SignupRequest;
import fr.isika.al9.microserviceUser.payload.response.JwtResponse;
import fr.isika.al9.microserviceUser.payload.response.MessageResponse;
import fr.isika.al9.microserviceUser.security.jwt.JwtUtils;
import fr.isika.al9.microserviceUser.security.services.UserDetailsImpl;

@CrossOrigin(origins= "*")
@RestController
@RequestMapping("/api/auth")
public class AuthController {
	
	@Autowired
	AuthenticationManager authenticationManager;
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	RoleRepository roleRepository;
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	@Autowired
	JwtUtils jwtUtils;
	
	@PostMapping("/signin")
	public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest){
		
		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword()));
	
		SecurityContextHolder.getContext().setAuthentication(authentication);
		String jwt = jwtUtils.generateJwtToken(authentication);
		
		UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
		
		List<String> roles = userDetails.getAuthorities().stream()
				.map(item -> item.getAuthority())
				.collect(Collectors.toList());
		
		return ResponseEntity.ok(new JwtResponse(jwt,
				userDetails.getId(),
				userDetails.getEmail(),
				roles));
	}
	
	@PostMapping("/signup")
	public ResponseEntity<?> registerUser(@Valid @RequestBody SignupRequest signupRequest){
		Logger log = LoggerFactory.getLogger(this.getClass());
		if (userRepository.existsByEmail(signupRequest.getEmail())) {
			return ResponseEntity
					.badRequest()
					.body(new MessageResponse("Error: Email is already taken !"));
		}
		
		User user = new User(
				signupRequest.getEmail(), 
				signupRequest.getName(), 
				signupRequest.getFirstname(), 
				passwordEncoder.encode(signupRequest.getPassword()));
		
		Set<String> strRoles = signupRequest.getRoles();
		Set<Role> roles = new HashSet<>();
		
		if (strRoles == null) {
			Role userRole = roleRepository.findByRole(Erole.ROLE_USER)
					.orElseThrow(()-> new RuntimeException("Error: Role is not found"));
			roles.add(userRole);
		} else {
			strRoles.forEach(role -> {
				switch(role) {
				case "admin":
					Role adminRole = roleRepository.findByRole(Erole.ROLE_ADMIN)
					.orElseThrow(() -> new RuntimeException("Error: Role is not found"));
					roles.add(adminRole);
					break;
				case "user":
					Role userRole = roleRepository.findByRole(Erole.ROLE_USER)
					.orElseThrow(() -> new RuntimeException("Error: Role is not found"));
					roles.add(userRole);
					break;
				default:
					Role userR = roleRepository.findByRole(Erole.ROLE_USER)
					.orElseThrow(() -> new RuntimeException("Error: Role is not found"));
					roles.add(userR);
				}
			});	
		}
		user.setRoles(roles);
		log.info("user"+user);
		userRepository.save(user);
		return ResponseEntity.ok(new MessageResponse("User registered successfully"));

	}

}
