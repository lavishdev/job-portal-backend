package com.lavish.jobportalbackend.Repository;

import com.lavish.jobportalbackend.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
