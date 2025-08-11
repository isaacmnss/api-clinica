package com.alura.medapi.service;

import com.alura.medapi.DTO.MedicoDTO;
import com.alura.medapi.Repository.MedicoRepository;
import com.alura.medapi.model.Medico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MedicoService {

    @Autowired
    private MedicoRepository medicoRepository;

    public void cadastrarMedico(MedicoDTO dados){
        Medico medico = new Medico(dados);
        medicoRepository.save(medico);

    }
}
