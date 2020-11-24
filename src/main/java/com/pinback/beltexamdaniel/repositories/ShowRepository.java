package com.pinback.beltexamdaniel.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.pinback.beltexamdaniel.models.Show;

@Repository
public interface ShowRepository extends CrudRepository<Show, Long> {

}
