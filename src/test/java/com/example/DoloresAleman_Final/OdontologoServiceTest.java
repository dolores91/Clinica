package com.example.DoloresAleman_Final;

import com.example.DoloresAleman_Final.Model.OdontologoDTO;
import com.example.DoloresAleman_Final.persistence.entity.Odontologo;
import com.example.DoloresAleman_Final.service.OdontologoService;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
class OdontologoServiceTest {
    @Autowired
    OdontologoService odontologoService;

    @Test
    public void testGuardarOdontologo(){

    Odontologo odontologo = new Odontologo();
    odontologo.setApellido("Martinez");
    odontologo.setNombre("Juan");
    odontologo.setMatricula("124");
    odontologoService.guardar(odontologo);

    //Odontologo odontologoJuan = odontologoService.buscarPorId(1L);
    //assertTrue(odontologoJuan !=null);
    }
    /*
    public void cargarDataSet() {
        this.odontologoService.registrarOdontologo(new Odontologo("Santiago", "Paz", 3455647));


    }

    @org.junit.Test
    public void agregarOdontologo() {
        this.cargarDataSet();
        Odontologo odontologo = odontologoService.registrarOdontologo(new Odontologo("Juan", "Ramirez", 348971960));
        Assert.assertTrue(odontologo.getId() != null);

    }

    @org.junit.Test
    public void eliminarOdontologoTest() throws ResourceNotFoundException {
        odontologoService.eliminar(1);
        Assert.assertTrue(odontologoService.buscar(1).isEmpty());

    }

    @org.junit.Test
    public void traerTodos() {
        List<Odontologo> odontologos = odontologoService.buscarTodos();
        Assert.assertTrue(!odontologos.isEmpty());
        Assert.assertTrue(odontologos.size() == 1);
        System.out.println(odontologos);
    }


*/
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