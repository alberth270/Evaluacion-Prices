package com.pe.innoqa.prices.expose.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

/**
 * <b>Class</b>: GenericResponse <br/>
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
@ApiModel(description = "")
@AllArgsConstructor
@Data
@Builder
public class GenericResponse<T> {
    @ApiModelProperty(value = "")
    @JsonProperty("code")
    private Integer code;

    @ApiModelProperty(value = "")
    @JsonProperty("status")
    private String status;

    @ApiModelProperty(value = "")
    @JsonProperty("data")
    private T data;

    @ApiModelProperty(value = "")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("message")
    private String message;
}
