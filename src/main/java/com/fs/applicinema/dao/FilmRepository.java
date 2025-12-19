package com.fs.applicinema.dao;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.fs.applicinema.enties.Film;


@RepositoryRestResource
public interface FilmRepository extends JpaRepository<Film, Integer> {

}
