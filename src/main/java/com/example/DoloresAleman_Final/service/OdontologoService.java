package com.example.DoloresAleman_Final.service;

import com.example.DoloresAleman_Final.Model.DomicilioDTO;
import com.example.DoloresAleman_Final.Model.OdontologoDTO;
import com.example.DoloresAleman_Final.controller.OdontologoController;
import com.example.DoloresAleman_Final.persistence.entity.Domicilio;
import com.example.DoloresAleman_Final.persistence.entity.Odontologo;
import com.example.DoloresAleman_Final.persistence.repository.IDomicilioRepository;
import com.example.DoloresAleman_Final.persistence.repository.IOdontologoRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Service
public class OdontologoService {
    protected final static Logger logger = Logger.getLogger(OdontologoService.class);
    @Autowired
    private IOdontologoRepository repository;
    @Autowired
    ObjectMapper mapper;



    public String guardar(Odontologo o){
        String respuesta = null;
        if (repository.save(o) != null){
            respuesta = "ok";
        }
        return respuesta;
    }

    public void eliminar(Long id){
        repository.deleteById(id);
    }

    public Optional<Odontologo> buscarPorId(Long id){

        return repository.findById(id);

    }
    public List<OdontologoDTO> buscarTodos(){

        List<OdontologoDTO> odontologos= new ArrayList<>();

        for(Odontologo odontologo: repository.findAll()){
            odontologos.add(mapper.convertValue(odontologo, OdontologoDTO.class));
        }

        return odontologos;
    }
}
