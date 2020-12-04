/**
 * NOTE: This class is auto generated by the swagger code generator program (2.4.17).
 * https://github.com/swagger-api/swagger-codegen
 * Do not edit the class manually.
 */
package io.swagger.api;

import io.swagger.model.User;
import io.swagger.annotations.*;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.List;
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-12-03T22:30:26.029Z")

@Api(value = "usuario", description = "the usuario API")
@RequestMapping(value = "/prueba")
public interface UsuarioApi {

    @ApiOperation(value = "Actualiza un usuario", nickname = "actualizarUsuario", notes = "Actualiza los datos persnales del usuario", tags={ "pruebausuarios", })
    @ApiResponses(value = { 
        @ApiResponse(code = 400, message = "Id invalido"),
        @ApiResponse(code = 404, message = "usuario no encontrado"),
        @ApiResponse(code = 405, message = "error") })
    @RequestMapping(value = "/usuario",
        produces = { "application/json" }, 
        consumes = { "application/json" },
        method = RequestMethod.PUT)
    ResponseEntity<Void> actualizarUsuario(@ApiParam(value = "Todos los datos a actualizar" ,required=true )  @Valid @RequestBody User datosActualizarUsuario);


    @ApiOperation(value = "Buscar todos los usuarios por estado", nickname = "listarUsuariosEstado", notes = "Trae todos los usuarios registrados en la base de datos por estado", response = User.class, responseContainer = "List", tags={ "pruebausuarios", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Lista de usuarios", response = User.class, responseContainer = "List"),
        @ApiResponse(code = 400, message = "Estado no valido") })
    @RequestMapping(value = "/usuario/listarPorEstado",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<List<User>> listarUsuariosEstado(@NotNull @ApiParam(value = "Estado del usuario en el sistema", required = true, allowableValues = "Activo, Inactivo, Vacaciones") @Valid @RequestParam(value = "Estado", required = true) String estado);


    @ApiOperation(value = "Crea un nuevo usuario", nickname = "registrarUsuario", notes = "Registra la informacion de un usuario para registrarlo en el sistema", tags={ "pruebausuarios", })
    @ApiResponses(value = { 
        @ApiResponse(code = 405, message = "Invalid input") })
    @RequestMapping(value = "/usuario",
        produces = { "application/json" }, 
        consumes = { "application/json" },
        method = RequestMethod.POST)
    ResponseEntity<Void> registrarUsuario(@ApiParam(value = "Todos los datos personales para realizar el registro del usuario" ,required=true )  @Valid @RequestBody User datosUsuario);

}