package br.com.fiap.brindes.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import br.com.fiap.brindes.dto.request.CategoriaRequest;
import br.com.fiap.brindes.dto.response.CategoriaResponse;
import br.com.fiap.brindes.entity.Categoria;
import br.com.fiap.brindes.repository.CategoriaRepository;

@Service
public class CategoriaService {

    private final CategoriaRepository categoriaRepository;

    public CategoriaService(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    public CategoriaResponse criarCategoria(CategoriaRequest request) {
        Categoria categoria = new Categoria(request.nome());
        categoria = categoriaRepository.save(categoria);
        return new CategoriaResponse(categoria.getId(), categoria.getNome());
    }

    public CategoriaResponse buscarCategoria(Long id) {
        Categoria categoria = categoriaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Categoria não encontrada"));
        return new CategoriaResponse(categoria.getId(), categoria.getNome());
    }

    public List<CategoriaResponse> listarCategorias() {
        List<Categoria> categorias = categoriaRepository.findAll();
        return categorias.stream()
                .map(c -> new CategoriaResponse(c.getId(), c.getNome()))
                .collect(Collectors.toList());
    }
}
