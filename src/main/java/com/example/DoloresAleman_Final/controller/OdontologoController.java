package com.example.DoloresAleman_Final.controller;

import com.example.DoloresAleman_Final.Model.OdontologoDTO;
import com.example.DoloresAleman_Final.persistence.entity.Odontologo;
import com.example.DoloresAleman_Final.persistence.repository.IOdontologoRepository;
import com.example.DoloresAleman_Final.service.OdontologoService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/odontologos")

public class OdontologoController {
    protected final static Logger logger = Logger.getLogger(OdontologoController.class);
    @Autowired
    OdontologoService odontologoService;


    @PostMapping("/Crear")
    public ResponseEntity<String> crear(@RequestBody Odontologo o){
        ResponseEntity<String> respuesta = null;

        if(odontologoService.guardar(o) != null){
            respuesta = ResponseEntity.ok("El Registro fue creado");
        }else{
            respuesta = ResponseEntity.internalServerError().body("Error");
        }

        return respuesta;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminar(@PathVariable Long id) {

        HttpHeaders responseHeaders = new HttpHeaders();

        ResponseEntity<String> response = null;

        if (odontologoService.buscarPorId(id) != null) {

            odontologoService.eliminar(id);
            response = new ResponseEntity<String>("Registro Eliminado ID"+ " " + id, responseHeaders, HttpStatus.OK);
        } else {
            response = ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        return response;

    }

    @PutMapping("/actualizar")
    public ResponseEntity<String> actualizar(@RequestBody Odontologo o){
        ResponseEntity<String> respuesta = null;

        if(odontologoService.guardar(o) != null){
            respuesta = ResponseEntity.ok("El Registro fue actualizado");
        }else{
            respuesta = ResponseEntity.internalServerError().body("Error");
        }

        return respuesta;
    }


    @GetMapping("/{id}")
    public Optional<Odontologo> buscarPorId(@PathVariable Long id){

        return odontologoService.buscarPorId(id);
    }


    @GetMapping("/ConsultarTodos")
    public ResponseEntity<List<OdontologoDTO>> consultarTodos(){

        return ResponseEntity.ok(odontologoService.buscarTodos());
    }



}
