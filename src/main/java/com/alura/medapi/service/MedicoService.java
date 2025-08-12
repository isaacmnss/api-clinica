package com.alura.medapi.service;

import com.alura.medapi.DTO.AtualizaMedicoDTO;
import com.alura.medapi.DTO.DadosDetalhamentoMedico;
import com.alura.medapi.DTO.MedicoDTO;
import com.alura.medapi.model.MedicoRecord;
import com.alura.medapi.repository.MedicoRepository;
import com.alura.medapi.model.Medico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import org.springframework.web.util.UriComponentsBuilder;


@Service
public class MedicoService {

    @Autowired
    private MedicoRepository medicoRepository;

    public ResponseEntity cadastrarMedico(MedicoRecord dados, UriComponentsBuilder uriBuilder){
        Medico medico = new Medico(dados);
        medicoRepository.save(medico);
        var uri = uriBuilder.path("/medicos/{id}").buildAndExpand(medico.getId()).toUri();
        return ResponseEntity.created(uri).body(new DadosDetalhamentoMedico(medico));
    }


    public ResponseEntity<Page<MedicoDTO>>  listarMedicos(Pageable paginacao){
        var page = medicoRepository.findAllByAtivoTrue(paginacao).map(MedicoDTO::new);
        return ResponseEntity.ok(page);
    }

    public ResponseEntity buscarMedico(Long id){
        Medico medico = medicoRepository.getReferenceById(id);
        return ResponseEntity.ok(new DadosDetalhamentoMedico(medico));
    }

    public ResponseEntity atualizarMedico(AtualizaMedicoDTO dto){
        Medico medico = medicoRepository.getReferenceById(dto.id());
        medico.atualizarDados(dto);
        return ResponseEntity.ok(new DadosDetalhamentoMedico(medico));
    }

    public ResponseEntity deletarMedico(Long id) {
        Medico medico = medicoRepository.getReferenceById(id);
        medico.excluirMedico();
        return ResponseEntity.noContent().build();
    }
}
