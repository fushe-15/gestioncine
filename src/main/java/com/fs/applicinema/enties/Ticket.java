package com.fs.applicinema.enties;



import java.io.Serializable;
import java.util.Collection;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;



@Entity
@AllArgsConstructor @NoArgsConstructor @Getter @Setter
@ToString
public class Ticket implements Serializable {
	
	@Id @GeneratedValue(strategy =GenerationType.IDENTITY )
	private Long id;
	private String nomclient;
	private double prix;
	@Column(unique = true, nullable = true)
	private Integer codepayement;
	private boolean reserve;
	@ManyToOne
	private Place place;
	@ManyToOne
	private Projection projection;
	
	

}
