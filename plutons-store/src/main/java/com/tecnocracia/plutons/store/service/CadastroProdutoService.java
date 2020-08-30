package com.tecnocracia.plutons.store.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.tecnocracia.plutons.store.model.Produto;
import com.tecnocracia.plutons.store.repository.Produtos;



public class CadastroProdutoService {
	@Autowired
	private Produtos produtos;

	public void salvar(Produto produto) {
		
			produtos.save(produto);
		
	}
}
