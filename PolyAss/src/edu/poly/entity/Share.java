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
@Table(name = "shares")
public class Share  implements Serializable{

	private static final long serialVersionUID = 1L;

@Id
@Column(name = "Id")
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Integer id;

@ManyToOne
@JoinColumn(name = "UserId")
private User user;

 @ManyToOne
 @JoinColumn(name = "VideoId")
private Video video;

 @Column(name = "Email")
 private String email;
 
@Column(name = "ShareDate")
 private Date shareDate;

@Override
public String toString() {
	return "Share [id=" + id + ", user=" + user + ", video=" + video + ", email=" + email + ", shareDate=" + shareDate
			+ "]";
}
public Share() {
}
public Share(Integer id, User user, Video video, String email, Date shareDate) {
	super();
	this.id = id;
	this.user = user;
	this.video = video;
	this.email = email;
	this.shareDate = shareDate;
}
public Integer getId() {
	return id;
}
public void setId(Integer id) {
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
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public Date getShareDate() {
	return shareDate;
}
public void setShareDate(Date shareDate) {
	this.shareDate = shareDate;
}



}
