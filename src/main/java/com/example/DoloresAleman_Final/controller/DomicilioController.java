package com.example.DoloresAleman_Final.controller;
import com.example.DoloresAleman_Final.Model.DomicilioDTO;
import com.example.DoloresAleman_Final.exceptions.ResourceNotFoundException;
import com.example.DoloresAleman_Final.persistence.entity.Domicilio;
import com.example.DoloresAleman_Final.service.DomicilioService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/domicilios")
public class DomicilioController {
    protected final static Logger logger = Logger.getLogger(DomicilioController.class);
    @Autowired
    DomicilioService domicilioService;

    @PostMapping("/registrar")
    public ResponseEntity<String> registrar(@RequestBody Domicilio d){
        ResponseEntity<String> respuesta = null;

        if(domicilioService.registar(d) != null){
            respuesta = ResponseEntity.ok("El Registro fue creado");
        }else{
            respuesta = ResponseEntity.internalServerError().body("Error");
        }

        return respuesta;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminar(@PathVariable Long id)throws ResourceNotFoundException {
        domicilioService.eliminar(id);
        return ResponseEntity.ok("eliminado");
    }

    @PutMapping("/actualizar")
    public ResponseEntity<String> actualizar(@RequestBody Domicilio d){
        ResponseEntity<String> respuesta = null;

        if(domicilioService.registar(d) != null){
            respuesta = ResponseEntity.ok("El Registro fue actualizado con Exito");
        }else{
            respuesta = ResponseEntity.internalServerError().body("Ooops");
        }

        return respuesta;
    }
    @GetMapping("/{id}")
    public Optional<Domicilio> buscarPorId(@PathVariable Long id){

        return domicilioService.buscarPorId(id);
    }

    @GetMapping("/consultarTodos")
    public ResponseEntity<List<DomicilioDTO>> consultarTodos() {

        return ResponseEntity.ok(domicilioService.buscarTodos());
    }

}
