package fr.isika.al9.microserviceUser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import fr.isika.al9.microserviceUser.dao.DestinationRepository;
import fr.isika.al9.microserviceUser.dao.RoleRepository;
import fr.isika.al9.microserviceUser.dao.UserRepository;

@SpringBootApplication
public class MicroserviceUserApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceUserApplication.class, args);
	}

	@Autowired
	RoleRepository rolerepo;

	@Autowired
	UserRepository userrepo;
	
	@Autowired
	DestinationRepository destinationRepository;

		/*
		 * @Bean public CommandLineRunner loadData() { return (args) -> { Role admin =
		 * new Role(); admin.setRole("ADMIN"); Role user = new Role();
		 * user.setRole("USER"); rolerepo.save(admin); rolerepo.save(user);
		 * 
		 * HashSet<Role> roleAdmin = new HashSet<Role>(); roleAdmin.add(admin);
		 * 
		 * HashSet<Role> roleUser = new HashSet<Role>(); roleUser.add(user);
		 * 
		 * HashSet<Role> deuxRoles = new HashSet<Role>(); deuxRoles.add(user);
		 * 
		 * // save a couple of customers userrepo.save(new User(2, "Maurice", "DUPONT",
		 * "maurice.dupont@gmail.xx", "coucou", roleUser)); userrepo.save(new User(3,
		 * "Victor", "HUGO", "victor.hugo@gmail.xx", "coucou", deuxRoles));
		 * userrepo.save(new User(4, "Jack", "Bauer", "jack.Bauer@gmail.xx", "coucou",
		 * roleAdmin));
		 * 
		 * destinationRepository.save(new Destination(1, "Crête", "Greece", "Grèce",
		 * "La Crète est une île grecque, autrefois appelée « île de Candie ». Elle est la plus grande des îles grecques et la cinquième de la mer Méditerranée en superficie"
		 * , 35.34336 ,25.13608));
		 * 
		 * };
		 * 
		 * }
		 */
}
