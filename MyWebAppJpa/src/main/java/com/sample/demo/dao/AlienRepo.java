package com.sample.demo.dao;

import org.springframework.data.repository.CrudRepository;

import com.sample.demo.model.Alien;

public interface AlienRepo extends CrudRepository<Alien, Integer> {
	

}
