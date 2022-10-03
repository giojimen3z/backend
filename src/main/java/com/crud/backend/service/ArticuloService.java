package com.crud.backend.service;

import com.crud.backend.entities.Articulo;
import com.crud.backend.repository.IArticuloRepository;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ArticuloService {

  @Autowired private IArticuloRepository repository;

  public Optional<Articulo> findById(Integer id) {
    return repository.findById(id);
  }

  public List<Articulo> listAll() {
    return repository.findAll();
  }

  public void save(Articulo articulo) {
    repository.save(articulo);
  }

  public void deleteById(Integer id) {
    repository.deleteById(id);
  }
}
