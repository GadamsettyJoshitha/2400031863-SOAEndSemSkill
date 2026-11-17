package com.example.touristapi.controller;
import com.example.touristapi.dto.TouristResponse;
import com.example.touristapi.service.TouristService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController @RequestMapping("/api/tourists")
public class TouristController {
 private final TouristService service;
 public TouristController(TouristService service){this.service=service;}
 @GetMapping public ResponseEntity<List<TouristResponse>> fetchAllTourists(){return ResponseEntity.ok(service.getAllTourists());}
}
