package com.pe.innoqa.prices.repository;

import com.pe.innoqa.prices.entity.Prices;
import com.pe.innoqa.prices.repository.query.PriceQuery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

/**
 * <b>Class</b>: IPriceRepository <br/>
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
@Repository
public interface IPriceRepository extends JpaRepository<Prices, Long> {

    @Query(value = PriceQuery.GET_PRICE_FOR_FECHA_PRODUCTO_BRAND, nativeQuery = true)
    List<Prices> getPriceByFechaVigencia(
            @Param("fecha") String fecha,
            @Param("productoId") Integer productoId,
            @Param("cadenaId") Integer cadenaId);
}
