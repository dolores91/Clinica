package com.example.DoloresAleman_Final.service;

import com.example.DoloresAleman_Final.Model.PacienteDTO;
import com.example.DoloresAleman_Final.Model.TurnoDTO;
import com.example.DoloresAleman_Final.controller.OdontologoController;
import com.example.DoloresAleman_Final.exceptions.ResourceNotFoundException;
import com.example.DoloresAleman_Final.persistence.entity.Paciente;
import com.example.DoloresAleman_Final.persistence.entity.Turno;
import com.example.DoloresAleman_Final.persistence.repository.IPacienteRepository;
import com.example.DoloresAleman_Final.persistence.repository.ITurnoRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Service
public class TurnoService {
    protected final static Logger logger = Logger.getLogger(TurnoService.class);
    @Autowired
    private ITurnoRepository repository;
    @Autowired
    ObjectMapper mapper;


    public String registrar(Turno t){
        String respuesta = null;
        if (repository.save(t) != null){
            respuesta = "ok";
        }
        return respuesta;
    }


    public Optional<Turno> buscarPorId(Long id){

        return repository.findById(id);
    }
    public void eliminar(Long id) throws ResourceNotFoundException {
        if (buscarPorId(id) == null)
            throw new ResourceNotFoundException("no existe un domicilio con id: " + id);
        repository.deleteById(id);
    }
    public List<TurnoDTO> buscarTodos(){

        List<TurnoDTO> turnos = new ArrayList<>();

        for(Turno turno: repository.findAll()){
            turnos.add(mapper.convertValue(turno, TurnoDTO.class));
        }
        return turnos;
    }
    public Turno actualizar(Turno turno) {
        return repository.save(turno);
    }
}
