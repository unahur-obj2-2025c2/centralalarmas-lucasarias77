package ar.edu.unahur.obj2.observer;

import java.util.List;



public class Entidad implements Observador{

    private String nombre;
    private List<Alerta> alertasRecibidas;
    private Criterio criterioRiesgo;

    public Entidad(String nombre, List<Alerta> alertasRecibidas, Criterio criterioRiesgo) {
        this.nombre = nombre;
        this.alertasRecibidas = alertasRecibidas;
        this.criterioRiesgo = criterioRiesgo;
    }

    @Override
    public void actualizar(Alerta alerta) {
        alertasRecibidas.add(alerta);
    }
}
