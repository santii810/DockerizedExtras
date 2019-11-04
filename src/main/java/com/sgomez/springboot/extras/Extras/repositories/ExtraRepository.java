package com.sgomez.springboot.extras.Extras.repositories;

import com.sgomez.springboot.extras.Extras.models.ExtraEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExtraRepository extends JpaRepository<ExtraEntity, Integer> {
}
