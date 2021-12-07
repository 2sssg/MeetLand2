package com.example.meetland.repository;

import com.example.meetland.model.Meat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MeatRepository extends JpaRepository<Meat,Long> {

}
