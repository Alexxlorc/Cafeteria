package com.fca.cafeteria.presentation;

import com.fca.cafeteria.data.Bebida;
import com.fca.cafeteria.data.TipoBebida;
import com.fca.cafeteria.domain.BebidaDomain;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/cafeteria")
public class CafeteriaController {

    @Autowired
    private BebidaDomain bebidaDomain;

    //TipoBebida
    @RequestMapping(value = "/tipo/agregar", method = RequestMethod.POST)
    @ResponseBody
    public List<TipoBebida> agregarTipo(@RequestParam String descripcion) {
        return bebidaDomain.agregarTipoBebida(descripcion);
    }

    
    @RequestMapping(value = "/tipo/todos", method = RequestMethod.GET)
    @ResponseBody
    public List<TipoBebida> listarTipos() {
        return bebidaDomain.listarTipos();
    }

    //Bebida 
  
    @RequestMapping(value = "/bebida/agregar", method = RequestMethod.POST)
    @ResponseBody
    public List<Bebida> agregarBebida(@RequestParam String nombre,
                                      @RequestParam String descripcion,
                                      @RequestParam Integer idTipoBebida) {
        return bebidaDomain.agregarBebida(nombre, descripcion, idTipoBebida);
    }

   
    @RequestMapping(value = "/bebida/por-tipo", method = RequestMethod.GET)
    @ResponseBody
    public List<Bebida> listarPorTipo(@RequestParam Integer idTipoBebida) {
        return bebidaDomain.listarBebidasPorTipo(idTipoBebida);
    }
}