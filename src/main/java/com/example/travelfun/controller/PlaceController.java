package com.example.travelfun.controller;

import com.example.travelfun.dtos.request.place.PlaceCreationRequest;
import com.example.travelfun.entity.Place;
import com.example.travelfun.service.PlaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/travelFun/places")
public class PlaceController {
    @Autowired
    private PlaceService placeService;

    @PostMapping("/create-place")
    Place createPlace(@RequestBody PlaceCreationRequest request) {
        return placeService.createPlace(request);
    }
    @GetMapping
    List<Place> getAllPlaces() {
        return placeService.getAllPlaces();
    }
    @GetMapping("/{placeId}")
    Place getPlace(@PathVariable("placeId") String placeId) {
        return placeService.getPlaceById(placeId);
    }
}
