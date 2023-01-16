package com.example.servingwebcontent.repository;

import com.example.servingwebcontent.model.Division;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DivisionRepository extends JpaRepository<Division, Integer> {
    public Optional<Division> findById(int id);
}