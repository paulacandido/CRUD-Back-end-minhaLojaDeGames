package com.example.lojadeGames;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/Produto")
@CrossOrigin("*")
public class ProdutoController {
	@Autowired
	private ProdutoRepository produtorepository;
	@GetMapping
	public ResponseEntity<List<ProdutoModel>> GetAllProduto(){
		return ResponseEntity.ok(produtorepository.findAll());
	}
	@GetMapping("/{id}")
	public ResponseEntity<ProdutoModel> GetByIdProduto(@PathVariable Long id){
		return produtorepository.findById(id).map(resp -> ResponseEntity.ok(resp)).orElse(ResponseEntity.notFound().build());
	}
	@GetMapping("/nome/{nome}")
	public ResponseEntity<List<ProdutoModel>> GetByNome(@PathVariable String titulo){
		return ResponseEntity.ok(produtorepository.findAllByTituloContainingIgnoreCase(titulo));
	}
	
	@PostMapping
	public ResponseEntity<ProdutoModel> postProduto (@RequestBody ProdutoModel texto){
		return ResponseEntity.status(HttpStatus.CREATED).body(produtorepository.save(texto));
	}
	@PutMapping
	public ResponseEntity<ProdutoModel> putProduto (@RequestBody ProdutoModel texto){
		return ResponseEntity.status(HttpStatus.OK).body(produtorepository.save(texto));
	}
	@DeleteMapping("/{id}")
	public void deleteProduto(@PathVariable Long id) {
		produtorepository.deleteById(id);
	}
}