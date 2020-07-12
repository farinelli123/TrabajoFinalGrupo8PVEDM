package ar.edu.unju.edm.tracking.modelo;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

@Component
public class Fecha {
	
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private LocalDate fechaH1;
	
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private LocalDate fechaH2;
	
	public Fecha() {
		// TODO Auto-generated constructor stub
	}

	public LocalDate getFechaH1() {
		return fechaH1;
	}

	public void setFechaH1(LocalDate fechaH1) {
		this.fechaH1 = fechaH1;
	}

	public LocalDate getFechaH2() {
		return fechaH2;
	}

	public void setFechaH2(LocalDate fechaH2) {
		this.fechaH2 = fechaH2;
	}
	

}
