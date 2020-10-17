package ar.com.ifts.app.model.enums;

import java.util.Arrays;
import java.util.List;

public enum PermisosEnum implements IPermisosEnum{
	ADMIN {
		public List<String> getRoles() {
			return Arrays.asList("ROLE_ADMIN", "ROLE_PROVEEDOR", "ROLE_CLIENTE");
		}
		
		public Boolean isHabilitado() {
			return false;
		}
	},
	PROVEEDOR {
		public List<String> getRoles() {
			return Arrays.asList("ROLE_PROVEEDOR", "ROLE_CLIENTE");
		}
		
		public Boolean isHabilitado() {
			return false;
		}
	},
	CLIENTE {
		public List<String> getRoles() {
			return Arrays.asList("ROLE_CLIENTE");
		}
		
		public Boolean isHabilitado() {
			return true;
		}
	}
	
}
