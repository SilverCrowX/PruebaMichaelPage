package io.swagger.util;

import java.util.function.Predicate;

import io.swagger.model.User;

public class UsuarioUtils {

	public static Predicate<User> filtroEstado(String estado) {
		return (User l) -> {
			return l.getUserStatus().equals(estado);
		};
	}

}
