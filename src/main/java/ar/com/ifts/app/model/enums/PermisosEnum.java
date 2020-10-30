package ar.com.ifts.app.model.enums;

public enum PermisosEnum implements IPermisosEnum {
	ADMIN {
		public String getRole() {
			return "ROLE_ADMIN";
		}

		public Boolean isHabilitado() {
			return false;
		}
	},
	PROVEEDOR {
		public String getRole() {
			return "ROLE_PROVEEDOR";
		}

		public Boolean isHabilitado() {
			return false;
		}
	},
	CLIENTE {
		public String getRole() {
			return "ROLE_CLIENTE";
		}

		public Boolean isHabilitado() {
			return true;
		}
	}

}
