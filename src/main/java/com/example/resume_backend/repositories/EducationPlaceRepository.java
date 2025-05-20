package com.example.resume_backend.repositories;

import com.example.resume_backend.entities.EducationPlace;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Optional;

@Repository
public interface EducationPlaceRepository extends JpaRepository<EducationPlace, Long> {
    Optional<ArrayList<EducationPlace>> findAllByOrderByIdDesc();
}
