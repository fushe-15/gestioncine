package com.fs.applicinema.enties;


import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@AllArgsConstructor @NoArgsConstructor @Getter @Setter
@ToString
public class Film implements Serializable {
	
	@Id @GeneratedValue(strategy =GenerationType.IDENTITY )
	private Long id;
	private String titre;
	private String description;
	private String realisateur;
	private Date datesortie;
	private double duree;
	private String photo;
	@OneToMany(mappedBy = "film")
	@JsonProperty(access = Access.WRITE_ONLY)
	private Collection<Projection>  projections;
	@ManyToOne 
	private Categorie categorie;
	

}
