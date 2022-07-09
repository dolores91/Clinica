package com.example.DoloresAleman_Final.service;
import com.example.DoloresAleman_Final.Model.OdontologoDTO;
import com.example.DoloresAleman_Final.exceptions.ResourceNotFoundException;
import com.example.DoloresAleman_Final.persistence.entity.Odontologo;
import com.example.DoloresAleman_Final.persistence.repository.IOdontologoRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class OdontologoService {
    protected final static Logger logger = Logger.getLogger(OdontologoService.class);
    @Autowired
    private IOdontologoRepository repository;
    @Autowired
    ObjectMapper mapper;

    public String registrar(Odontologo o){
        String respuesta = null;
        if (repository.save(o) != null){
            respuesta = "ok";
        }
        return respuesta;
    }

    /*public Optional<Odontologo> buscarPorId(Long id){

        return repository.findById(id);

    }*/
    //mismo metodo pero con excepciones
    public Odontologo buscarPorId(Long id) throws ResourceNotFoundException{
        Odontologo odontologo = repository.findById(id).orElse(null);
        if (odontologo != null){
            return odontologo;
        } else {
            throw new ResourceNotFoundException ("No fue encontrado el odontologo con id " + id);
        }
    }


    public void eliminar(Long id) throws ResourceNotFoundException {
        if (buscarPorId(id) == null)
            throw new ResourceNotFoundException("no existe un domicilio con id: " + id);
        repository.deleteById(id);
    }

    public List<OdontologoDTO> buscarTodos(){

        List<OdontologoDTO> odontologos= new ArrayList<>();

        for(Odontologo odontologo: repository.findAll()){
            odontologos.add(mapper.convertValue(odontologo, OdontologoDTO.class));
        }

        return odontologos;
    }
    public Odontologo actualizar(Odontologo odontologo) {
        return repository.save(odontologo);
    }
}
