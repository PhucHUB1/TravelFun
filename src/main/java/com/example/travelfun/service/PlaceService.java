package com.example.travelfun.service;

import com.example.travelfun.dtos.request.place.PlaceCreationRequest;
import com.example.travelfun.entity.Place;
import com.example.travelfun.repository.PlaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlaceService {
    @Autowired
    private PlaceRepository placeRepository;

    public Place createPlace(PlaceCreationRequest request) {
        Place place = new Place();

        if (placeRepository.existsByName(request.getName())) {
            throw new RuntimeException("Place already exists");
        } else {

            place.setName(request.getName());
            place.setAddress(request.getAddress());
            place.setDescription(request.getDescription());

            return placeRepository.save(place);
        }
    }

    public List<Place> getAllPlaces(){
        return placeRepository.findAll();
    }

    public Place getPlaceById(String id){
        return placeRepository.findById(id).orElseThrow(()-> new RuntimeException("Place Not Found"));
    }

}
