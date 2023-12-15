package com.example.apifinal.servicio;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.apifinal.entidad.MaterialesArticulo;
import com.example.apifinal.repositorio.MaterialRepositorio;

@Service
public class ServicioMaterial extends MaterialesArticulo{
@Autowired
MaterialRepositorio repository;

public MaterialesArticulo cargarMaterial(MaterialesArticulo material){
    return repository.save(material);
}

public ArrayList<MaterialesArticulo> consultarStockM(){
    return(ArrayList<MaterialesArticulo>) repository.findAll();
}

public MaterialesArticulo modificarProductoM(MaterialesArticulo articuloAmodificar, long id)
{
    MaterialesArticulo mataux = repository.findById(id).get();

    mataux.setNombre(articuloAmodificar.getNombre());
    mataux.setPrecio(articuloAmodificar.getPrecio());
    mataux.setStock(articuloAmodificar.getStock());

    return repository.save(mataux);
}

public Optional<MaterialesArticulo> buscarxIdM(Long id)
{
    return repository.findById(id);
}

public boolean eliminarMaterial(Long id)
{
    try {
        repository.deleteById(id);
        return true;
    } catch (Exception e) {
        return false;
    }
}
    
}
