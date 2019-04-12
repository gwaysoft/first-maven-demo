package com.gwaysoft.firstappdemo.web.ractive.repository;

import com.gwaysoft.firstappdemo.web.ractive.domain.User;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class UserRepository {
    private final ConcurrentMap<Integer, User> repository = new ConcurrentHashMap<>();

    private final static AtomicInteger idGenerator = new AtomicInteger();

    public User save(User user){
        user.setId(idGenerator.incrementAndGet());
        repository.put(user.getId(),user);
        return user;
    }

    public Collection<User> findAll(){
        return repository.values();
    }

}
