package com.ipi.audio.repository;


import com.ipi.audio.model.Album;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface AlbumRepository extends PagingAndSortingRepository<Album, Long> {
}
