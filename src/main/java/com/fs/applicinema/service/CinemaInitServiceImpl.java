package com.fs.applicinema.service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fs.applicinema.dao.CategorieRepository;
import com.fs.applicinema.dao.CinemaRepository;
import com.fs.applicinema.dao.FilmRepository;
import com.fs.applicinema.dao.PlaceRepository;
import com.fs.applicinema.dao.ProjectionRepository;
import com.fs.applicinema.dao.SalleRepository;
import com.fs.applicinema.dao.SeanceRepository;
import com.fs.applicinema.dao.TicketRepository;
import com.fs.applicinema.dao.VilleRepository;
import com.fs.applicinema.enties.Categorie;
import com.fs.applicinema.enties.Cinema;
import com.fs.applicinema.enties.Film;
import com.fs.applicinema.enties.Place;
import com.fs.applicinema.enties.Projection;
import com.fs.applicinema.enties.Salle;
import com.fs.applicinema.enties.Seance;
import com.fs.applicinema.enties.Ticket;
import com.fs.applicinema.enties.Ville;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class CinemaInitServiceImpl implements ICinemaInitService {
@Autowired
private VilleRepository villerepository;
@Autowired
private CinemaRepository cinemarepository;
@Autowired
private TicketRepository ticketrepository;
@Autowired
private PlaceRepository placerepository;
@Autowired
private ProjectionRepository projectionrepository;
@Autowired
private FilmRepository filmrepository;
@Autowired
private SeanceRepository seancerepository;
@Autowired
private CategorieRepository categorierepository;

@Autowired
private SalleRepository sallerepository;




	@Override
	public void initvilles() {
		// TODO Auto-generated method stub
		
		Stream.of("Douala","Yaoundé","Foumban","Bafoussam").forEach(nomv->{
			
		Ville ville=new Ville();
		ville.setNom(nomv);
		villerepository.save(ville);
		});

	}

	@Override
	public void initcinemas() {
		// TODO Auto-generated method stub
		
		villerepository.findAll().forEach(v->{
			
			Stream.of("Cine1","Cine2","Cine3","Cine4")
			.forEach(nomcine->{
				
				Cinema cine= new Cinema();
				
					
				cine.setNom(nomcine);
				cine.setNbresalle(3+(int)Math.random()*7);
				cine.setVille(v);
				cinemarepository.save(cine);
			});
		
			
		});
	
	}

	@Override
	public void initsalles() {
		// TODO Auto-generated method stub
cinemarepository.findAll().forEach(cine->{
	
	for(int i=1;i<= cine.getNbresalle();i++) {
		
		Salle salle= new Salle();
		salle.setNom("Salle"+i);
		salle.setCinema(cine);
		salle.setNbrePlace(15+(int)Math.random()*20);
		sallerepository.save(salle);
	}
			
			
		});
		

	}

	@Override
	public void initplaces() {
		// TODO Auto-generated method stub
		
		sallerepository.findAll().forEach(salle->{
			for(int i=1;i<= salle.getNbrePlace();i++) {
				Place place=new Place();
				place.setSalle(salle);
				place.setNumero(i);
				placerepository.save(place);
				
			}
				
				
				
			
			
		});

	}

	@Override
	public void initseances() {
		// TODO Auto-generated method stub
		DateFormat datefor= new SimpleDateFormat("HH:mm");
		Stream.of("12:00","15:00","17:00","19:00","21:00").forEach(s->{
			
			Seance seance= new Seance();
			try {
			seance.setHeuredebut(datefor.parse(s));
			seancerepository.save(seance);
				
			}catch (ParseException e) {
				// TODO: handle exception
				
				e.printStackTrace();
			}
			
		});
		

	}

	@Override
	public void initcategories() {
		// TODO Auto-generated method stub
		Stream.of("history","actions","fiction","drama").forEach(cat->{
			
			Categorie categorie= new Categorie();
			categorie.setName(cat);
			categorierepository.save(categorie);
			
		});

	}

	@Override
	public void initfilms() {
		// TODO Auto-generated method stub
		double [] durees= new double[] {1,1.5,2,2.5,3};
		List<Categorie> categorie= categorierepository.findAll();
		Stream.of("forest game","green book","la ligne verte","element dangereux","marque du lion").forEach(titre->{
			
			Film f= new Film();
			f.setTitre(titre);
			f.setDuree(durees[new Random().nextInt(durees.length)]);
			f.setPhoto(titre.replace(" ", ""));
			f.setCategorie(categorie.get(new Random().nextInt(categorie.size())));
			
			filmrepository.save(f);
		});
				

	}

	@Override
	public void initprojections() {
		// TODO Auto-generated method stub
		
		double[] prices= new double[] {30,50,60,70,90,100};
		villerepository.findAll().forEach(ville->{
			
			ville.getCinemas().forEach(cine->{
			cine.getSalles().forEach(salle->{
			filmrepository.findAll().forEach(film->{
				
				seancerepository.findAll().forEach(seance->{
					Projection pr=new Projection();
					pr.setDateprojection(new Date());
					pr.setFilm(film);
					pr.setPrix(prices[new Random().nextInt(prices.length)]);
					pr.setSalle(salle);
					pr.setSeance(seance);
					projectionrepository.save(pr);
					
				});	
				
			});	
				
				
			});	
				
			});
			
		});

	}

	@Override
	public void inittickets() {
		// TODO Auto-generated method stub
		
		projectionrepository.findAll().forEach(p->{
			
			p.getSalle().getPlaces().forEach(place->{
				Ticket tk=new Ticket();
				tk.setPlace(place);
				tk.setPrix(p.getPrix());
				tk.setProjection(p);
				tk.setReserve(false);
				ticketrepository.save(tk);
				
				
			});
		});

	}

}
