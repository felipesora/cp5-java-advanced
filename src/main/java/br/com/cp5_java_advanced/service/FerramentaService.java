package br.com.cp5_java_advanced.service;

import br.com.cp5_java_advanced.model.Ferramenta;
import br.com.cp5_java_advanced.repository.FerramentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class FerramentaService {

    @Autowired
    private FerramentaRepository ferramentaRepository;

    @Transactional(readOnly = true)
    public List<Ferramenta> listarFerramentas(String nome, String categoria) {
        if (nome != null && !nome.isBlank()) {
            nome = "%" + nome.trim() + "%";
        } else {
            nome = null;
        }

        if (categoria != null && !categoria.isBlank()) {
            categoria = "%" + categoria.trim() + "%";
        } else {
            categoria = null;
        }

        return ferramentaRepository.findByFiltros(nome, categoria);
    }

    public Long listarQuantidade() {
        return ferramentaRepository.count();
    }

    @Transactional(readOnly = true)
    public Ferramenta buscarPorId(Long id) {
        return ferramentaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Ferramenta com id: " + id + " não encontrada"));
    }

    @Transactional
    public Ferramenta salvar(Ferramenta ferramenta) {
        return ferramentaRepository.save(ferramenta);
    }

    @Transactional
    public Ferramenta atualizar(Long id, Ferramenta novaFerramenta) {
        var ferramentaAtual = buscarPorId(id);

        ferramentaAtual.setNome(novaFerramenta.getNome());
        ferramentaAtual.setDescricao(novaFerramenta.getDescricao());
        ferramentaAtual.setCategoria(novaFerramenta.getCategoria());
        ferramentaAtual.setMarca(novaFerramenta.getMarca());
        ferramentaAtual.setPreco(novaFerramenta.getPreco());
        ferramentaAtual.setQuantidade(novaFerramenta.getQuantidade());

        return ferramentaRepository.save(ferramentaAtual);
    }

    @Transactional
    public void deletar(Long id) {
        var ferramenta = buscarPorId(id);
        ferramentaRepository.delete(ferramenta);
    }
}
