package com.example.personacrud.useCases;



import com.example.personacrud.repository.IPersonDataRepository;
import com.example.personacrud.repository.PersonData;
import com.example.personacrud.useCases.TransformacionUseCase;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.hamcrest.Matchers.*;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class PersonControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private IPersonDataRepository data;

    @MockBean
    private TransformacionUseCase transformacionUseCase;

    @Test
    @DisplayName("POST /api/guardar Success")
    public void guardarTest() throws Exception{
        String id = "1234";
        String name = "Pedro Picapiedra";
        String phone = "555-7245";
        Boolean professional = Boolean.FALSE;

        //Mockito.when(data.save(any())).thenReturn(new Person(new PersonId(id), new Name(name), new Phone(phone), new IsProfessional(professional)));

        mockMvc.perform( MockMvcRequestBuilders
                .post("/api/guardar/{id}/{name}/{phone}/{professional}", id, name, phone, professional)
                .accept(MediaType.TEXT_PLAIN))
                .andExpect(status().isOk())
                .andExpect(content().string("{\"idPerson\":\"1234\",\"name\":\"Pedro Picapiedra\",\"phone\":\"555-7245\",\"isProssional\":false}"));


    }

    @Test
    @DisplayName("GET /api/findPerson Success")
    public void listarId() throws Exception {

        Mockito.when(transformacionUseCase.listarId("1")).thenReturn(new PersonData("1234", "Pedro Picapiedra", "555-7245", Boolean.FALSE));

        mockMvc.perform( MockMvcRequestBuilders
                .get("/api/findPerson/{id}", "1")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is("1234")))
                .andExpect(jsonPath("$.name", is("Pedro Picapiedra")));
    }


}