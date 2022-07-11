package com.example.DoloresAleman_Final;
import com.example.DoloresAleman_Final.Model.PacienteDTO;
import com.example.DoloresAleman_Final.util.Jsons;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@AutoConfigureMockMvc(addFilters = false)
public class IntegracionPacienteTest {
    @Autowired
    private MockMvc mockMvc;

        @Test
        public void registrarPaciente() throws Exception {
            PacienteDTO p = new PacienteDTO("juan","Rolon","juan@hotmail.com","33555444");
            MvcResult response = this.mockMvc.perform(MockMvcRequestBuilders.post("/pacientes/registrar")
                            .contentType(MediaType.APPLICATION_JSON)
                            .content(Jsons.asJsonString(p)))
                    .andDo(MockMvcResultHandlers.print())
                    .andExpect(MockMvcResultMatchers.status().isOk()).andReturn();

            Assert.assertFalse(response.getResponse().getContentAsString().isEmpty());

        }

        @Test
        public void buscarPacientesPorNombreInexistente() throws Exception {
            MvcResult response = mockMvc.perform(MockMvcRequestBuilders
                            .get("/pacientes")
                            .param("nombre", "José")
                    )
                    .andDo(MockMvcResultHandlers.print())
                    .andExpect(MockMvcResultMatchers.status().isOk())
                    .andReturn();
            assertEquals("[]", response.getResponse().getContentAsString());
        }

        @Test
        public void eliminarPaciente() throws Exception {
            mockMvc.perform(MockMvcRequestBuilders.delete("/pacientes/{id}", "1"))
                    .andDo(MockMvcResultHandlers.print())
                    .andExpect(MockMvcResultMatchers.status().isOk())
                    .andReturn();
        }

        @Test
        public void consultarTodosLosPacientes() throws Exception {
            mockMvc.perform(MockMvcRequestBuilders.get("/pacientes"))
                    .andDo(MockMvcResultHandlers.print())
                    .andExpect(MockMvcResultMatchers.status().isOk())
                    .andReturn();
        }
    }