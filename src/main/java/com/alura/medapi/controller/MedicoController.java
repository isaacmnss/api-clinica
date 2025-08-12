package com.alura.medapi.controller;

import com.alura.medapi.DTO.AtualizaMedicoDTO;
import com.alura.medapi.DTO.MedicoDTO;
import com.alura.medapi.model.Medico;
import com.alura.medapi.model.MedicoRecord;
import com.alura.medapi.service.MedicoService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/medicos")
public class MedicoController {

    @Autowired
    private MedicoService medicoService;

    @PostMapping
    @Transactional
    public void cadastrarMedico(@RequestBody @Valid MedicoRecord dados){
        medicoService.cadastrarMedico(dados);
    }

    @GetMapping
    public Page<MedicoDTO> listarMedicos(@PageableDefault(size = 10, sort = {"nome"}) Pageable paginacao){
        return medicoService.listarMedicos(paginacao);
    }

    @PutMapping
    @Transactional
    public void atualizarMedico(@RequestBody @Valid AtualizaMedicoDTO dto){
        medicoService.atualizarMedico(dto);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void deletarMedico(@PathVariable Long id){
        medicoService.deletarMedico(id);
    }
}
