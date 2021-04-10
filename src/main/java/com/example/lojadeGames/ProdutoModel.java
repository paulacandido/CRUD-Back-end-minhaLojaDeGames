package com.example.lojadeGames;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.istack.NotNull;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "tb_Produto")
@Getter
@Setter
public class ProdutoModel {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private long id;
@NotNull
private String titulo;
@OneToMany(mappedBy = "produto", cascade = CascadeType.ALL)
@JsonIgnoreProperties("produto")
private List <CategoriaModel> categoria;

}
