package com.example.servingwebcontent.repository;

import com.example.servingwebcontent.model.Division;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DivisionRepository extends JpaRepository<Division, Integer> {
}