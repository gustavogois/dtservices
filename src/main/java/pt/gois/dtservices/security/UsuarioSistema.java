package pt.gois.dtservices.security;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import pt.gois.dtservices.model.Utilizador;

public class UsuarioSistema extends User {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Utilizador utilizador;

	public UsuarioSistema(Utilizador utilizador, Collection<? extends GrantedAuthority> authorities) {
		super(utilizador.getNome(), utilizador.getSenha(), authorities);
		this.utilizador = utilizador;
	}

	public Utilizador getUtilizador() {
		return utilizador;
	}

	public void setUtilizador(Utilizador utilizador) {
		this.utilizador = utilizador;
	}
}
