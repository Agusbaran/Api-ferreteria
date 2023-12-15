package com.example.apifinal.entidad;

import java.util.Optional;

import org.hibernate.annotations.UuidGenerator;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.apifinal.repositorio.HerramientaRepositorio;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
/*
@Entity
@Table(name = "articulos")*/
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public abstract class Articulo {
    
    //private String categoria;
    private String nombre;
    private String stock;
    private float precio;

    @Autowired
HerramientaRepositorio repository;
    
        //@Override
        public Optional<HerramientaArticulo> buscarxIdH(Long id) throws Exception {
            return repository.findById(id);
        }
    
    
}
