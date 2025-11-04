package ar.edu.unahur.obj2.observer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CentralDeMonitoreo implements Observable{

    private HashMap<Alerta,Integer> registroDeAlertas = new HashMap<>();
    private Set<Observador> entidadesRegistradas = new HashSet<>();

    public void emitirAlerta(String tipo,Integer nivel){
        if (nivel < 1 || nivel > 10){
            throw new DominioException("Nivel de alerta incorrecto");
        }
        Alerta alerta = new Alerta(tipo, nivel);
        registroDeAlertas.put(alerta, entidadesRegistradas.size());
        notificar(alerta);                                 
        
        /*osea aca en el hashmap le pasa la alerta y a cuanto se envio*/
    }

    @Override
    public void agregarObservador(Observador observador) {
        entidadesRegistradas.add(observador);
    }

    @Override
    public void quitarObservador(Observador observador) {
        entidadesRegistradas.remove(observador);
    }

    @Override
    public void notificar(Alerta alerta) {
        entidadesRegistradas.forEach(o -> o.actualizar(alerta));
    }

    public Integer cantidadDeAlertasNotificacionesEnviadas(){
        return registroDeAlertas.values().stream().mapToInt(Integer :: intValue).sum();
    }

    







}
