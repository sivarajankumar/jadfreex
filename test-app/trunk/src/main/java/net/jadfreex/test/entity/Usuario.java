package net.jadfreex.test.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "TUsuario")
public class Usuario implements Serializable {

	private static final long serialVersionUID = 7744052745916914944L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "NIdUsuario")
	private Long id;

	@NotNull
	@Size(min = 3, max = 50)
	@Column(name = "VNombre")
	private String nombre;

	@NotNull
	@Size(min = 3, max = 50)
	@Column(name = "VApPaterno")
	private String apPaterno;

	@NotNull
	@Size(min = 3, max = 50)
	@Column(name = "VApMaterno")
	private String apMaterno;

	@NotNull
	@Size(min = 3, max = 50)
	@Column(name = "VUsername")
	private String username;

	@NotNull
	@Size(min = 3, max = 50)
	@Column(name = "VPassword")
	private String password;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApPaterno() {
		return apPaterno;
	}

	public void setApPaterno(String apPaterno) {
		this.apPaterno = apPaterno;
	}

	public String getApMaterno() {
		return apMaterno;
	}

	public void setApMaterno(String apMaterno) {
		this.apMaterno = apMaterno;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((apMaterno == null) ? 0 : apMaterno.hashCode());
		result = prime * result
				+ ((apPaterno == null) ? 0 : apPaterno.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		result = prime * result
				+ ((password == null) ? 0 : password.hashCode());
		result = prime * result
				+ ((username == null) ? 0 : username.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof Usuario)) {
			return false;
		}
		Usuario other = (Usuario) obj;
		if (apMaterno == null) {
			if (other.apMaterno != null) {
				return false;
			}
		} else if (!apMaterno.equals(other.apMaterno)) {
			return false;
		}
		if (apPaterno == null) {
			if (other.apPaterno != null) {
				return false;
			}
		} else if (!apPaterno.equals(other.apPaterno)) {
			return false;
		}
		if (id == null) {
			if (other.id != null) {
				return false;
			}
		} else if (!id.equals(other.id)) {
			return false;
		}
		if (nombre == null) {
			if (other.nombre != null) {
				return false;
			}
		} else if (!nombre.equals(other.nombre)) {
			return false;
		}
		if (password == null) {
			if (other.password != null) {
				return false;
			}
		} else if (!password.equals(other.password)) {
			return false;
		}
		if (username == null) {
			if (other.username != null) {
				return false;
			}
		} else if (!username.equals(other.username)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Usuario [");
		if (id != null)
			builder.append("id=").append(id).append(", ");
		if (nombre != null)
			builder.append("nombre=").append(nombre).append(", ");
		if (apPaterno != null)
			builder.append("apPaterno=").append(apPaterno).append(", ");
		if (apMaterno != null)
			builder.append("apMaterno=").append(apMaterno).append(", ");
		if (username != null)
			builder.append("username=").append(username).append(", ");
		if (password != null)
			builder.append("password=").append(password);
		builder.append("]");
		return builder.toString();
	}

}