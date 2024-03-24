package com.tgid.testeJava.repositories;

import com.tgid.testeJava.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepostiory extends JpaRepository<User, Long> {
    User findByDocumento(String documento);
}
