package io.swagger.api;

import io.swagger.model.Module;
import io.swagger.model.User;
import io.swagger.util.ModuleUtils;
import io.swagger.util.UsuarioUtils;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.*;
import javax.validation.Valid;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.stream.Collectors;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-12-03T22:30:26.029Z")

@Controller
public class UsuarioApiController implements UsuarioApi {

	private static final Logger log = LoggerFactory.getLogger(UsuarioApiController.class);

	private final ObjectMapper objectMapper;

	private final HttpServletRequest request;

	private Hashtable<Long, User> bd = new Hashtable<>();

	@org.springframework.beans.factory.annotation.Autowired
	public UsuarioApiController(ObjectMapper objectMapper, HttpServletRequest request) {
		this.objectMapper = objectMapper;
		this.request = request;
	}

	public ResponseEntity<Void> actualizarUsuario(
			@ApiParam(value = "Todos los datos a actualizar", required = true) @Valid @RequestBody User datosActualizarUsuario) {
		String accept = request.getHeader("Accept");
		bd.remove(datosActualizarUsuario.getId());
		bd.put(datosActualizarUsuario.getId(), datosActualizarUsuario);
		return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
	}

	public ResponseEntity<List<User>> listarUsuariosEstado(
			@NotNull @ApiParam(value = "Estado del usuario en el sistema", required = true, allowableValues = "Activo, Inactivo, Vacaciones") @Valid @RequestParam(value = "Estado", required = true) String estado) {
		String accept = request.getHeader("Accept");
		if (accept != null && accept.contains("application/json")) {
			try {
				List<User> m = new ArrayList<User>(
						bd.values().stream().filter(UsuarioUtils.filtroEstado(estado)).collect(Collectors.toList()));
				return new ResponseEntity<List<User>>(m, HttpStatus.NOT_IMPLEMENTED);

//                return new ResponseEntity<List<User>>(objectMapper.readValue("[ {  \"firstName\" : \"firstName\",  \"lastName\" : \"lastName\",  \"password\" : \"password\",  \"userStatus\" : \"userStatus\",  \"phone\" : \"phone\",  \"id\" : 0,  \"email\" : \"email\",  \"username\" : \"username\"}, {  \"firstName\" : \"firstName\",  \"lastName\" : \"lastName\",  \"password\" : \"password\",  \"userStatus\" : \"userStatus\",  \"phone\" : \"phone\",  \"id\" : 0,  \"email\" : \"email\",  \"username\" : \"username\"} ]", List.class), HttpStatus.NOT_IMPLEMENTED);
			} catch (Exception e) {
				log.error("Couldn't serialize response for content type application/json", e);
				return new ResponseEntity<List<User>>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}

		return new ResponseEntity<List<User>>(HttpStatus.NOT_IMPLEMENTED);
	}

	public ResponseEntity<Void> registrarUsuario(
			@ApiParam(value = "Todos los datos personales para realizar el registro del usuario", required = true) @Valid @RequestBody User datosUsuario) {
		String accept = request.getHeader("Accept");
		if (!bd.contains(datosUsuario.getId())) {
			bd.put(datosUsuario.getId(), datosUsuario);
		}
		return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
	}

}
