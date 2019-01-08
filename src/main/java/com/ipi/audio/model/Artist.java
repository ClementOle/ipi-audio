package com.ipi.audio.model;


import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
public class Artist {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ArtistId")
	private int id;
	@Column(name = "Name")
	private String name;
	@JsonManagedReference
	@OneToMany(fetch = FetchType.LAZY)
	@JoinColumn(name = "ArtistId")
	private List<Album> albums;

	public Artist() {
	}

	public Artist(String name, List<Album> albums) {
		this.name = name;
		this.albums = albums;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Album> getAlbums() {
		return albums;
	}

	public void setAlbums(List<Album> albums) {
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
