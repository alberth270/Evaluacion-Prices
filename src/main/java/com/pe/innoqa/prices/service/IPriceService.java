package com.pe.innoqa.prices.service;

import com.pe.innoqa.prices.expose.response.PriceResponse;
import reactor.core.publisher.Mono;

/**
 * <b>Class</b>: IPriceService <br/>
 * <b>Copyright</b>: 2023 INNOQA <br/>.
 *
 * @author 2023  INNOQA <br/>
 * <u>Service Provider</u>: INNOQA <br/>
 * <u>Developed by</u>: INNOQA <br/>
 * <u>Changes:</u><br/>
 * <ul>
 *   <li>
 *     Mayo 22, 2022  Creación de Interface.
 *   </li>
 * </ul>
 */
public interface IPriceService {
    Mono<PriceResponse> getListByPricebyDateApplication(String fecha, Integer productoId, Integer cadenaId);

}
