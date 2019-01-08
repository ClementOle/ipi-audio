package com.ipi.audio.model;


import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Artist {
	@Id
	private Integer artistId;
	private String name;

	public Artist() {
	}

	public Artist(Integer artistId, String name) {
		this.artistId = artistId;
		this.name = name;
	}

	public Integer getArtistId() {
		return artistId;
	}

	public void setArtistId(Integer artistId) {
		this.artistId = artistId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Artist artist = (Artist) o;
		return Objects.equals(artistId, artist.artistId) &&
				Objects.equals(name, artist.name);
	}

	@Override
	public int hashCode() {
		return Objects.hash(artistId, name);
	}

	@Override
	public String toString() {
		return "Artist{" +
				"artistId=" + artistId +
				", name='" + name + '\'' +
				'}';
	}
}
