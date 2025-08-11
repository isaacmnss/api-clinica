package com.alura.medapi.DTO;

import com.alura.medapi.model.Especialidade;

public record MedicoDTO(String nome, String email, String crm, Especialidade especialidade, EnderecoDTO enderecoDTO) {
}
