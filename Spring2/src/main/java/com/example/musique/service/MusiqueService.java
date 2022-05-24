package com.example.musique.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.example.musique.entities.Style;
import com.example.musique.entities.Musique;
public interface MusiqueService {
Musique saveMusique(Musique p);
Musique updateMusique(Musique p);
void deleteMusique(Musique p);
 void deleteMusiqueById(Long id);
Musique getMusique(Long id);
List<Musique> getAllMusiques();
Page<Musique> getAllMusiquesParPage(int page, int size);
List<Musique> findByNomMusique(String nom);
List<Musique> findByNomMusiqueContains(String nom);
List<Musique> findByNomPrix (String nom, Double prix);
List<Musique> findByStyle (Style style);
List<Musique> findByMusiqueIdStyle(Long id);
List<Musique> findByOrderByNomMusiqueAsc();
List<Musique> trierMusiquesNomsPrix();
List<Musique> listAll(String keyword);



}