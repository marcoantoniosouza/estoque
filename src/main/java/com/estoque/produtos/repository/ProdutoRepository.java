package com.estoque.produtos.repository;

import com.estoque.produtos.models.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

    <List>Produto findByNome(String nome);

}
