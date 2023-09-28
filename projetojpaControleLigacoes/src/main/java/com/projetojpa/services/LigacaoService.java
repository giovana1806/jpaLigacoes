package com.projetojpa.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projetojpa.entities.Ligacao;
import com.projetojpa.repository.LigacaoRepository;

@Service
public class LigacaoService {
    private final LigacaoRepository ligacaoRepository;

    @Autowired
    public LigacaoService(LigacaoRepository ligacaoRepository) {
        this.ligacaoRepository = ligacaoRepository;
    }
    
    public List<Ligacao> buscaTodosLigacoes() {
        return ligacaoRepository.findAll();
    }
    
    public Ligacao buscaLigacaoId(Long id) {
    	Optional <Ligacao> ligacao = ligacaoRepository.findById(id);
    	return ligacao.orElse(null);
    }
    
    public Ligacao salvaLigacao(Ligacao ligacao) {
    	return ligacaoRepository.save(ligacao);
    }
    
    public Ligacao alterarLigacoes(Long id, Ligacao alterarLiga) {
    	Optional <Ligacao> existeLigacao = ligacaoRepository.findById(id);
    	if (existeLigacao.isPresent()) {
    		alterarLiga.setId(id);
    		return ligacaoRepository.save(alterarLiga);
    	}
    	return null;
    }
    
    public boolean apagarLigacoes(Long id) {
    	Optional <Ligacao> existeLigacao= ligacaoRepository.findById(id);
    	if (existeLigacao.isPresent()) {
    		ligacaoRepository.deleteById(id);
    		return true;
    	}
    	return false;
    }
}
