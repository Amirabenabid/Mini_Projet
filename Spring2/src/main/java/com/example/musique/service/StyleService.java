package com.example.musique.service;

import java.util.List;

import com.example.musique.entities.Style;


public interface StyleService {

    List <Style> findAll();
    
    Style saveStyle(Style c);
    Style updateStyle(Style c);
    void deleteStyle(Style c);
     void deleteStyleById(Long id);
     Style getStyle(Long idStyle);

}