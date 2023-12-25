package com.isaacszf.spd.domain.disease;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DiseaseRepository extends JpaRepository<Disease, Long>
{
    List<Disease> findAllByNameContainingIgnoreCase(String name);
}
