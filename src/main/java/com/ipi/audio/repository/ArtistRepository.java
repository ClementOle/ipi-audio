package com.ipi.audio.repository;

import com.ipi.audio.model.Artist;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;


public interface ArtistRepository extends PagingAndSortingRepository<Artist, Integer> {
	Artist findById(int id);

	List<Artist> findByNameContaining(String name);
}
