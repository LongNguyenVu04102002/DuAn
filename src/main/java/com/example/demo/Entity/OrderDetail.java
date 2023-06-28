package com.example.demo.Entity;

import java.io.Serializable;


import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "Orderdetails")
public class OrderDetail implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;

	Double price;

	Integer quantity;

	@ManyToOne
	@JoinColumn(name = "Productid")
	Product product;

	@ManyToOne
	@JoinColumn(name = "Orderid")
	Order order;
}
