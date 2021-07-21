package br.com.alura.loja.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.time.LocalDate;

//Anotação da JPA
@Entity
@Table(name="PRODUTO")
public class Produto {
	
	@Column(name="ID")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name="NOME")
	private String nome;
	@Column(name="DESCRICAO")
	private String descricao;
	@Column(name="PRECO")
	private BigDecimal preco;
	@Column(name="DATACADASTRO")
	private LocalDate dataCadastro = LocalDate.now();	
	@ManyToOne
	@JoinColumn(name="ID_CATEGORIA")
	private Categoria id_categoria;
		
	public Produto(String nome, String descricao, BigDecimal preco, Categoria id_categoria) {
		this.nome = nome;
		this.descricao = descricao;
		this.preco = preco;
		this.id_categoria = id_categoria;
	}
	
	public LocalDate getDataCadastro() {
		return dataCadastro;
	}
	public void setDataCadastro(LocalDate dataCadastro) {
		this.dataCadastro = dataCadastro;
	}
	public Categoria getCategoria() {
		return id_categoria;
	}
	public void setCategoria(Categoria id_categoria) {
		this.id_categoria = id_categoria;
	}
	public int getId() {
		return id_categoria;
	}
	public void setId(int id) {
		this.id = id_categoria;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public BigDecimal getPreco() {
		return preco;
	}
	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}	
}