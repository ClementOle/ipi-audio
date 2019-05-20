package com.ipi.audio.service;

import com.ipi.audio.model.Artist;
import com.ipi.audio.repository.ArtistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class ArtistService {

	@Autowired
	private ArtistRepository artistRepository;

	public long countArtist() {
		return artistRepository.count();
	}

	public Artist findArtist(Long id) {
		Artist artist = artistRepository.findOne(id);
		if (artist == null) {
			throw new EntityNotFoundException("L'id : " + id + " ne correspont à aucun artist");
		}
		return artist;
	}

	public Page<Artist> pagingArtist(int page, int size, String sortProperty, String sortDirection) {
		if (page < 0) {
			throw new IllegalArgumentException("Le numéro de page ne peut être négatif");
		} else if (page > countArtist() / size) {
			throw new IllegalArgumentException("Le numéro de page est trop élevé");
		} else if (size > countArtist()) {
			throw new IllegalArgumentException("La taille est trop grande");
		}
		PageRequest pageRequest = new PageRequest(page, size, Sort.Direction.fromString(sortDirection), sortProperty);
		return artistRepository.findAll(pageRequest);
	}

	public List<Artist> findByName(String name) {
		List<Artist> artist = artistRepository.findByNameContaining(name);
		if (artist == null) {
			throw new EntityNotFoundException("Aucun artiste trouvé");
		}
		return artistRepository.findByNameContaining(name);
	}

	public Artist newArtist(Artist artist) {
		if (artistRepository.findOne(artist.getId()) != null) {
			throw new EntityExistsException("Un artist existe déjà avec l'id : " + artist.getId());
		} else if (artistRepository.findByNameEquals(artist.getName()) != null) {
			throw new EntityExistsException("Un artiste existe déjà avec le nom : " + artist.getName());
		}
		return artistRepository.save(artist);
	}

	public Artist updateArtist(Long id, Artist artistModifier) {

		Artist artist = artistRepository.findOne(id);
		if (artist == null) {
			throw new EntityNotFoundException("Artiste inconnue");
		}
		artist.setName(artistModifier.getName());
		artist.setAlbums(artistModifier.getAlbums());
		return artistRepository.save(artist);
	}

	public void deleteArtist(Long id) {
		Artist artist = artistRepository.findOne(id);
		if (artist == null) {
			throw new EntityNotFoundException("Artiste inconnue");
		}
		artistRepository.delete(artist);
	}
}
