package com.pe.innoqa.prices.expose;

import com.pe.innoqa.prices.expose.response.PriceResponse;
import com.pe.innoqa.prices.service.impl.PriceServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import reactor.core.publisher.Mono;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@WebMvcTest(PriceController.class)
class PricesControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    PriceServiceImpl priceService;

    @Test
    public void obtenerProductoTest1() throws Exception{
        PriceResponse response = new PriceResponse();
        response.setPrice(35.5);
        response.setProductId(35455);
        response.setPriceList(1);
        response.setBrandId(1);
        response.setApplicationDate("2020-06-14 10:00:00");

        given(priceService.getListByPricebyDateApplication(any(),anyInt(),anyInt()))
                .willReturn(Mono.just(response));

        mockMvc.perform(get("/price/producto/2020-06-14 10:00:00/35455/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

    }

    @Test
    public void obtenerProductoTest2() throws Exception{
        PriceResponse response = new PriceResponse();
        response.setPrice(25.5);
        response.setProductId(35455);
        response.setPriceList(2);
        response.setBrandId(1);
        response.setApplicationDate("2020-06-14 16:00:00");

        given(priceService.getListByPricebyDateApplication(any(),anyInt(),anyInt()))
                .willReturn(Mono.just(response));

        mockMvc.perform(get("/price/producto/2020-06-14 16:00:00/35455/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

    }

    @Test
    public void obtenerProductoTest3() throws Exception{
        PriceResponse response = new PriceResponse();
        response.setPrice(35.5);
        response.setProductId(35455);
        response.setPriceList(1);
        response.setBrandId(1);
        response.setApplicationDate("2020-06-14 21:00:00");

        given(priceService.getListByPricebyDateApplication(any(),anyInt(),anyInt()))
                .willReturn(Mono.just(response));

        mockMvc.perform(get("/price/producto/2020-06-14 21:00:00/35455/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

    }

    @Test
    public void obtenerProductoTest4() throws Exception{
        PriceResponse response = new PriceResponse();
        response.setPrice(30.5);
        response.setProductId(35455);
        response.setPriceList(3);
        response.setBrandId(1);
        response.setApplicationDate("2020-06-15 10:00:00");

        given(priceService.getListByPricebyDateApplication(any(),anyInt(),anyInt()))
                .willReturn(Mono.just(response));

        mockMvc.perform(get("/price/producto/2020-06-15 10:00:00/35455/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

    }

    @Test
    public void obtenerProductoTest5() throws Exception{
        PriceResponse response = PriceResponse.builder()
                .price(38.95)
                .productId(35455)
                .priceList(4)
                .brandId(1)
                .applicationDate("2020-06-16 21:00:00")
                .build();

        given(priceService.getListByPricebyDateApplication(any(),anyInt(),anyInt()))
                .willReturn(Mono.just(response));

        mockMvc.perform(get("/price/producto/2020-06-16 21:00:00/35455/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

    }

}
