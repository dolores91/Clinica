package com.example.DoloresAleman_Final.controller;

import com.example.DoloresAleman_Final.Model.TurnoDTO;
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


    @PostMapping("/Crear")
    public ResponseEntity<String> crear(@RequestBody Turno t){
        ResponseEntity<String> respuesta = null;

        if(turnoService.guardar(t) != null){
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

        if (turnoService.buscarPorId(id) != null) {

            turnoService.eliminar(id);
            response = new ResponseEntity<String>("Registro Eliminado ID"+ " " + id, responseHeaders, HttpStatus.OK);
        } else {
            response = ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        return response;

    }

    @PutMapping("/actualizar")
    public ResponseEntity<String> actualizar(@RequestBody Turno t){
        ResponseEntity<String> respuesta = null;

        if(turnoService.guardar(t) != null){
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


    @GetMapping("/ConsultarTodos")
    public ResponseEntity<List<TurnoDTO>> consultarTodos(){

        return ResponseEntity.ok(turnoService.buscarTodos());
    }

}
