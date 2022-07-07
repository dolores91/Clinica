package com.example.DoloresAleman_Final.service;

import com.example.DoloresAleman_Final.Model.DomicilioDTO;
import com.example.DoloresAleman_Final.controller.OdontologoController;
import com.example.DoloresAleman_Final.exceptions.ResourceNotFoundException;
import com.example.DoloresAleman_Final.persistence.entity.Domicilio;
import com.example.DoloresAleman_Final.persistence.repository.IDomicilioRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


//los service podrian hacerse tmb mediante interfaz
@Service
public class DomicilioService {
    protected final static Logger logger = Logger.getLogger(DomicilioService.class);
    @Autowired
    private IDomicilioRepository repository;
    @Autowired                                           //esto estaba distinto
    ObjectMapper mapper;


    public String guardar(Domicilio d){
        String respuesta = null;
        if (repository.save(d) != null){
            respuesta = "ok";
        }
        return respuesta;
    }
/*ver si funciona este->
    public void guardar(DomicilioDTO domicilioDTO){
        Domicilio domicilio = mapper.convertValue(domicilioDTO, Domicilio.class);
        repository.save(domicilio);
    }*/

    /*public void eliminar(Long id){
        repository.deleteById(id);
    }*/
    //mismo metodo pero con excepciones
    public void eliminar(Long id) throws ResourceNotFoundException {
        if (buscarPorId(id) == null)
            throw new ResourceNotFoundException("no existe un domicilio con id: " + id);
        repository.deleteById(id);
    }

                                  //ver el otro 3 min12
    public Optional<Domicilio> buscarPorId(Long id){

        return repository.findById(id);
    }

    public List<DomicilioDTO> buscarTodos(){

        List<DomicilioDTO> domicilios = new ArrayList<>();

        for(Domicilio domicilio: repository.findAll()){
            domicilios.add(mapper.convertValue(domicilio, DomicilioDTO.class));
        }

        return domicilios;
    }


}
