package ar.com.ifts.app.model;

import static javax.persistence.FetchType.EAGER;
import static javax.persistence.GenerationType.IDENTITY;

import java.util.Arrays;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToOne;
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

	@OneToOne
	@JoinColumn(name = "id_categoria")
	private Categoria categoria;

	@OneToOne(fetch = EAGER, cascade = { CascadeType.MERGE, CascadeType.REFRESH })
	@JoinTable(name = "usuarios_permisos", joinColumns = { @JoinColumn(name = "id_usuario") }, inverseJoinColumns = {
			@JoinColumn(name = "id_permiso") })
	private Permiso permiso;

	private String nombre;

	public Usuario() {
	}

	public Usuario(String username, String password, String mail, boolean habilitado, Permiso permisos,
			Categoria categoria, String nombre) {
		this.username = username;
		this.password = password;
		this.mail = mail;
		this.habilitado = habilitado;
		this.permiso = permisos;
		this.categoria = categoria;
		this.nombre = nombre;
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

	public Permiso getPermisos() {
		return permiso;
	}

	public void setPermisos(Permiso permisos) {
		this.permiso = permisos;
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

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
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
		return Arrays.asList(new SimpleGrantedAuthority(this.getPermisos().getDescPermiso()));
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return isHabilitado();
	}

}
