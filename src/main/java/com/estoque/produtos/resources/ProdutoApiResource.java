package com.estoque.produtos.resources;

import com.estoque.produtos.models.Produto;
import com.estoque.produtos.repository.ProdutoRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping(value = "/api")
@Api(value = "API Produtos")
@CrossOrigin(origins = "*")
public class ProdutoApiResource {

    @Autowired
    ProdutoRepository produtoRepository;

    @GetMapping("/produtos")
    @ApiOperation(value = "Retorna uma lista de produtos do estoque")
    public List<Produto> listarProdutos(){
        return produtoRepository.findAll();
    }

    @GetMapping("/produtos/{id}")
    @ApiOperation(value = "Retorna um produto do estoque")
    public Produto listaProduto(@PathVariable(value = "id") long id) {
        return produtoRepository.findById(id);
    }

    @GetMapping("/produtos/nome/{nome}")
    @ApiOperation(value = "Retorna uma lista de produtos com base no nome do produto")
    public List<Produto> listarProdutos(@PathVariable(value = "nome") String nome) {
        return (List<Produto>) produtoRepository.findByNome(nome);
    }

    @GetMapping("/produtos/valor/{valor_unitario}")
    @ApiOperation(value = "Retorna uma lista de produtos com base no valor unitário")
    public List<Produto> listarProdutos(@PathVariable(value = "valor_unitario") BigDecimal valor_unitario) {
        return (List<Produto>) produtoRepository.findByValorUnitario(valor_unitario);
    }

    @PostMapping("/produtos")
    @ApiOperation(value = "Insere um produto")
    public Produto salvaProduto(@RequestBody Produto produto){
        return produtoRepository.save(produto);
    }

    @DeleteMapping("/produtos")
    @ApiOperation(value = "Deleta um produto")
    public void deletaProduto(@RequestBody Produto produto){
        produtoRepository.deleteById(produto.getId());
    }

    @PutMapping("/produtos")
    @ApiOperation(value = "Atualiza um produto")
    public Produto atualizaProduto(@RequestBody Produto produto){
        return produtoRepository.save(produto);
    }
}
