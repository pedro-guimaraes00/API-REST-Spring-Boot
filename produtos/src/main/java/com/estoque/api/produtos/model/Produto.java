package com.estoque.api.produtos.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="products")
public class Produto {
	
	private static final long serialVersionUD = 1L;
	
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Long  id;
	private String name;
	@Column(name =  "department_id")
	private Long stock;
	private Double price;
	
	
		public Long getId() {
			return id;
		}
		
		public String getName() {
			return name;
		}
		
		public void setName(String name) {
			this.name = name;
		}
		
		public Long getStock() {
			return stock;
		}
		
		public void setStock(Long stock) {
			this.stock = stock;
		}
		
		public Double getPrice() {
			return price;
		}
		
		public void setPrice(Double price) {
			this.price = price;
		}
	
}
