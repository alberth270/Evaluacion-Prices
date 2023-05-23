package com.pe.innoqa.prices.service.impl;

import com.pe.innoqa.prices.expose.response.PriceResponse;
import com.pe.innoqa.prices.repository.IPriceRepository;
import com.pe.innoqa.prices.service.IPriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

/**
 * <b>Class</b>: PriceServiceImpl <br/>
 * <b>Copyright</b>: 2023 INNOQA <br/>.
 *
 * @author 2023  INNOQA <br/>
 * <u>Service Provider</u>: INNOQA <br/>
 * <u>Developed by</u>: INNOQA <br/>
 * <u>Changes:</u><br/>
 * <ul>
 *   <li>
 *     Mayo 22, 2022  Creación de Clase.
 *   </li>
 * </ul>
 */

@Service
public class PriceServiceImpl implements IPriceService {

    @Autowired
    private IPriceRepository priceRepository;

    @Override
    public Mono<PriceResponse> getListByPricebyDateApplication(String fecha, Integer productoId, Integer cadenaId) {
        return Mono.just(priceRepository.
                getPriceByFechaVigencia(fecha, productoId,cadenaId)
                .stream().findFirst()
                .map(response -> PriceResponse.builder()
                        .brandId(response.getRetail().getId())
                        .priceList(response.getPriceList())
                        .price(response.getPrice())
                        .productId(response.getProductId())
                        .applicationDate(fecha)
                        .build())
                .orElse(new PriceResponse()));
    }
}