package com.sgomez.springboot.extras.Extras.repositories;

import com.sgomez.springboot.extras.Extras.models.LocalEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocalRepository extends JpaRepository<LocalEntity, Integer> {
}
