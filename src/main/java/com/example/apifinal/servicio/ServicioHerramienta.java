package com.example.apifinal.servicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.Optional;

import com.example.apifinal.entidad.HerramientaArticulo;
import com.example.apifinal.excepciones.InvalidTypeValueException;
import com.example.apifinal.repositorio.HerramientaRepositorio;

@Service
public class ServicioHerramienta extends HerramientaArticulo{
@Autowired
HerramientaRepositorio repository;
    
public HerramientaArticulo cargarHerramienta(HerramientaArticulo herramienta){
    return repository.save(herramienta);
}


public ArrayList<HerramientaArticulo> consultarStockH(){
    
    return(ArrayList<HerramientaArticulo>) repository.findAll();
}

public HerramientaArticulo modificarProductoH(HerramientaArticulo articuloAmodificar, long id)
{
    HerramientaArticulo heraux = repository.findById(id).get();

    heraux.setNombre(articuloAmodificar.getNombre());
    heraux.setPrecio(articuloAmodificar.getPrecio());
    heraux.setStock(articuloAmodificar.getStock());

    return repository.save(heraux);
}


@Override
public Optional<HerramientaArticulo> buscarxIdH(Long id) throws Exception
{
    Optional<HerramientaArticulo> articulo = repository.findById(id);
    if (articulo.isPresent())
    {
        return articulo;
    } else
    {
        throw new InvalidTypeValueException("no hay articulos con ese ID en el catalogo");
    }
}

public boolean eliminarHerramienta(Long id)
{
    try {
        repository.deleteById(id);
        return true;
    } catch (Exception e) {
        return false;
    }
}

}
