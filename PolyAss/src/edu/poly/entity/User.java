package edu.poly.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;


@Entity
@Table(name = "users")
public class User implements Serializable{

	private static final long serialVersionUID = 1L;
@Id
@Column(name = "UserId")
private String userId;
@Column(name = "Password")
private String password;
@Column(name = "Email")
private String email;
@Column(name = "Fullname")
private String fullname;
@Column(name = "Admin")
private boolean admin;

@OneToMany(mappedBy = "user",fetch=FetchType.LAZY)
@Fetch(FetchMode.SUBSELECT)
private List<Favorite> favorites;

@OneToMany(mappedBy="user",fetch=FetchType.LAZY)
private List<Share> shares;

public User() {
	
}

public List<Share> getShares() {
	return shares;
}

public void setShares(List<Share> shares) {
	this.shares = shares;
}


public User(String userId, String password, String email, String fullname, boolean admin, List<Favorite> favorites,
		List<edu.poly.entity.Share> shares) {
	super();
	this.userId = userId;
	this.password = password;
	this.email = email;
	this.fullname = fullname;
	this.admin = admin;
	this.favorites = favorites;
	this.shares = shares;
}

public String getUserId() {
	return userId;
}

public void setUserId(String userId) {
	this.userId = userId;
}

public String getPassword() {
	return password;
}

public void setPassword(String password) {
	this.password = password;
}

public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}

public String getFullname() {
	return fullname;
}

public void setFullname(String fullname) {
	this.fullname = fullname;
}

public boolean isAdmin() {
	return admin;
}

public void setAdmin(boolean admin) {
	this.admin = admin;
}

public List<Favorite> getFavorites() {
	return favorites;
}

public void setFavorites(List<Favorite> favorites) {
	this.favorites = favorites;
}

@Override
public String toString() {
	return "User [userId=" + userId + ", password=" + password + ", email=" + email + ", fullname=" + fullname
			+ ", admin=" + admin + ", favorites=" + favorites + ", shares=" + shares + "]";
}

}
