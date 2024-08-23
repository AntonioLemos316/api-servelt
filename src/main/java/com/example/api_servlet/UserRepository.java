package com.example.api_servlet;

import org.springframework.data.repository.CrudRepository;

// Repository para criar e consultar os dados na DB
// Na interface passamos um generic com a entidade User e seu tipo Long
public interface UserRepository extends CrudRepository<User, Long>{
    
}
