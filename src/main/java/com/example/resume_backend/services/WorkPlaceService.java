package com.example.resume_backend.services;

import com.example.resume_backend.entities.WorkPlace;
import com.example.resume_backend.exceptions.NotFoundException;
import com.example.resume_backend.repositories.WorkPlaceRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

import static com.example.resume_backend.utils.StaticStrings.NOT_FOUND_EXCEPTION_WORK_PLACE_ID;

@Service
public class WorkPlaceService {

    private final WorkPlaceRepository workPlaceRepository;

    public WorkPlaceService(WorkPlaceRepository workPlaceRepository) {this.workPlaceRepository = workPlaceRepository;}

    public WorkPlace findWorkPlaceById(Long id) {return workPlaceRepository.findById(id)
            .orElseThrow(()-> new NotFoundException(NOT_FOUND_EXCEPTION_WORK_PLACE_ID, id.toString()));}

    public ArrayList<WorkPlace> findAllWorkPlaces() {return workPlaceRepository.findAllByOrderByIdAsc();}
}