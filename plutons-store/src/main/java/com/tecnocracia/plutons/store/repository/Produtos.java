package com.tecnocracia.plutons.store.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tecnocracia.plutons.store.model.Produto;


public interface Produtos extends JpaRepository<Produto, Long>{

}
