package com.alura.medapi.DTO;


import com.alura.medapi.model.EnderecoRecord;

import jakarta.validation.constraints.NotNull;

public record AtualizaMedicoDTO(

        @NotNull
        Long id,

        String nome,
        String telefone,
        EnderecoRecord endereco
) {
}
