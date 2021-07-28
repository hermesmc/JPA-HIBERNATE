package br.com.alura.loja.testes;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.alura.loja.dao.CategoriaDao;
import br.com.alura.loja.dao.ProdutoDao;
import br.com.alura.loja.modelo.Categoria;
import br.com.alura.loja.modelo.Produto;
import br.com.alura.loja.util.JPAUtil;

public class CadastroDeProduto {
	
	public static void main(String[] args) {
		cadastrarProduto();
		Long id = 1l;
		EntityManager em = JPAUtil.getEntityManager();
		ProdutoDao produtoDao = new ProdutoDao(em);
		
		Produto p = produtoDao.buscarPorId(1l);
		System.out.println(p.getPreco());
		
		List<Produto> todos = produtoDao.buscarTodos();
		todos.forEach(p2 -> System.out.println(p.getNome()));		
		
	}

	private static void cadastrarProduto() {
		Categoria celulares = new Categoria(null, "CELULARES");
		//Produto celular = new Produto(null, "Xiaomi Redmi", "Muito legal", new BigDecimal("800"), null, celulares );
		
		EntityManager em = JPAUtil.getEntityManager();
		
		em.getTransaction().begin();
		em.persist(celulares);
		celulares.setNome("XPTO");
		
		em.flush();
		//aqui exemplo de desatachar do entityManager
		em.clear();
		//aqui atachando novamente
		celulares = em.merge(celulares);
		
		celulares.setNome("1234");
		//Deletando registros - removendo
		em.remove(celulares);
		em.flush();
	}

}
