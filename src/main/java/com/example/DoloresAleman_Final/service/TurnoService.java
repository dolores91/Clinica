package com.example.DoloresAleman_Final.service;
import com.example.DoloresAleman_Final.Model.TurnoDTO;
import com.example.DoloresAleman_Final.exceptions.ResourceNotFoundException;
import com.example.DoloresAleman_Final.persistence.entity.Turno;
import com.example.DoloresAleman_Final.persistence.repository.ITurnoRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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

/*    public Optional<Turno> buscarPorId(Long id){

        return repository.findById(id);
    }*/
    //mismo metodo pero con excepciones
    public Turno buscarPorId(Long id) throws ResourceNotFoundException {
        Turno turno = repository.findById(id).orElse(null);
        if (turno != null){
            return turno;
        } else {
            throw new ResourceNotFoundException ("No fue encontrado el odontologo con id " + id);
        }
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

    private Boolean verificarDisponibilidad(Long idOdontologo, LocalDate fechaTurno) {
        Boolean respuesta = true;
        List<Turno> listaTurnos = repository.findAll();
        for (Turno turno : listaTurnos){
            if (turno.getOdontologo().getId().equals(idOdontologo) && turno.getDate().equals(fechaTurno)){
                respuesta = false;
            }
        }
        return respuesta;
    }
}
