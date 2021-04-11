package edu.poly.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "favorites")
public class Favorite implements Serializable{
@Id
@Column(name = "Id")
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int id;

@ManyToOne
@JoinColumn(name = "UserId")
private User user;

@ManyToOne(fetch = FetchType.LAZY)
@JoinColumn(name = "VideoId")
private Video video;

@Column(name = "LikeDate")
private Date likeDate;

public Favorite() {

}

public Favorite(int id, User user, Video video, Date likeDate) {
	super();
	this.id = id;
	this.user = user;
	this.video = video;
	this.likeDate = likeDate;
}

public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public User getUser() {
	return user;
}

public void setUser(User user) {
	this.user = user;
}

public Video getVideo() {
	return video;
}

public void setVideo(Video video) {
	this.video = video;
}

public Date getLikeDate() {
	return likeDate;
}

public void setLikeDate(Date likeDate) {
	this.likeDate = likeDate;
}

@Override
public String toString() {
	return "Favorite [id=" + id + ", user=" + user + ", video=" + video + ", likeDate=" + likeDate + "]";
}


}


