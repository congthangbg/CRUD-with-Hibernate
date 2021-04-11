package edu.poly.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "videos")
public class Video implements Serializable{

/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
@Id
@Column(name = "VideoId")
private String videoId;
@Column(name = "Title")
private String title;
@Column(name = "Poster")
private String poster;
@Column(name = "view")
private Integer view;
@Column(name = "Description")
private String description;
@Column(name = "Active")
private boolean active;

@OneToMany(mappedBy = "video",fetch = FetchType.LAZY)
private List<Favorite> favorites;

@OneToMany(mappedBy = "video",fetch = FetchType.LAZY)
private List<Share> shares;

public Video() {
}

public Video(String videoId, String title, String poster, Integer view, String description, boolean active,
		List<Favorite> favorites, List<Share> shares) {
	super();
	this.videoId = videoId;
	this.title = title;
	this.poster = poster;
	this.view = view;
	this.description = description;
	this.active = active;
	this.favorites = favorites;
	this.shares = shares;
}

public String getVideoId() {
	return videoId;
}

public void setVideoId(String videoId) {
	this.videoId = videoId;
}

public String getTitle() {
	return title;
}

public void setTitle(String title) {
	this.title = title;
}

public String getPoster() {
	return poster;
}

public void setPoster(String poster) {
	this.poster = poster;
}

public Integer getView() {
	return view;
}

public void setView(Integer view) {
	this.view = view;
}

public String getDescription() {
	return description;
}

public void setDescription(String description) {
	this.description = description;
}

public boolean isActive() {
	return active;
}

public void setActive(boolean active) {
	this.active = active;
}

public List<Favorite> getFavorites() {
	return favorites;
}

public void setFavorites(List<Favorite> favorites) {
	this.favorites = favorites;
}

public List<Share> getShares() {
	return shares;
}

public void setShares(List<Share> shares) {
	this.shares = shares;
}

@Override
public String toString() {
	return "Video [videoId=" + videoId + ", title=" + title + ", poster=" + poster + ", view=" + view + ", description="
			+ description + ", active=" + active + ", favorites=" + favorites + ", shares=" + shares + "]";
}


}
