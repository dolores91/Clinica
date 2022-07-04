package com.example.DoloresAleman_Final.persistence.repository;

import com.example.DoloresAleman_Final.persistence.entity.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPacienteRepository extends JpaRepository<Paciente, Long> {
}
