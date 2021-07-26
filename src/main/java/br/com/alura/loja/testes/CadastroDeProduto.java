package br.com.alura.loja.testes;

import java.math.BigDecimal;

import javax.persistence.EntityManager;

import br.com.alura.loja.dao.CategoriaDao;
import br.com.alura.loja.dao.ProdutoDao;
import br.com.alura.loja.modelo.Categoria;
import br.com.alura.loja.modelo.Produto;
import br.com.alura.loja.util.JPAUtil;

public class CadastroDeProduto {
	
	public static void main(String[] args) {
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
		em.flush();
	}

}
