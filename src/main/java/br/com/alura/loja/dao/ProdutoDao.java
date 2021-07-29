package br.com.alura.loja.dao;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.alura.loja.modelo.Produto;

public class ProdutoDao {
	
	private EntityManager em;

	public ProdutoDao(EntityManager em) {
		this.em = em;
	}
	
	public void cadastrar(Produto produto) {
		this.em.persist(produto);
	}

	public void atualizar(Produto produto) {
		this.em.merge(produto);
	}
	
	public void remover(Produto produto) {
		produto = em.merge(produto);
		this.em.remove(produto);
	}

	// busca apenas por um resultado
	public Produto buscarPorId(Long id) {
		return em.find(Produto.class, id);
	}
	
	// busca um ou mais resultados
	public List<Produto> buscarTodos(){
		String jpql = "SELECT p FROM Produto p";
		return em.createQuery(jpql, Produto.class).getResultList();
	}	
	
	// busca um ou mais resultados por parametro
	public List<Produto> buscarPorNome(String nome){
		String jpql = "SELECT p FROM Produto p WHERE p.nome = :nome";
		return em.createQuery(jpql, Produto.class)
				.setParameter("nome", nome)
				.getResultList();
	}
	// busca um ou mais resultados por parametro
//	public List<Produto> buscarPorNome(String nome){
//		String jpql = "SELECT p FROM Produto p WHERE p.nome = ?1";
//		return em.createQuery(jpql, Produto.class)
//				.setParameter(1, nome)
//				.getResultList();
//	}	
	// busca um ou mais resultados por parametro
	public List<Produto> buscarPorCategoria(String nome){
		String jpql = "SELECT p FROM Produto p WHERE p.categoria.nome = :nome";
		return em.createQuery(jpql, Produto.class)
				.setParameter("nome", nome)
				.getResultList();
	}
	
}
