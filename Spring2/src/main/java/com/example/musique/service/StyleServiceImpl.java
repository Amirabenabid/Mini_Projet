package com.example.musique.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.musique.entities.Style;
import com.example.musique.repos.StyleRepository;


@Service
public class StyleServiceImpl implements StyleService {

    @Autowired
    private StyleRepository StyleRepository;

    @Override
    public List <Style> findAll() {
        return StyleRepository.findAll();
    }

	@Override
	public Style saveStyle(Style c) {
		return StyleRepository.save(c);
	}

	@Override
	public Style updateStyle(Style c) {
		return StyleRepository.save(c);
	}

	@Override
	public void deleteStyle(Style c) {
		StyleRepository.delete(c);
	}

	@Override
	public void deleteStyleById(Long idStyle) {
		StyleRepository.deleteById(idStyle);
	}

	@Override
	public Style getStyle(Long idStyle) {
		return StyleRepository.findById(idStyle).get();
	}

   
}