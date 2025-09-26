package com.fca.cafeteria.bebidaDomain;

import com.fca.cafeteria.data.Bebida;
import com.fca.cafeteria.data.BebidaRepository;
import com.fca.cafeteria.data.TipoBebida;
import com.fca.cafeteria.data.TipoBebidaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Service
public class BebidaDomain {

    @Autowired
    private BebidaRepository bebidaRepository;

    @Autowired
    private TipoBebidaRepository tipoBebidaRepository;

    //Agregar TipoBebida

    public List<TipoBebida> agregarTipoBebida(String descripcion) {
                if(descripcion == null || descripcion.isEmpty()){
                    return new ArrayList<>();
                }
        //Si hay duplicidad en tipo de bebida
        Predicate<TipoBebida> duplicado = tipoBebida ->
                tipoBebida != null &&
                tipoBebida.getDescripcion() != null &&
                tipoBebida.getDescripcion().equals(descripcion);
        //Si existe, mandar lista vacia
        boolean yaExiste = tipoBebidaRepository.findAll()
                .stream()
                .anyMatch(duplicado);
        if (yaExiste) {
            return new ArrayList<>();
        }

        tipoBebidaRepository.save(new TipoBebida(descripcion));

        // Devolver todos los tipos que coincidan con esa descripción
        return tipoBebidaRepository.findAll()
                .stream()
                .filter(duplicado)
                .collect(Collectors.toList());

    }

//Agregar Bebida

    public List<Bebida> agregarBebida(String nombre, String descripcion, Integer idTipoBebida) {


        if (nombre == null || descripcion == null || idTipoBebida == null ||
                nombre.isEmpty() || descripcion.isEmpty() || idTipoBebida <= 0) {
            return new ArrayList<>();
        }

        // Verificar que el tipo exista
        Predicate<TipoBebida> tipoValido = t ->
                t != null && t.getId() == idTipoBebida;

        boolean existeTipo = tipoBebidaRepository.findAll()
                .stream()
                .anyMatch(tipoValido);
        if (!existeTipo) {
            return new ArrayList<>();
        }

        // Evitar duplicado: misma bebida + mismo tipo
        Predicate<Bebida> duplicadoBebida = bebida ->
                bebida != null &&
                        bebida.getNombre() != null &&
                        bebida.getNombre().equals(nombre) &&      // equals exacto (igual que tu ejemplo)
                        bebida.getIdTipoBebida() == idTipoBebida;

        boolean yaExiste = bebidaRepository.findAll()
                .stream()
                .anyMatch(duplicadoBebida);
        if (yaExiste) {
            return new ArrayList<>();
        }

        // Guardar
        bebidaRepository.save(new Bebida(nombre, descripcion, idTipoBebida));

        // Devolver todas las bebidas del mismo tipo
        Predicate<Bebida> delMismoTipo = b ->
                b != null && b.getIdTipoBebida() == idTipoBebida;

        return bebidaRepository.findAll()
                .stream()
                .filter(delMismoTipo)
                .collect(Collectors.toList());
    }

}
