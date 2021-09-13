package fr.isika.al9.microserviceUser.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.isika.al9.microserviceUser.dao.ProductRepository;
import fr.isika.al9.microserviceUser.models.Product;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository productRepository;
	
	public Iterable<Product> findAll() {
		return productRepository.findAll();
	}

}
