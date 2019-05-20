package com.ipi.audio.controller;

import com.ipi.audio.model.Artist;
import com.ipi.audio.service.ArtistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/artists")
public class ArtistController {

	@Autowired
	private ArtistService artistService;

	@RequestMapping(value = "/count", method = RequestMethod.GET)
	public long countArtist() {
		return artistService.countArtist();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "application/json")
	public Artist findArtist(@PathVariable(name = "id") Long id) {
		return artistService.findArtist(id);
	}

	@RequestMapping(params = "name", method = RequestMethod.GET, produces = "application/json")
	public List<Artist> findByName(@RequestParam(value = "name") String name) {
		return artistService.findByName(name);
	}

	@RequestMapping(value = "", method = RequestMethod.GET)
	public Page<Artist> findAllArtist(@RequestParam(value = "page", defaultValue = "0") int page, @RequestParam(value = "size", defaultValue = "10") int size, @RequestParam(value = "sortDirection", defaultValue = "ASC") String sortDirection, @RequestParam(value = "sortProperty", defaultValue = "name") String sortProperty) {
		return artistService.pagingArtist(page, size, sortProperty, sortDirection);
	}

	@RequestMapping(value = "", method = RequestMethod.POST)
	public Artist newArtist(@RequestBody Artist artist) {
		return artistService.newArtist(artist);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public Artist modifyArtist(@PathVariable(value = "id") Long id, @RequestBody Artist artist) {
		return artistService.updateArtist(id, artist);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	public void deleteArtist(@PathVariable(value = "id") Long id) {
		artistService.deleteArtist(id);
	}
}
