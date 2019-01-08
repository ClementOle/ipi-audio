package com.ipi.audio.model;


import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Album {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "AlbumId")
	private int id;
	private String title;
	@JsonBackReference
	@ManyToOne(targetEntity = Artist.class, fetch = FetchType.EAGER)
	@JoinColumn(name = "ArtistId")
	private Artist artist;

	public Album() {
	}

	public Album(String title, Artist artistId) {
		this.title = title;
		this.artist = artistId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Artist getArtist() {
		return artist;
	}

	public void setArtist(Artist artist) {
		this.artist = artist;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Album album = (Album) o;
		return id == album.id &&
				Objects.equals(title, album.title) &&
				Objects.equals(artist, album.artist);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, title, artist);
	}

	@Override
	public String toString() {
		return "Album{" +
				"id=" + id +
				", title='" + title + '\'' +
				", artist=" + artist +
				'}';
	}
}
