package com.pe.innoqa.prices.service;

import com.pe.innoqa.prices.entity.Brand;
import com.pe.innoqa.prices.entity.Prices;
import com.pe.innoqa.prices.expose.response.PriceResponse;
import com.pe.innoqa.prices.repository.IPriceRepository;
import com.pe.innoqa.prices.service.impl.PriceServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Calendar;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class PricesServiceTest {

    @InjectMocks
    private PriceServiceImpl priceService;

    @Mock
    private IPriceRepository priceRepository;

    private static List<Prices> listPrices;

    @BeforeEach
    void setUp() {
        listPrices = List.of(Prices.builder()
                        .id(1L)
                        .startDate(Calendar.getInstance())
                        .endDate(Calendar.getInstance())
                        .retail(Brand.builder()
                                .id(1)
                                .name("ZARA")
                                .build())
                        .priority(1)
                        .priceList(1)
                        .productId(354556)
                        .price(58.50)
                        .curr("EUR")
                .build());
        PriceResponse priceResponse= new PriceResponse();
        Brand brand01 = new Brand(1,"ZARA");
        Brand brand02 = new Brand();
        brand02.setId(brand01.getId());
        brand02.setName(brand01.getName()+"2");

        Prices prices = new Prices();
    }

    @Test
    void getListByPricebyDateApplicationTest(){
        when(priceRepository.getPriceByFechaVigencia(any(),any(),any()))
                .thenReturn(listPrices);

        priceService.getListByPricebyDateApplication(anyString(), anyInt(),anyInt())
                .subscribe(response -> {
                    assertNotNull(response);
                });
    }
}
