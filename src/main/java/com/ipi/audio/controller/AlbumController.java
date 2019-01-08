package com.ipi.audio.controller;

import com.ipi.audio.model.Album;
import com.ipi.audio.service.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/albums")
public class AlbumController {
	@Autowired
	AlbumService albumService;

	@RequestMapping(value = "", method = RequestMethod.POST)
	public Album newAlbum(@RequestBody Album album) {
		return albumService.newAlbum(album);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	public void delAlbum(@PathVariable(value = "id") int id) {
		albumService.delAlbum(id);
	}


}
