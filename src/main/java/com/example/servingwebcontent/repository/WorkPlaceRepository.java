package com.example.servingwebcontent.repository;

import com.example.servingwebcontent.model.WorkPlace;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkPlaceRepository extends JpaRepository<WorkPlace, Integer> {
}