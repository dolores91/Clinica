package com.example.DoloresAleman_Final;

import com.example.DoloresAleman_Final.exceptions.ResourceNotFoundException;
import com.example.DoloresAleman_Final.persistence.entity.Domicilio;
import com.example.DoloresAleman_Final.persistence.entity.Paciente;
import com.example.DoloresAleman_Final.service.DomicilioService;
import com.example.DoloresAleman_Final.service.PacienteService;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PacienteServiceTest {
    @Autowired
    private PacienteService pacienteService;
    @Autowired
    private DomicilioService domicilioService;

    public void cargarDataSet() {
      //  Domicilio domicilio = new Domicilio("Av Santa fe", "444", "CABA", "Buenos Aires");
        //Paciente p = pacienteService.guardar(new Paciente("Santiago", "Paz", "88888888", new Date(), domicilio));
       // Domicilio domicilio1 = new Domicilio("Av Avellaneda", "333", "CABA", "Buenos Aires");
        //Paciente p1 = pacienteService.guardar(new Paciente("Micaela", "Perez", "99999999", new Date(), domicilio));

    }

    @Test
    public void agregarYBuscarPacienteTest() {
        this.cargarDataSet();
      //  Domicilio domicilio = new Domicilio("Calle", "123", "Temperley", "Buenos Aires");
       // Paciente p = pacienteService.guardar(new Paciente("Tomas", "Pereyra", "12345678", new Date(), domicilio));

       // Assert.assertNotNull(pacienteService.buscarPorId(p.getId()));
    }

    @Test
    public void eliminarPacienteTest() throws ResourceNotFoundException {
        pacienteService.eliminar(3L);
        Assert.assertTrue(pacienteService.buscarPorId(3L).isEmpty());

    }
/*
    @Test
    public void traerTodos() {
        List<Paciente> pacientes = pacienteService.buscarTodos();
        Assert.assertTrue(!pacientes.isEmpty());
        Assert.assertTrue(pacientes.size() == 2);
        System.out.println(pacientes);
    }*/

    @org.junit.jupiter.api.Test
    void testGuardar() {
    }

    @org.junit.jupiter.api.Test
    void testEliminar() {
    }

    @org.junit.jupiter.api.Test
    void testBuscarPorId() {
    }

    @org.junit.jupiter.api.Test
    void testBuscarTodos() {
    }


}