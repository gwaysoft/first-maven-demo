package com.gwaysoft.firstappdemo.web.ractive.repository;

import com.gwaysoft.firstappdemo.web.ractive.domain.User;
import org.springframework.data.repository.CrudRepository;

public interface  UserRepository extends CrudRepository<User, Long> {

}
