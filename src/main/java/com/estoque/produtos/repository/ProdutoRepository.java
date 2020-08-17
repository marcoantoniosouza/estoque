package com.estoque.produtos.repository;

import com.estoque.produtos.models.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.math.BigDecimal;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

    Produto findById(long id);

    <List>Produto findByNome(String nome);

    @Query("select p from Produto p where p.valor_unitario >= :valor_unitario")
    <List>Produto findByValorUnitario(BigDecimal valor_unitario);

}
