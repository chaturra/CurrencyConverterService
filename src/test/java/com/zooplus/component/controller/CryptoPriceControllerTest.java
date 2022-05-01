package com.zooplus.component.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.zooplus.component.ComponentTest;
import com.zooplus.facade.CryptoPriceFacade;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ComponentTest
@AutoConfigureMockMvc
class CryptoPriceControllerTest {


    @Autowired
    private MockMvc mockMvc;

    private ObjectMapper objectMapper;

    @MockBean
    private CryptoPriceFacade cryptoPriceFacade;

    @BeforeEach
    void setUp() {
        objectMapper = new ObjectMapper();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    public void getReferenceRates_withIp() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/v1/zoo/cryptoRates/{cryptoCurrencyCode}/{ip}/",
                "Bitcoin", "172.28.162.1")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().is2xxSuccessful());
        Mockito.verify(cryptoPriceFacade).getPrice(Mockito.any(), Mockito.any());
    }

    @Test
    public void getReferenceRates_withoutIp()  throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/v1/zoo/cryptoRates/{cryptoCurrencyCode}/",
                "Bitcoin")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().is2xxSuccessful());
        Mockito.verify(cryptoPriceFacade).getPrice(Mockito.any(), Mockito.any());
    }
}