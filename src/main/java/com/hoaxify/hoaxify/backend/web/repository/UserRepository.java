package com.hoaxify.hoaxify.backend.web.repository;

import com.hoaxify.hoaxify.backend.web.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
}
