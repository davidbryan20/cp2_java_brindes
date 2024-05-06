package br.com.fiap.brindes.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import br.com.fiap.brindes.dto.request.ProdutoRequest;
import br.com.fiap.brindes.dto.response.ProdutoResponse;
import br.com.fiap.brindes.entity.Produto;
import br.com.fiap.brindes.repository.ProdutoRepository;
import lombok.Data;

@Data
@Service
public class ProdutoService {

    private final ProdutoRepository produtoRepository;

    public ProdutoService(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    public ProdutoResponse criarProduto(ProdutoRequest request) {
        Produto produto = new Produto(request.nome(), request.categoriaId());
        produto = produtoRepository.save(produto);
        return new ProdutoResponse(produto.getId(), produto.getNome(), produto.getCategoria().getId());
    }

    public ProdutoResponse buscarProduto(Long id) {
        Produto produto = produtoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Produto não encontrado"));
        return new ProdutoResponse(produto.getId(), produto.getNome(), produto.getCategoria().getId());
    }

    public List<ProdutoResponse> listarProdutos() {
        List<Produto> produtos = produtoRepository.findAll();
        return produtos.stream()
                .map(p -> new ProdutoResponse(p.getId(), p.getNome(), p.getCategoria().getId()))
                .collect(Collectors.toList());
    }
}
