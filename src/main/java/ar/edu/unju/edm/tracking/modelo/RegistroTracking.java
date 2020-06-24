package ar.edu.unju.edm.tracking.modelo;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

public class RegistroTracking implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private LocalDateTime fechaHora;
	private Vehiculo vehiculo;
	private List<Tripulante> tripulante;
	private Localidad localidad;
	private String detalleLugarRegistro;
	public RegistroTracking() {
		
	}
	public RegistroTracking(LocalDateTime fechaHora, Vehiculo vehiculo, List<Tripulante> tripulante,
			Localidad localidad, String detalleLugarRegistro) {
		super();
		this.fechaHora = fechaHora;
		this.vehiculo = vehiculo;
		this.tripulante = tripulante;
		this.localidad = localidad;
		this.detalleLugarRegistro = detalleLugarRegistro;
	}
	public LocalDateTime getFechaHora() {
		return fechaHora;
	}
	public void setFechaHora(LocalDateTime fechaHora) {
		this.fechaHora = fechaHora;
	}
	public Vehiculo getVehiculo() {
		return vehiculo;
	}
	public void setVehiculo(Vehiculo vehiculo) {
		this.vehiculo = vehiculo;
	}
	public List<Tripulante> getTripulante() {
		return tripulante;
	}
	public void setTripulante(List<Tripulante> tripulante) {
		this.tripulante = tripulante;
	}
	public Localidad getLocalidad() {
		return localidad;
	}
	public void setLocalidad(Localidad localidad) {
		this.localidad = localidad;
	}
	public String getDetalleLugarRegistro() {
		return detalleLugarRegistro;
	}
	public void setDetalleLugarRegistro(String detalleLugarRegistro) {
		this.detalleLugarRegistro = detalleLugarRegistro;
	}
	@Override
	public String toString() {
		return "RegistroTracking [fechaHora=" + fechaHora + ", vehiculo=" + vehiculo + ", tripulante=" + tripulante
				+ ", localidad=" + localidad + ", detalleLugarRegistro=" + detalleLugarRegistro + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((detalleLugarRegistro == null) ? 0 : detalleLugarRegistro.hashCode());
		result = prime * result + ((fechaHora == null) ? 0 : fechaHora.hashCode());
		result = prime * result + ((localidad == null) ? 0 : localidad.hashCode());
		result = prime * result + ((tripulante == null) ? 0 : tripulante.hashCode());
		result = prime * result + ((vehiculo == null) ? 0 : vehiculo.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RegistroTracking other = (RegistroTracking) obj;
		if (detalleLugarRegistro == null) {
			if (other.detalleLugarRegistro != null)
				return false;
		} else if (!detalleLugarRegistro.equals(other.detalleLugarRegistro))
			return false;
		if (fechaHora == null) {
			if (other.fechaHora != null)
				return false;
		} else if (!fechaHora.equals(other.fechaHora))
			return false;
		if (localidad == null) {
			if (other.localidad != null)
				return false;
		} else if (!localidad.equals(other.localidad))
			return false;
		if (tripulante == null) {
			if (other.tripulante != null)
				return false;
		} else if (!tripulante.equals(other.tripulante))
			return false;
		if (vehiculo == null) {
			if (other.vehiculo != null)
				return false;
		} else if (!vehiculo.equals(other.vehiculo))
			return false;
		return true;
	}
	
	
}
