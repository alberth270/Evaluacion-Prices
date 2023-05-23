package com.pe.innoqa.prices.repository.query;

import lombok.NoArgsConstructor;

/**
 * <b>Class</b>: PriceQuery <br/>
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
@NoArgsConstructor
public class PriceQuery {
    public static final String GET_PRICE_FOR_FECHA_PRODUCTO_BRAND = "SELECT  ID, BRAND_ID, START_DATE, "
            + " END_DATE, PRICE_LIST, PRODUCT_ID, PRIORITY, PRICE, CURR "
            + " FROM PRICES WHERE START_DATE  <= :fecha AND END_DATE >= :fecha AND BRAND_ID = :cadenaId AND "
            + " PRODUCT_ID = :productoId ORDER BY PRIORITY DESC";
}
