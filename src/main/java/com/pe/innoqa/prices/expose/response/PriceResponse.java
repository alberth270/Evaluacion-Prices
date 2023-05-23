package com.pe.innoqa.prices.expose.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * <b>Class</b>: PriceResonse <br/>
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

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PriceResponse {
    private Integer productId;
    private Integer brandId;
    private Integer priceList;
    private String applicationDate;
    private Double price;
}
