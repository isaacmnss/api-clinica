package com.alura.medapi.repository;

import com.alura.medapi.model.Medico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MedicoRepository extends JpaRepository <Medico, Long> {

    List<Medico> findAllByAtivo(short ativo);

}
