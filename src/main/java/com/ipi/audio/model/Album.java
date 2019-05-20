package com.ipi.audio.model;


import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class Album implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "AlbumId")
	private Long id;

	@Column(name = "Title")
	private String title;

	@ManyToOne
	@JoinColumn(name = "ArtistId")
	private Artist artist;


	public Album() {
	}

	public Album(String title, Artist artistId) {
		this.title = title;
		this.artist = artistId;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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
		if (!(o instanceof Album)) return false;
		Album album = (Album) o;
		return Objects.equals(id, album.id) &&
				Objects.equals(title, album.title) &&
				Objects.equals(artist, album.artist);
	}

	@Override
	public String toString() {
		return "Album{" +
				"id=" + id +
				", title='" + title + '\'' +
				", artist=" + artist +
				'}';
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, title, artist);
	}

}
