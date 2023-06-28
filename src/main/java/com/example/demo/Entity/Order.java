package com.example.demo.Entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;



import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "Orders")
public class Order implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;

	String address;

	@Temporal(TemporalType.DATE)
	@Column(name = "Createdate")
	Date createDate = new Date();

	@ManyToOne
	@JoinColumn(name = "Username")
	Account account;

	@JsonIgnore
	@OneToMany(mappedBy = "order")
	List<OrderDetail> orderDetails;
}