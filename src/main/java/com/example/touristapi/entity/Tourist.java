package com.example.touristapi.entity;
import jakarta.persistence.*;
import java.time.*;
@Entity @Table(name="tourists")
public class Tourist {
 @Id @GeneratedValue(strategy=GenerationType.IDENTITY) @Column(name="tourist_id") private Long touristId;
 @Column(name="first_name",nullable=false,length=100) private String firstName;
 @Column(name="last_name",nullable=false,length=100) private String lastName;
 @Column(nullable=false,unique=true,length=254) private String email;
 @Column(length=30) private String phone;
 @Column(length=100) private String country;
 @Column(name="visit_date") private LocalDate visitDate;
 @Column(name="created_at",insertable=false,updatable=false) private LocalDateTime createdAt;
 public Long getTouristId(){return touristId;} public String getFirstName(){return firstName;}
 public String getLastName(){return lastName;} public String getEmail(){return email;}
 public String getPhone(){return phone;} public String getCountry(){return country;}
 public LocalDate getVisitDate(){return visitDate;} public LocalDateTime getCreatedAt(){return createdAt;}
}
