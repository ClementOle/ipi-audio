package com.ipi.audio.service;

import com.ipi.audio.model.Artist;
import com.ipi.audio.repository.ArtistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArtistService {

	@Autowired
	ArtistRepository artistRepository;

	public Artist findArtist(int id) {
		return artistRepository.findOne(id);
	}

	public Page<Artist> pagingArtist(int page, int size, String sortProperty, String sortDirection) {
		PageRequest pageRequest = new PageRequest(page, size, Sort.Direction.fromString(sortDirection), sortProperty);
		return artistRepository.findAll(pageRequest);
	}

	public List<Artist> findByName(String name) {
		return artistRepository.findByNameContaining(name);
	}

	public Artist newArtist(Artist artist) {
		return artistRepository.save(artist);
	}

	public Artist updateArtist(int id, Artist artistModifier) {
		Artist artist = artistRepository.findOne(id);
		artist.setName(artistModifier.getName());
		artist.setAlbums(artistModifier.getAlbums());
		return artistRepository.save(artist);
	}

	public void deleteArtist(int id) {
		Artist artist = artistRepository.findOne(id);
		artistRepository.delete(artist);
	}
}
