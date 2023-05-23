package com.pe.innoqa.prices.expose;

import com.pe.innoqa.prices.expose.response.GenericResponse;
import com.pe.innoqa.prices.expose.response.PriceResponse;
import com.pe.innoqa.prices.service.IPriceService;
import com.pe.innoqa.prices.utils.HeaderConstants;
import com.pe.innoqa.prices.utils.MessageCatalog;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

/**
 * <b>Class</b>: PriceController <br/>
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
@RestController
@RequestMapping("/price")
public class PriceController {

    @Autowired
    private IPriceService priceService;

    /**
     * This method create an electronic signature.
     *
     * @return Returns a GenericResponse.
     */
    @GetMapping(value = "/producto/{fecha}/{productoId}/{cadenaId}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(response = GenericResponse.class, httpMethod = "GET",
            code = 200, value = "Lista Precios de Producto por Fecha de aplicacion y cadena")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK", response = GenericResponse.class),
            @ApiResponse(code = 400, message = "Bad Request"),
            @ApiResponse(code = 401, message = "Unauthorized"),
            @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Internal Server Error")
    })
    public Mono<ResponseEntity<GenericResponse<PriceResponse>>> getListPrice(
            @PathVariable("fecha") String fecha, @PathVariable("productoId") Integer productoId, @PathVariable("cadenaId")Integer cadenaId) {

        return priceService.getListByPricebyDateApplication(fecha, productoId, cadenaId)
                .map(response -> ResponseEntity.ok()
                        .contentType(MediaType.valueOf(MediaType.APPLICATION_JSON_VALUE))
                        .header(HeaderConstants.RESPONSE_CODE, MessageCatalog.ReturnCode.SUCCESS.getCode())
                        .header(HeaderConstants.RESPONSE_MESSAGE, MessageCatalog.ReturnCode.SUCCESS.getDescription())
                        .body(GenericResponse.<PriceResponse>builder()
                                .code(HttpStatus.OK.value())
                                .status(MessageCatalog.ReturnCode.SUCCESS.getDescription())
                                .data(response)
                                .build()));
    }



}
