package com.example.DoloresAleman_Final.controller;

import com.example.DoloresAleman_Final.Model.PacienteDTO;
import com.example.DoloresAleman_Final.exceptions.ResourceNotFoundException;
import com.example.DoloresAleman_Final.persistence.entity.Paciente;
import com.example.DoloresAleman_Final.service.DomicilioService;
import com.example.DoloresAleman_Final.service.PacienteService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {
    protected final static Logger logger = Logger.getLogger(PacienteController.class);
    @Autowired
    PacienteService pacienteService;
    @Autowired
    DomicilioService domicilioService;

    @PostMapping("/registrar")
    public ResponseEntity<String> registar(@RequestBody Paciente p){
        ResponseEntity<String> respuesta = null;

        if(pacienteService.registrar(p) != null){
            respuesta = ResponseEntity.ok("El Registro fue creado");
        }else{
            respuesta = ResponseEntity.internalServerError().body("Error");
        }

        return respuesta;
    }

   /* @DeleteMapping("/{id}")
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

    }*/
    //mismo metodo pero con excepciones
   @DeleteMapping("/{id}")
   public ResponseEntity<String> eliminar(@PathVariable Long id)throws ResourceNotFoundException {
       pacienteService.eliminar(id);
       return ResponseEntity.ok("eliminado");
   }

    @PutMapping("/actualizar")
    public ResponseEntity<String> actualizar(@RequestBody Paciente p){
        ResponseEntity<String> respuesta = null;

        if(pacienteService.registrar(p) != null){
            respuesta = ResponseEntity.ok("El Registro fue actualizado con Exito");
        }else{
            respuesta = ResponseEntity.internalServerError().body("Ooops");
        }

        return respuesta;
    }

   /* @GetMapping("/{id}")
    public Optional<Paciente> buscarPorId(@PathVariable Long id){

        return pacienteservice.buscarPorId(id);
    }*/
    //mismo metodo pero con excepciones
    @GetMapping("/{id}")
    public ResponseEntity<?> buscarPorIs(Long id) throws ResourceNotFoundException {
        return ResponseEntity.ok(pacienteService.buscarPorId(id));
    }

    @GetMapping("/consultarTodos")
    public ResponseEntity<List<PacienteDTO>> consultarTodos(){

        return ResponseEntity.ok(pacienteService.buscarTodos());
    }

}

