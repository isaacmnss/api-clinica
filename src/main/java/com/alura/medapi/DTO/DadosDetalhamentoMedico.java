package com.alura.medapi.DTO;

import com.alura.medapi.model.Endereco;
import com.alura.medapi.model.Especialidade;
import com.alura.medapi.model.Medico;

public record DadosDetalhamentoMedico(Long id, String nome, String email, String crm, String telefone, Especialidade especialidade, Endereco endereco) {
    public DadosDetalhamentoMedico(Medico medico){
        this(medico.getId(), medico.getNome(), medico.getEmail(), medico.getCrm(), medico.getTelefone(),medico.getEspecialidade(), medico.getEndereco());
    }

}
