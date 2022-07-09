package com.example.DoloresAleman_Final;

import com.example.DoloresAleman_Final.Model.OdontologoDTO;
import com.example.DoloresAleman_Final.controller.OdontologoController;
import com.example.DoloresAleman_Final.util.Jsons;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;


@SpringBootTest
@AutoConfigureMockMvc(addFilters = false)
public class IntegracionOdontologoTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void registrar() throws Exception {
        OdontologoDTO od = new OdontologoDTO("dolores", "aleman", "436");
        MvcResult response = this.mockMvc.perform(MockMvcRequestBuilders.post("/odontologos/registrar")
                .contentType(MediaType.APPLICATION_JSON)
                .content(Jsons.asJsonString(od)))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk()).andReturn();

        Assert.assertFalse(response.getResponse().getContentAsString().isEmpty());
    }


}
//hacer lo mismo con otro status o sea q de error