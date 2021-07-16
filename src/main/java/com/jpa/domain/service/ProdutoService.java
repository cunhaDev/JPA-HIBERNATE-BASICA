package com.jpa.domain.service;

import java.util.List;

import javax.persistence.EntityManager;

import com.jpa.domain.model.Produto;

public class ProdutoService {

	private EntityManager entityManager;

	public ProdutoService(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	public void Cadastrar(Produto produto) {
		this.entityManager.persist(produto);
	}

	public void atualizar(Produto produto) {
		this.entityManager.merge(produto);
	}

	public void remover(Produto produto) {
		produto = entityManager.merge(produto);
		this.entityManager.remove(produto);
	}

	public List<Produto> listar() {
		String JPQL = "SELECT p FROM Produto p";
		return entityManager.createQuery(JPQL, Produto.class).getResultList();
	}

	public List<Produto> buscarPorNome(String nome) {
		String JPQL = "SELECT p FROM Produto p 	WHERE p.nome = :nome";
		return entityManager.createQuery(JPQL, Produto.class).setParameter("nome", nome).getResultList();
	}
}
