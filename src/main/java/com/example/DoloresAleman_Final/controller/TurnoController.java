package com.example.DoloresAleman_Final.controller;

import com.example.DoloresAleman_Final.Model.TurnoDTO;
import com.example.DoloresAleman_Final.exceptions.ResourceNotFoundException;
import com.example.DoloresAleman_Final.persistence.entity.Turno;
import com.example.DoloresAleman_Final.service.TurnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/turnos")
public class TurnoController {

    @Autowired
    private TurnoService turnoService;


    @PostMapping("/registrar")
    public ResponseEntity<String> registrar(@RequestBody Turno t){
        ResponseEntity<String> respuesta = null;

        if(turnoService.registrar(t) != null){
            respuesta = ResponseEntity.ok("El Registro fue creado");
        }else{
            respuesta = ResponseEntity.internalServerError().body("Error");
        }

        return respuesta;
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminar(@PathVariable Long id)throws ResourceNotFoundException {
        turnoService.eliminar(id);
        return ResponseEntity.ok("eliminado");
    }

    @PutMapping("/actualizar")
    public ResponseEntity<String> actualizar(@RequestBody Turno t){
        ResponseEntity<String> respuesta = null;

        if(turnoService.registrar(t) != null){
            respuesta = ResponseEntity.ok("El Registro fue actualizado");
        }else{
            respuesta = ResponseEntity.internalServerError().body("Error");
        }

        return respuesta;
    }


    @GetMapping("/{id}")
    public Optional<Turno> buscarPorId(@PathVariable Long id){

        return turnoService.buscarPorId(id);
    }


    @GetMapping("/consultarTodos")
    public ResponseEntity<List<TurnoDTO>> consultarTodos(){

        return ResponseEntity.ok(turnoService.buscarTodos());
    }

}
