package com.ipi.audio.model;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Objects;

@Entity
public class Album {
	@Id
	private Integer albumId;
	private String title;
	@OneToMany
	private Integer ArtistId;

	public Album() {
	}

	public Album(Integer albumId, String title, Integer artistId) {
		this.albumId = albumId;
		this.title = title;
		ArtistId = artistId;
	}

	public Integer getAlbumId() {
		return albumId;
	}

	public void setAlbumId(Integer albumId) {
		this.albumId = albumId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Integer getArtistId() {
		return ArtistId;
	}

	public void setArtistId(Integer artistId) {
		ArtistId = artistId;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Album album = (Album) o;
		return Objects.equals(albumId, album.albumId) &&
				Objects.equals(title, album.title) &&
				Objects.equals(ArtistId, album.ArtistId);
	}

	@Override
	public int hashCode() {
		return Objects.hash(albumId, title, ArtistId);
	}

	@Override
	public String toString() {
		return "Album{" +
				"albumId=" + albumId +
				", title='" + title + '\'' +
				", ArtistId=" + ArtistId +
				'}';
	}
}
