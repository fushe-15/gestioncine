package com.fs.applicinema.dao;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.fs.applicinema.enties.Ville;


@RepositoryRestResource
public interface VilleRepository extends JpaRepository<Ville, Integer> {

}
