package fr.isika.al9.microserviceUser.dao;

import org.springframework.data.mongodb.repository.MongoRepository;

import fr.isika.al9.microserviceUser.models.User;

public interface UserRepository extends MongoRepository<User, String> {

}
