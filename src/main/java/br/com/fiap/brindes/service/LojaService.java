package br.com.fiap.brindes.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import br.com.fiap.brindes.dto.request.LojaRequest;
import br.com.fiap.brindes.dto.response.LojaResponse;
import br.com.fiap.brindes.entity.Loja;
import br.com.fiap.brindes.repository.LojaRepository;

@Service
public class LojaService {

    private final LojaRepository lojaRepository;

    public LojaService(LojaRepository lojaRepository) {
        this.lojaRepository = lojaRepository;
    }

    public LojaResponse criarLoja(LojaRequest request) {
        Loja loja = new Loja(request.nome());
        loja = lojaRepository.save(loja);
        return new LojaResponse(loja.getId(), loja.getNome());
    }

    public LojaResponse buscarLoja(Long id) {
        Loja loja = lojaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Loja não encontrada"));
        return new LojaResponse(loja.getId(), loja.getNome());
    }

    public List<LojaResponse> listarLojas() {
        List<Loja> lojas = lojaRepository.findAll();
        return lojas.stream()
                .map(l -> new LojaResponse(l.getId(), l.getNome()))
                .collect(Collectors.toList());
    }
}
