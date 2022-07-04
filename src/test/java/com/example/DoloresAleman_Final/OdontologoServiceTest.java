package com.example.DoloresAleman_Final;

import com.example.DoloresAleman_Final.Model.OdontologoDTO;
import com.example.DoloresAleman_Final.persistence.entity.Odontologo;
import com.example.DoloresAleman_Final.service.OdontologoService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
class OdontologoServiceTest {
    @Autowired
    OdontologoService odontologoService;

    @Test
    public void testGuardarOdontologo(){

    Odontologo odontologo = new Odontologo ("Juan","Martinez","1");
    odontologo.setApellido("Martinez");
    odontologo.setNombre("Juan");
    odontologo.setMatricula("124");
    odontologoService.guardar(odontologo);

    //Odontologo odontologoJuan = odontologoService.buscarPorId(1L);
    //assertTrue(odontologoJuan !=null);



    }




}