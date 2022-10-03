package com.crud.backend.repository;

import com.crud.backend.entities.Articulo;

import org.springframework.data.jpa.repository.JpaRepository;

public interface IArticuloRepository extends JpaRepository<Articulo, Integer> {

}
