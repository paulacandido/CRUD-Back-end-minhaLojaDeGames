package com.example.lojadeGames;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;


@Entity 
@Table(name="tb_Categoria")
@Getter
@Setter
public class CategoriaModel {
@Id
private long id;
@NotNull
private String descricao;
@ManyToOne
@JsonIgnoreProperties("categoria")
private ProdutoModel produto;
}