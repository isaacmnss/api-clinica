package com.alura.medapi.controller;

import com.alura.medapi.DTO.AtualizaMedicoDTO;
import com.alura.medapi.DTO.MedicoDTO;
import com.alura.medapi.model.MedicoRecord;
import com.alura.medapi.service.MedicoService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;



@RestController
@RequestMapping("/medicos")
public class MedicoController {

    @Autowired
    private MedicoService medicoService;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrarMedico(@RequestBody @Valid MedicoRecord dados, UriComponentsBuilder uriBuilder){
        return medicoService.cadastrarMedico(dados, uriBuilder);
    }

    @GetMapping
    public ResponseEntity<Page<MedicoDTO>> listarMedicos(@PageableDefault(size = 5, sort = {"nome"}) Pageable paginacao){
        return medicoService.listarMedicos(paginacao);
    }

    @GetMapping("/{id}")
    public ResponseEntity buscarMedico(@PathVariable Long id){
        return medicoService.buscarMedico(id);
    }

    @PutMapping
    @Transactional
    public ResponseEntity atualizarMedico(@RequestBody @Valid AtualizaMedicoDTO dto){
        return medicoService.atualizarMedico(dto);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity deletarMedico(@PathVariable Long id){
        return medicoService.deletarMedico(id);
    }
}
