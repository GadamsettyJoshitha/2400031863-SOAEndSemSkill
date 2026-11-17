package com.example.touristapi.dto;
import com.example.touristapi.entity.Tourist;
import java.time.*;
public record TouristResponse(Long touristId,String firstName,String lastName,String email,String phone,String country,LocalDate visitDate,LocalDateTime createdAt) {
 public static TouristResponse from(Tourist t){return new TouristResponse(t.getTouristId(),t.getFirstName(),t.getLastName(),t.getEmail(),t.getPhone(),t.getCountry(),t.getVisitDate(),t.getCreatedAt());}
}
