package ar.edu.unahur.obj2.observer.riegos;

import java.util.List;

import ar.edu.unahur.obj2.observer.Alerta;

public interface Criterio {

    Double obtenerRiesgo(List<Alerta> alertasRecibidas);

}
