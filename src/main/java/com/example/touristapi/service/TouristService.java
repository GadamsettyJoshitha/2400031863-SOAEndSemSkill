package com.example.touristapi.service;
import com.example.touristapi.dto.TouristResponse;
import com.example.touristapi.repository.TouristRepository;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class TouristService {
 private final TouristRepository repo;
 public TouristService(TouristRepository repo){this.repo=repo;}
 public List<TouristResponse> getAllTourists(){return repo.findAll().stream().map(TouristResponse::from).toList();}
}
