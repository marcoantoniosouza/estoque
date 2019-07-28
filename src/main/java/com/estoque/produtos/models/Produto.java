package com.estoque.produtos.models;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Table(name="TB_PRODUTO")
public class Produto implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public String getUnd_medida() {
        return und_medida;
    }

    public void setUnd_medida(String und_medida) {
        this.und_medida = und_medida;
    }

    public BigDecimal getEstoque() {
        return estoque;
    }

    public void setEstoque(BigDecimal estoque) {
        this.estoque = estoque;
    }

    public BigDecimal getValor_unitario() {
        return valor_unitario;
    }

    public void setValor_unitario(BigDecimal valor_unitario) {
        this.valor_unitario = valor_unitario;
    }

    private String nome;
    private String descricao;
    private String und_medida;
    private BigDecimal estoque;
    private BigDecimal valor_unitario;

}
