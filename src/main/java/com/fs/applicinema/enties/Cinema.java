package com.fs.applicinema.enties;


import java.io.Serializable;
import java.util.Collection;

import org.hibernate.annotations.ManyToAny;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor @Getter @Setter
public class Cinema implements Serializable {
	
	@Id @GeneratedValue(strategy =GenerationType.IDENTITY )
	private Long id;
	private String nom;
	private double longitude, latitude,altitude;
	private int nbresalle;
	@OneToMany(mappedBy ="cinema")
	private Collection<Salle> salles;
	@ManyToOne
	private Ville ville;
	

}
