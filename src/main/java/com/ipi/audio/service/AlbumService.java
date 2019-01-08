package com.ipi.audio.service;

import com.ipi.audio.model.Album;
import com.ipi.audio.repository.AlbumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AlbumService {

	@Autowired
	AlbumRepository albumRepository;

	public Album newAlbum(Album album) {
		return albumRepository.save(album);
	}

	public void delAlbum(int id) {
		Album album = albumRepository.findOne(id);
		albumRepository.delete(id);
	}
}
