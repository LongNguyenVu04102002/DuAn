package com.example.demo.Entity;

import java.io.Serializable;
import java.util.List;



import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "Accounts")
public class Account implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	String username;

	String password;

	String fullname;

	String email;

	String photo;

	boolean admin;

	boolean activated;

	@JsonIgnore
	@OneToMany(mappedBy = "account")
	List<Order> orders;
}
