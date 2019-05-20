package com.ipi.audio.service;

import com.ipi.audio.model.Album;
import com.ipi.audio.repository.AlbumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

@Service
public class AlbumService {

	@Autowired
	private AlbumRepository albumRepository;

	public Album newAlbum(Album album) {
		if (album == null) {
			throw new IllegalArgumentException("Album inconnue");
		}
		return albumRepository.save(album);
	}

	public void delAlbum(Long id) {
		Album album = albumRepository.findOne(id);
		if (album == null) {
			throw new EntityNotFoundException("L'id : " + id + " ne correspond à aucun album");
		}
		albumRepository.delete(id);
	}


}
