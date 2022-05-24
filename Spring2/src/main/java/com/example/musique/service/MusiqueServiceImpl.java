
package com.example.musique.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.example.musique.entities.Style;
import com.example.musique.entities.Musique;
import com.example.musique.repos.MusiqueRepository;
@Service
public class MusiqueServiceImpl implements MusiqueService {
@Autowired
MusiqueRepository musiqueRepository;
@Override
public Musique saveMusique(Musique p) {
	return musiqueRepository.save(p);
	}
	@Override
	public Musique updateMusique(Musique p) {
	return musiqueRepository.save(p);
	}
	@Override
	public void deleteMusique(Musique p) {
	musiqueRepository.delete(p);
	}
	 @Override
	public void deleteMusiqueById(Long id) {
	musiqueRepository.deleteById(id);
	}
	@Override
	public Musique getMusique(Long id) {
	return musiqueRepository.findById(id).get();
	}
	
	@Override
	public Page<Musique> getAllMusiquesParPage(int page, int size) {
		return musiqueRepository.findAll(PageRequest.of(page, size));

	}
	@Override
	public List<Musique> findByNomMusique(String nom) {
	return musiqueRepository.findByNomMusique(nom);
	}
	@Override
	public List<Musique> findByNomMusiqueContains(String nom) {
	return musiqueRepository.findByNomMusiqueContains(nom);
	}
	@Override
	public List<Musique> findByNomPrix(String nom, Double prix) {
		return musiqueRepository.findByNomPrix(nom, prix);
	}
	@Override
	public List<Musique> findByStyle(Style style) {
	return musiqueRepository.findByStyle(style);
	}
	
	@Override
	public List<Musique> findByOrderByNomMusiqueAsc() {
	return musiqueRepository.findByOrderByNomMusiqueAsc();
	}
	@Override
	public List<Musique> trierMusiquesNomsPrix() {
	return musiqueRepository.trierMusiquesNomsPrix();
	}
	@Override
	public List<Musique> getAllMusiques() {
		return musiqueRepository.findAll();

	}
	@Override
	public List<Musique> findByMusiqueIdStyle(Long id) {
		return musiqueRepository.findByStyleIdStyle(id);

	}
	@Override
	public List<Musique> listAll(String keyword) {
		// TODO Auto-generated method stub
		return null;
	}
	
	/*@Autowired
	private MusiqueRepository repo;
	 
	public List<Musique> listAll(String keyword) {
	    if (keyword != null) {
	        return repo.search(keyword);
	    }
	    return repo.findAll();
	}*/
}