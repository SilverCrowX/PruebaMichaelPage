package io.swagger.api;

import io.swagger.model.Module;
import io.swagger.util.ModuleUtils;

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
public class ModuloApiController implements ModuloApi {

	private static final Logger log = LoggerFactory.getLogger(ModuloApiController.class);

	private final ObjectMapper objectMapper;

	private final HttpServletRequest request;

	private Hashtable<Long, Module> bd = new Hashtable<>();

	@org.springframework.beans.factory.annotation.Autowired
	public ModuloApiController(ObjectMapper objectMapper, HttpServletRequest request) {
		this.objectMapper = objectMapper;
		this.request = request;
	}

	public ResponseEntity<Void> actualizarModulo(
			@ApiParam(value = "Todos los datos a actualizar", required = true) @Valid @RequestBody Module datosActualizarModulo) {
		String accept = request.getHeader("Accept");
		bd.remove(datosActualizarModulo.getId());
		bd.put(datosActualizarModulo.getId(), datosActualizarModulo);
		return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
	}

	public ResponseEntity<List<Module>> listarModulosEstado(
			@NotNull @ApiParam(value = "Estado del modulo en el sistema", required = true, allowableValues = "Activo, Inactivo") @Valid @RequestParam(value = "Estado", required = true) String estado) {
		String accept = request.getHeader("Accept");
		if (accept != null && accept.contains("application/json")) {
			try {
				List<Module> m = new ArrayList<Module>(
						bd.values().stream().filter(ModuleUtils.filtroEstado(estado)).collect(Collectors.toList()));
				return new ResponseEntity<List<Module>>(m, HttpStatus.NOT_IMPLEMENTED);
//				return new ResponseEntity<List<Module>>(objectMapper.readValue(
//						"[ {  \"moduleStatus\" : \"moduleStatus\",  \"modulename\" : \"modulename\",  \"id\" : 0}, {  \"moduleStatus\" : \"moduleStatus\",  \"modulename\" : \"modulename\",  \"id\" : 0} ]",
//						List.class), HttpStatus.NOT_IMPLEMENTED);
			} catch (Exception e) {
				log.error("Couldn't serialize response for content type application/json", e);
				return new ResponseEntity<List<Module>>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}

		return new ResponseEntity<List<Module>>(HttpStatus.NOT_IMPLEMENTED);
	}

	public ResponseEntity<Void> registrarModulo(
			@ApiParam(value = "Todos los datos del modulo para realizar el registro del mismo", required = true) @Valid @RequestBody Module datosModulo) {
		if (!bd.contains(datosModulo.getId())) {
			bd.put(datosModulo.getId(), datosModulo);
		}
		String accept = request.getHeader("Accept");
		return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
	}

}
