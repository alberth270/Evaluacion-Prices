package com.pe.innoqa.prices.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * <b>Class</b>: Brand <br/>
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
@Table(name = "Brand")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Brand implements Serializable{
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "BRAND_ID")
    private Integer id;

    @Column(name = "NAME",nullable = false)
    private String name;
}
