package ar.edu.unahur.obj2.observer.riegos;

import java.util.List;

import ar.edu.unahur.obj2.observer.Alerta;

public class RiesgoPromedio implements Criterio{

    @Override
    public Double obtenerRiesgo(List<Alerta> alertasRecibidas) {
        return alertasRecibidas.stream().mapToInt(a -> a.getNivel()).average().orElse(0.0);
    }

   
}
