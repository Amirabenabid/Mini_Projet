package com.example.musique.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.musique.entities.Style;


@Repository
public interface StyleRepository extends JpaRepository<Style, Long>{

}