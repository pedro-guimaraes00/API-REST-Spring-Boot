package com.estoque.api.produtos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.estoque.api.produtos.model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
	
	Produto findById(long id);

}
