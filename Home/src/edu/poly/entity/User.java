package edu.poly.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "users")

public class User implements Serializable{
@Id
@Column(name = "id")
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Integer id;

@Column(name = "name")
private String name;

@Column(name = "email")
private String email;

@Column(name = "password")
private String password;

@Column(name = "number")
private String number;

@Column(name = "gender")
private Integer gender;

@Column(name = "role")
private Integer role;

public User() {

}

public User(Integer id, String name, String email, String password, String number, Integer gender, Integer role) {
	this.id = id;
	this.name = name;
	this.email = email;
	this.password = password;
	this.number = number;
	this.gender = gender;
	this.role = role;
}

public Integer getId() {
	return id;
}

public void setId(Integer id) {
	this.id = id;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}

public String getPassword() {
	return password;
}

public void setPassword(String password) {
	this.password = password;
}

public String getNumber() {
	return number;
}

public void setNumber(String number) {
	this.number = number;
}

public Integer getGender() {
	return gender;
}

public void setGender(Integer gender) {
	this.gender = gender;
}

public Integer getRole() {
	return role;
}

public void setRole(Integer role) {
	this.role = role;
}

@Override
public String toString() {
	return "User [id=" + id + ", name=" + name + ", email=" + email + ", password=" + password + ", number=" + number
			+ ", gender=" + gender + ", role=" + role + "]";
}

}
