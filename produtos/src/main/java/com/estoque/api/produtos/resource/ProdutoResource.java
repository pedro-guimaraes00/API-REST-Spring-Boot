 package com.estoque.api.produtos.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.estoque.api.produtos.model.Produto;
import com.estoque.api.produtos.repository.ProdutoRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value="/api")
@Api(value="API REST Produtos")
@CrossOrigin(origins="*")
public class ProdutoResource {
	
	@Autowired
	ProdutoRepository produtoRepository;
	
	@GetMapping("/produtos")
	@ApiOperation(value="Retorna lista de produtos")
	public Page<Produto> listaProdutos(@RequestParam int page, @RequestParam int qnt) {
		
		Pageable paginacao = PageRequest.of(page, qnt);
		return produtoRepository.findAll(paginacao);
	}
	
	@GetMapping("/produtos/{id}")
	@ApiOperation(value="Retorna produto por id")
	public Produto listaProdutosPorId(@PathVariable(value="id") long id) {
		return produtoRepository.findById(id);
	}
	
	@PostMapping("/produto")
	@ApiOperation(value="Salva um novo produto na base de dados")
	public Produto salvar(@RequestBody Produto produto) { 
		return produtoRepository.save(produto);	
	}
	
	@DeleteMapping("/produto")
	@ApiOperation(value="Deleta um produto na base de dados")
	public void deletar(@RequestBody Produto produto) {
		produtoRepository.delete(produto);	
	}
	
	@PutMapping("/produto")
	@ApiOperation(value="Atualiza um produto na base de dados")
	public Produto atualizar(@RequestBody Produto produto) {
		return produtoRepository.save(produto);	
	}
	
}

