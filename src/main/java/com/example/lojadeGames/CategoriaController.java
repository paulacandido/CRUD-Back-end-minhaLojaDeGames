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
@RequestMapping("/Categoria")
@CrossOrigin("*")
public class CategoriaController {
	@Autowired
	private CategoriaRepository categoriarepository;
	@GetMapping
	public ResponseEntity<List<CategoriaModel>> GetAllCategoria(){
		return ResponseEntity.ok(categoriarepository.findAll());
	}
	@GetMapping("/{id}")
	public ResponseEntity<CategoriaModel> GetByIdCategoria(@PathVariable Long id){
		return categoriarepository.findById(id).map(resp -> ResponseEntity.ok(resp)).orElse(ResponseEntity.notFound().build());
	}
	@GetMapping("/descricao/{descricao}")
	public ResponseEntity<List<CategoriaModel>> GetByDescricao(@PathVariable String descricao){
		return ResponseEntity.ok(categoriarepository.findAllByDescricaoContainingIgnoreCase(descricao));
	}
	
	@PostMapping
	public ResponseEntity<CategoriaModel> postCategoria (@RequestBody CategoriaModel texto){
		return ResponseEntity.status(HttpStatus.CREATED).body(categoriarepository.save(texto));
	}
	@PutMapping
	public ResponseEntity<CategoriaModel> putCategoria (@RequestBody CategoriaModel texto){
		return ResponseEntity.status(HttpStatus.OK).body(categoriarepository.save(texto));
	}
	@DeleteMapping("/{id}")
	public void deleteCategoria(@PathVariable Long id) {
		categoriarepository.deleteById(id);
	}
}