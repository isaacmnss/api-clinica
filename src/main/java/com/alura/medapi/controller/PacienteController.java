package com.alura.medapi.controller;

import com.alura.medapi.DTO.AtualizaPacienteDTO;
import com.alura.medapi.DTO.ListarPacienteDTO;
import com.alura.medapi.model.Paciente;
import com.alura.medapi.model.PacienteRecord;
import com.alura.medapi.repository.PacienteRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {

    @Autowired
    private PacienteRepository repository;

    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody @Valid PacienteRecord dados) {
        repository.save(new Paciente(dados));
    }

    @GetMapping
    public Page<ListarPacienteDTO> listar(@PageableDefault(size = 10, sort = {"nome"}) Pageable paginacao) {
        return repository.findAllByAtivoTrue(paginacao).map(ListarPacienteDTO::new);
    }

    @PutMapping
    @Transactional
    public void atualizar(@RequestBody @Valid AtualizaPacienteDTO dados) {
        var paciente = repository.getReferenceById(dados.id());
        paciente.atualizarInformacoes(dados);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void excluir(@PathVariable Long id) {
        var paciente = repository.getReferenceById(id);
        paciente.excluir();
    }


}
