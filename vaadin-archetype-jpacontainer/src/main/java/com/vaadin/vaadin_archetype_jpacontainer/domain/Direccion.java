package com.vaadin.vaadin_archetype_jpacontainer.domain;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Direccion {
	
	@Id
	@GeneratedValue
    private Long id;	
	private String domicilio;
	
	public Direccion() {
		
	}
	
	public Direccion(String domicilio) {
		
		this.domicilio = domicilio;
	}

	public String getDomicilio() {
		return domicilio;
	}

	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
	}
	
    public Long getId() {
		return id;
    }

}
