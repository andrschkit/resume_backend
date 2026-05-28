package com.example.resume_backend.services;

import com.example.resume_backend.entities.EducationPlace;
import com.example.resume_backend.exceptions.NotFoundException;
import com.example.resume_backend.repositories.EducationPlaceRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

import static com.example.resume_backend.utils.StaticStrings.NOT_FOUND_EXCEPTION_EDUCATION_PLACE;

@Service
public class EducationPlaceService {

    private final EducationPlaceRepository educationPlaceRepository;

    public EducationPlaceService(EducationPlaceRepository educationPlaceRepository) {this.educationPlaceRepository = educationPlaceRepository;}

    public EducationPlace findEducationPlaceById(Long id) {return educationPlaceRepository.findById(id)
            .orElseThrow(()-> new NotFoundException(NOT_FOUND_EXCEPTION_EDUCATION_PLACE, id.toString()));}

    public ArrayList <EducationPlace> findAllEducationPlaces() {return educationPlaceRepository.findAllByOrderByIdAsc();}
}
