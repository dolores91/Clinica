package com.example.DoloresAleman_Final.controller;

import com.example.DoloresAleman_Final.Model.PacienteDTO;
import com.example.DoloresAleman_Final.persistence.entity.Paciente;
import com.example.DoloresAleman_Final.service.DomicilioService;
import com.example.DoloresAleman_Final.service.PacienteService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {
    protected final static Logger logger = Logger.getLogger(PacienteController.class);
    @Autowired
    PacienteService pacienteservice;
    @Autowired
    DomicilioService domicilioService;

    @PostMapping("/Crear")
    public ResponseEntity<String> crear(@RequestBody Paciente p){
        ResponseEntity<String> respuesta = null;

        if(pacienteservice.guardar(p) != null){
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

        if (pacienteservice.buscarPorId(id) != null) {

            pacienteservice.eliminar(id);
            response = new ResponseEntity<String>("Registro Eliminado ID"+ " " + id, responseHeaders, HttpStatus.OK);
        } else {
            response = ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        return response;

    }


    @PutMapping("/actualizar")
    public ResponseEntity<String> actualizar(@RequestBody Paciente p){
        ResponseEntity<String> respuesta = null;

        if(pacienteservice.guardar(p) != null){
            respuesta = ResponseEntity.ok("El Registro fue actualizado con Exito");
        }else{
            respuesta = ResponseEntity.internalServerError().body("Ooops");
        }

        return respuesta;
    }


    @GetMapping("/{id}")
    public Optional<Paciente> buscarPorId(@PathVariable Long id){

        return pacienteservice.buscarPorId(id);
    }


    @GetMapping("/ConsultarTodos")
    public ResponseEntity<List<PacienteDTO>> consultarTodos(){

        return ResponseEntity.ok(pacienteservice.buscarTodos());
    }

}
