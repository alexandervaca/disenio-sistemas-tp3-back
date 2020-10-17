package ar.com.ifts.app.model;

import static javax.persistence.FetchType.EAGER;
import static javax.persistence.GenerationType.IDENTITY;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
@Table(name = "usuarios")
public class Usuario implements UserDetails {

	private static final long serialVersionUID = 2273099146705095002L;

	@Id
	@GeneratedValue(strategy = IDENTITY)
	private Long idUsuario;

	private String username;

	private String password;
	
	private String mail;
	
	private boolean habilitado;

	@OneToMany(fetch = EAGER, cascade = {
			CascadeType.MERGE,
			CascadeType.REFRESH
	})
	@JoinTable(name = "usuarios_permisos",
				joinColumns = {
						@JoinColumn(name = "id_usuario")
				},
				inverseJoinColumns = {
						@JoinColumn(name = "id_permiso")
				})
	private List<Permiso> permisos;
	
	public Usuario() {}
	
	public Usuario(String username, String password, String mail, boolean habilitado, List<Permiso> permisos) {
		this.username = username;
		this.password = password;
		this.mail = mail;
		this.habilitado = habilitado;
		this.permisos = permisos;
	}

	public Long getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Permiso> getPermisos() {
		return permisos;
	}

	public void setPermisos(List<Permiso> permisos) {
		this.permisos = permisos;
	}

	/**
	 * @return the mail
	 */
	public String getMail() {
		return mail;
	}

	/**
	 * @param mail the mail to set
	 */
	public void setMail(String mail) {
		this.mail = mail;
	}

	/**
	 * @return the habilitado
	 */
	public boolean isHabilitado() {
		return habilitado;
	}

	/**
	 * @param habilitado the habilitado to set
	 */
	public void setHabilitado(boolean habilitado) {
		this.habilitado = habilitado;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return this.getPermisos().stream().map(perm -> new SimpleGrantedAuthority(perm.getDescPermiso()))
				.collect(Collectors.toList());
	}

	@Override
	public boolean isAccountNonExpired() {
		return false;
	}

	@Override
	public boolean isAccountNonLocked() {
		return false;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return false;
	}

	@Override
	public boolean isEnabled() {
		return isHabilitado();
	}

}
