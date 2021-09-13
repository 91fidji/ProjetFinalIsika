package fr.isika.al9.microserviceUser.dao;

import org.springframework.data.repository.CrudRepository;

import fr.isika.al9.microserviceUser.models.Product;

public interface ProductRepository extends CrudRepository<Product, Integer> {

}
