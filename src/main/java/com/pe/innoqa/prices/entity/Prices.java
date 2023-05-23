package com.pe.innoqa.prices.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Calendar;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

/**
 * <b>Class</b>: price <br/>
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

@Entity
@Table(name = "PRICES")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EnableAutoConfiguration
@AutoConfiguration
public class Prices implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "BRAND_ID")
    private Brand retail;

    @Column(name = "START_DATE",nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Calendar startDate;

    @Column(name = "END_DATE",nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Calendar endDate;

    @Column(name = "PRICE_LIST",nullable = false)
    private Integer priceList;

    @Column(name = "PRODUCT_ID",nullable = false)
    private Integer productId;

    @Column(name = "PRIORITY",nullable = false)
    private Integer priority;

    @Column(name = "PRICE",nullable = false)
    private Double price;

    @Column(name = "CURR",nullable = false)
    private String curr;

}
