package com.example.szkolenietechniczne2.repositories;

import com.example.szkolenietechniczne2.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
