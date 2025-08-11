package com.alura.medapi.Repository;

import com.alura.medapi.model.Medico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicoRepository extends JpaRepository <Medico, Long> {
}
