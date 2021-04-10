package com.example.lojadeGames;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaRepository extends JpaRepository<CategoriaModel,Long> {
	public List<CategoriaModel> findAllByDescricaoContainingIgnoreCase(String descricao);
}
