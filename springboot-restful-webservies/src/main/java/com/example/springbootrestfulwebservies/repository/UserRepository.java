package com.example.springbootrestfulwebservies.repository;

import com.example.springbootrestfulwebservies.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
}
