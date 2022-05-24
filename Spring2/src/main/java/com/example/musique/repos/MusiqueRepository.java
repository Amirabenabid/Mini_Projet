package com.example.musique.repos;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.musique.entities.Style;
import com.example.musique.entities.Musique;
@Repository
public interface MusiqueRepository extends JpaRepository<Musique, Long> {
	List<Musique> findByNomMusique(String nom);
	 List<Musique> findByNomMusiqueContains(String nom);
	 @Query("select p from Musique p where p.nomMusique like %:nom and p.prixMusique > :prix")
	 List<Musique> findByNomPrix (@Param("nom") String nom,@Param("prix") Double prix);
	 @Query("select p from Musique p where p.style = ?1")
	 List<Musique> findByStyle (Style style);
	 List<Musique> findByStyleIdStyle(Long id);
	 List<Musique> findByOrderByNomMusiqueAsc();
	 @Query("select p from Musique p order by p.nomMusique ASC, p.prixMusique DESC")
	 List<Musique> trierMusiquesNomsPrix();
	 
	/* @Query("SELECT p FROM Musique p WHERE p.nom_musique LIKE %?nom%")
	    public List<Musique> search(String keyword);
	  */  
}