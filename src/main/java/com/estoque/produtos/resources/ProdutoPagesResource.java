package com.estoque.produtos.resources;

import com.estoque.produtos.models.Produto;
import com.estoque.produtos.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;

@Controller
public class ProdutoPagesResource {

    @Autowired
    ProdutoRepository produtoRepository;

    @GetMapping("/produtos")
    public String pageListaProdutos(Model model){
        model.addAttribute("listaProdutos", produtoRepository.findAll());
        return "produtos";
    }

    @GetMapping("/produtos/{id}")
    public String pageAtualizaProduto(Model model, @PathVariable(value = "id") long id){
        Produto produto = produtoRepository.findById(id);
        model.addAttribute("id", produto.getId());
        model.addAttribute("nome", produto.getNome());
        model.addAttribute("descricao", produto.getDescricao());
        model.addAttribute("estoque", produto.getEstoque());
        model.addAttribute("und_medida", produto.getUnd_medida());
        model.addAttribute("valor_unitario", produto.getValor_unitario());

        return ("atualizarProduto");
    }

    @RequestMapping("/produtos/novo")
    public String pageNovoProduto(Model model) {
        return "cadastrarProduto";
    }

    @GetMapping("/produtos/cadastrar")
    public String pageCadastroProduto(Model model, @RequestParam("id") long id, @RequestParam("nome") String nome, @RequestParam("descricao") String descricao, @RequestParam("estoque") BigDecimal estoque, @RequestParam("valor_unitario") BigDecimal valor_unitario, @RequestParam("und_medida") String und_medida){
        Produto produto = new Produto();
        if (id > 0) { produto.setId(id);}
        produto.setNome(nome);
        produto.setDescricao(descricao);
        produto.setEstoque(estoque);
        produto.setUnd_medida(und_medida);
        produto.setValor_unitario(valor_unitario);

        produtoRepository.save(produto);

        return "redirect:/produtos";
    }

    @GetMapping(value = "/produtos/delete/{id}")
    public String pageDeletaProduto(Model model, @PathVariable(value = "id") long id){
        produtoRepository.deleteById(id);
        return "redirect:/produtos";
    }

    @RequestMapping(value = "/")
    public String indexPage(Model model){
        return "redirect:/produtos";
    }
}
