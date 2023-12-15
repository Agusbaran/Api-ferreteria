package com.example.apifinal.controlador;

import java.util.ArrayList;
import java. util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.apifinal.entidad.HerramientaArticulo;
import com.example.apifinal.entidad.MaterialesArticulo;
import com.example.apifinal.servicio.ServicioHerramienta;
import com.example.apifinal.servicio.ServicioMaterial;

@RestController
@RequestMapping("/ferreteria")
public class Controlador {
    
@Autowired
ServicioHerramienta herramientaServicio;
ServicioMaterial materialServicio;
/* 
@GetMapping("/inventario")
public void inventario()
{
    herramientaServicio.consultarStockH();
    materialServicio.consultarStockM();
}*/

//                     ---------------------------herramienta---------------------------
@GetMapping("/inventario/herramientas")
public ArrayList<HerramientaArticulo> inventarioH()
{
    return herramientaServicio.consultarStockH();
}

@PostMapping("/cargar/herramienta")
public HerramientaArticulo cargarherramienta(@RequestBody HerramientaArticulo herramienta)
{
    return this.herramientaServicio.cargarHerramienta(herramienta);
}

@GetMapping(path = "/buscar/herramienta_{id}")
public Optional<HerramientaArticulo> buscarHporid(@PathVariable("id") Long id) throws Exception
{
    return this.herramientaServicio.buscarxIdH(id);
}

@PutMapping("/modificar/herramienta_{id}")
public HerramientaArticulo modificarherramienta(@RequestBody HerramientaArticulo elemento, @PathVariable("id") Long id)
{
    return this.herramientaServicio.modificarProductoH(elemento, id);
}

@DeleteMapping(path =  "/eliminar/herramienta_{id}")
public String eliminarH(@PathVariable("id") Long id)
{
    boolean eliminado = herramientaServicio.eliminarHerramienta(id);

    if(eliminado)
    {
        return "eliminadp";
    }
    else
    {
        return "error en la eliminacion";
    }
}


//                     ---------------------------material---------------------------

@GetMapping("/inventario/materiales")
public ArrayList<MaterialesArticulo> inventarioM()
{
    return materialServicio.consultarStockM();
}

@PostMapping("/cargar/material")
public MaterialesArticulo cargarmaterial(@RequestBody MaterialesArticulo material)
{
    return this.materialServicio.cargarMaterial(material);
}

@GetMapping(path = "/buscar/material_{id}")
public Optional<MaterialesArticulo> buscarMporid(@PathVariable("id") Long id)
{
    return this.materialServicio.buscarxIdM(id);
}

@PutMapping("/modificar/material_{id}")
public MaterialesArticulo modificarmaterial(@RequestBody MaterialesArticulo elemento, @PathVariable("id") Long id)
{
    return this.materialServicio.modificarProductoM(elemento, id);
}

@DeleteMapping(path =  "/eliminar/material_{id}")
public String eliminarM(@PathVariable("id") Long id)
{
    boolean eliminado = materialServicio.eliminarMaterial(id);

    if(eliminado)
    {
        return "eliminadp";
    }
    else
    {
        return "error en la eliminacion";
    }
}

}


