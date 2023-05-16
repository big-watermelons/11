package com.softusing.hejunjie.repository;

import com.softusing.hejunjie.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
