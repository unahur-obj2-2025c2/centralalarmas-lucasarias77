package ar.edu.unahur.obj2.observer;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CentralTest {
    private CentralDeMonitoreo central;
    private Entidad e1;
    private Entidad e2;

    
    @BeforeEach
    void setUp(){
        central = new CentralDeMonitoreo();
        e1 = new Entidad("hospital");
        e2 = new Entidad("cuartel de bomberos");
        central.agregarObservador(e1);
        central.agregarObservador(e2);
    }

    @Test
    @DisplayName("dadoElSetUp_alAgregarAlertas_SeVerificaCorretamenteLasAlertasRecibidasYElRiesgo")
    void Test1(){

        central.emitirAlerta("calor", 6);
        central.emitirAlerta("lluvia", 8);


        assertEquals("calor", e1.getAlertasRecibidas().getFirst().getTipo());
        assertEquals(6, e1.getAlertasRecibidas().getFirst().getNivel());
        assertEquals("lluvia", e1.getAlertasRecibidas().getLast().getTipo());
        assertEquals(8, e1.getAlertasRecibidas().getLast().getNivel());

        assertEquals("calor", e2.getAlertasRecibidas().getFirst().getTipo());
        assertEquals(6, e2.getAlertasRecibidas().getFirst().getNivel());
        assertEquals("lluvia", e2.getAlertasRecibidas().getLast().getTipo());
        assertEquals(8, e2.getAlertasRecibidas().getLast().getNivel());
    }

}
