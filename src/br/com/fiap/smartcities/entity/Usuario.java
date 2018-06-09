package br.com.fiap.smartcities.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "TBL_CTR_USUARIO")
@SequenceGenerator(name = "sqUsuario", sequenceName = "SEQ_USUARIO", allocationSize = 1)
@XmlRootElement(name = "Usuario")
public class Usuario implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sqUsuario")
	@Column(name = "cd_usuario")
	private int idUsuario;
	@Column(name = "nm_usuario", nullable = false, length = 100)
	private String nome;
	@Column(name = "ds_email", nullable = false, unique = true, length = 100)
	private String email;

	public Usuario(int idUsuario, String nome, String email) {
		super();
		this.idUsuario = idUsuario;
		this.nome = nome;
		this.email = email;
	}

	public Usuario() {
	}

	@XmlElement(name = "idUsuario", required = true)
	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	@XmlElement(name = "nome", required = true)
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@XmlElement(name = "email", required = true)
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Usuario [idUsuario=" + idUsuario + ", nome=" + nome + ", email=" + email + "]";
	}
}