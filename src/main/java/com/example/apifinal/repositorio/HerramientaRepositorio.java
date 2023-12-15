package com.example.apifinal.repositorio;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.apifinal.entidad.HerramientaArticulo;

@Repository
public interface HerramientaRepositorio extends CrudRepository<HerramientaArticulo, Long>{
    
}
