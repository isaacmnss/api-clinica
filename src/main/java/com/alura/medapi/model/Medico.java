package com.alura.medapi.model;

import com.alura.medapi.DTO.AtualizaMedicoDTO;
import com.alura.medapi.service.BooleanToSmallIntConverter;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "medicos")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Medico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String email;
    private String crm;
    private String telefone;

    @Convert(converter = BooleanToSmallIntConverter.class)
    private boolean ativo;

    @Enumerated(EnumType.STRING)
    private Especialidade especialidade;

    @Embedded
    private Endereco endereco;

    public Medico(MedicoRecord medicoRecord){
        this.ativo = true;
        this.nome = medicoRecord.nome();
        this.crm = medicoRecord.crm();
        this.especialidade= medicoRecord.especialidade();
        this.telefone = medicoRecord.telefone();
        this.email = medicoRecord.email();
        this.endereco = new Endereco(medicoRecord.endereco());
    }

    public void atualizarDados(AtualizaMedicoDTO dto) {
        if (dto.nome() != null){
            this.nome = dto.nome();
        }
        if (dto.telefone() != null){
            this.telefone = dto.telefone();
        }
        if (dto.endereco() != null){
            this.endereco.atualizarInformacoes(dto.endereco());
        }


    }

    public void excluirMedico() {
        this.ativo = false;
    }
}
