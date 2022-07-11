package com.example.DoloresAleman_Final.service;
import com.example.DoloresAleman_Final.Model.PacienteDTO;
import com.example.DoloresAleman_Final.exceptions.ResourceNotFoundException;
import com.example.DoloresAleman_Final.persistence.entity.Paciente;
import com.example.DoloresAleman_Final.persistence.repository.IPacienteRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class PacienteService {
    protected final static Logger logger = Logger.getLogger(PacienteService.class);
    @Autowired
    private IPacienteRepository repository;
    @Autowired
    ObjectMapper mapper;


    public String registrar(Paciente p) {
        String respuesta = null;
        if (repository.save(p) != null) {
            respuesta = "ok";
        }
        return respuesta;
    }

   /* public Optional<Paciente> buscarPorId(Long id) {

        return repository.findById(id);
    }*/
   //mismo metodo pero con excepciones
    public Paciente buscarPorId(Long id) throws ResourceNotFoundException {
        Paciente paciente = repository.findById(id).orElse(null);
        if (paciente != null){
            return paciente;
        } else {
            throw new ResourceNotFoundException ("No fue encontrado el odontologo con id " + id);
        }
    }

    /*public void eliminar(Long id){
        repository.deleteById(id);
    }*/
    //mismo metodo pero con excepciones
    public void eliminar(Long id) throws ResourceNotFoundException {
        if (buscarPorId(id) == null)
            throw new ResourceNotFoundException("no existe un paciente con id: " + id);
        repository.deleteById(id);
    }

        public List<PacienteDTO> buscarTodos () {

            List<PacienteDTO> pacientes = new ArrayList<>();

            for (Paciente paciente : repository.findAll()) {
                pacientes.add(mapper.convertValue(paciente, PacienteDTO.class));
            }
            return pacientes;
        }
    public Paciente actualizar(Paciente paciente) {
        return repository.save(paciente);
    }
    }

