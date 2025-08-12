package com.alura.medapi.model;

import jakarta.persistence.Embeddable;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Endereco {
    private String logradouro;
    private String bairro;
    private String cep;
    private String numero;
    private String complemento;
    private String cidade;
    private String uf;

    public Endereco(EnderecoRecord enderecoRecord){

        System.out.println("DEBUG - EnderecoDTO recebido: " + enderecoRecord); // ← verifique se chega null
        if (enderecoRecord == null) {
            throw new IllegalArgumentException("EnderecoDTO é nulo!");
        }

        this.logradouro = enderecoRecord.logradouro();
        this.bairro = enderecoRecord.bairro();
        this.cep = enderecoRecord.cep();
        this.numero = enderecoRecord.numero();
        this.complemento = enderecoRecord.complemento();
        this.cidade = enderecoRecord.cidade();
        this.uf = enderecoRecord.uf();
    }

    public void atualizarInformacoes(EnderecoRecord endereco) {

        if (endereco.logradouro() != null){
            this.logradouro = endereco.logradouro();
        }

        if (endereco.bairro() != null){
            this.bairro = endereco.bairro();
        }

        if (endereco.cep() != null){
            this.cep = endereco.cep();
        }
        if (endereco.numero() != null){
            this.numero = endereco.numero();
        }
        if (endereco.complemento() != null){
            this.complemento = endereco.complemento();
        }
        if (endereco.cidade() != null){
            this.cidade = endereco.cidade();
        }
        if (endereco.uf() != null){
            this.uf = endereco.uf();
        }

    }
}
