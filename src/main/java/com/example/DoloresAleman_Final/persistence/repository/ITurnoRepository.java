package com.example.DoloresAleman_Final.persistence.repository;
import com.example.DoloresAleman_Final.persistence.entity.Turno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITurnoRepository extends JpaRepository<Turno, Long> {
}
