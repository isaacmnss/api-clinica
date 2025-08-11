package com.alura.medapi.model;

import com.alura.medapi.DTO.EnderecoDTO;
import jakarta.persistence.Embeddable;

@Embeddable
public class Endereco {
    private String logradouro;
    private String bairro;
    private String cep;
    private String numero;
    private String complemento;
    private String cidade;
    private String uf;

    public Endereco(EnderecoDTO enderecoDTO){
        this.logradouro = enderecoDTO.logradouro();
        this.bairro = enderecoDTO.bairro();
        this.cep = enderecoDTO.cep();
        this.numero = enderecoDTO.numero();
        this.complemento = enderecoDTO.complemento();
        this.cidade = enderecoDTO.cidade();
        this.uf = enderecoDTO.uf();
    }
}
