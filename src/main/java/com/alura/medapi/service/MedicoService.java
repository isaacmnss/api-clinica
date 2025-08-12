package com.alura.medapi.service;

import com.alura.medapi.DTO.AtualizaMedicoDTO;
import com.alura.medapi.DTO.MedicoDTO;
import com.alura.medapi.model.MedicoRecord;
import com.alura.medapi.repository.MedicoRepository;
import com.alura.medapi.model.Medico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;


@Service
public class MedicoService {

    @Autowired
    private MedicoRepository medicoRepository;

    public void cadastrarMedico(MedicoRecord dados){
        Medico medico = new Medico(dados);
        medicoRepository.save(medico);
    }


    public Page<MedicoDTO> listarMedicos(Pageable paginacao){
        return medicoRepository.findAll(paginacao).map(MedicoDTO::new);
    }

    public void atualizarMedico(AtualizaMedicoDTO dto){
        Medico medico = medicoRepository.getReferenceById(dto.id());
        medico.atualizarDados(dto);
    }

    public void deletarMedico(Long id) {
        Medico medico = medicoRepository.getReferenceById(id);
        medico.excluirMedico();
    }
}
