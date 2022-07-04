package com.example.DoloresAleman_Final.persistence.repository;

import com.example.DoloresAleman_Final.persistence.entity.Domicilio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IDomicilioRepository extends JpaRepository<Domicilio, Long> { //usa extens xq son dos interfaces
}
