package com.ipi.audio.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Entity
public class Artist implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ArtistId")
	private Long id;

	@Column(name = "Name")
	private String name;

	@JsonIgnoreProperties("artist")
	@OneToMany(mappedBy = "artist")
	private Set<Album> albums;

	public Artist() {
	}

	public Artist(String name) {
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Album> getAlbums() {
		return albums;
	}

	public void setAlbums(Set<Album> albums) {
		this.albums = albums;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Artist artist = (Artist) o;
		return id == artist.id &&
				Objects.equals(name, artist.name) &&
				Objects.equals(albums, artist.albums);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, name, albums);
	}

	@Override
	public String toString() {
		return "Artist{" +
				"id=" + id +
				", name='" + name + '\'' +
				", albums=" + albums +
				'}';
	}
}
