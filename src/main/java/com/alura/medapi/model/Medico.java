package com.alura.medapi.model;

import com.alura.medapi.DTO.EnderecoDTO;
import com.alura.medapi.DTO.MedicoDTO;
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

    @Enumerated(EnumType.STRING)
    private Especialidade especialidade;

    @Embedded
    private Endereco endereco;

    public Medico(MedicoDTO medicoDTO){
        this.nome = medicoDTO.nome();
        this.crm = medicoDTO.crm();
        this.email = medicoDTO.email();
        this.endereco = new Endereco(medicoDTO.enderecoDTO());
    }

}
