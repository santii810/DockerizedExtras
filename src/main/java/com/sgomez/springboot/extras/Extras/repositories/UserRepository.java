package com.sgomez.springboot.extras.Extras.repositories;

import com.sgomez.springboot.extras.Extras.models.LocalEntity;
import com.sgomez.springboot.extras.Extras.models.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Integer> {
}
