package io.swagger.util;

import java.util.function.Predicate;

import io.swagger.model.Module;

public class ModuleUtils {

	public static Predicate<Module> filtroEstado(String estado) {
		return (Module l) -> {
			return l.getModuleStatus().equals(estado);
		};
	}

}
