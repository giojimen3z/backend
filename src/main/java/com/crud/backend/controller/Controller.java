package com.crud.backend.controller;

import com.crud.backend.entities.Articulo;
import com.crud.backend.service.ArticuloService;
import java.util.NoSuchElementException;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/taller")
public class Controller {

  @Autowired private ArticuloService service;

  @GetMapping("/connection")
  public ResponseEntity<String> getConnection() {
    try {
      service.listAll();
      return new ResponseEntity<>("Connection OK ", HttpStatus.OK);
    } catch (NoSuchElementException e) {
      return new ResponseEntity<>("Connection Failed ", HttpStatus.NOT_FOUND);
    }
  }

  @PostMapping("articulos")
  public void add(@RequestBody Articulo articulo) {
    service.save(articulo);
  }

  @GetMapping("articulos/{id}")
  public ResponseEntity<Articulo> getById(@PathVariable Integer id) {
    try {

      Articulo articulo = service.findById(id).get();
      return new ResponseEntity<Articulo>(articulo, HttpStatus.OK);
    } catch (NoSuchElementException e) {
      return new ResponseEntity<Articulo>(HttpStatus.NOT_FOUND);
    }
  }

  @DeleteMapping("articulos/{id}")
  public void deleteArticulo(@PathVariable Integer id) {
    service.deleteById(id);
  }
}
