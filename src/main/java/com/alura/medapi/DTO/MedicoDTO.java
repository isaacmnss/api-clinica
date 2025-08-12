package com.alura.medapi.DTO;

import com.alura.medapi.model.Especialidade;
import com.alura.medapi.model.Medico;

public record MedicoDTO (Long id, String nome, String email, String crm, Especialidade especialidade) {

    public MedicoDTO(Medico medico) {
        this(medico.getId(), medico.getNome(), medico.getEmail(), medico.getCrm(), medico.getEspecialidade());
    }
}
