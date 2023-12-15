package com.example.apifinal.repositorio;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.apifinal.entidad.MaterialesArticulo;

@Repository
public interface MaterialRepositorio extends CrudRepository<MaterialesArticulo, Long>{
    
}
