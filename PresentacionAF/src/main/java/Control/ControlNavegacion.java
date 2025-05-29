package Control;

import FRMs.FrmHistorialPlacas;
import FRMs.FrmMenuPrincipal;
import FRMs.FrmPagoPlacas;
import FRMs.FrmRegistrarVehiculo;
import FRMs.FrmSeleccionarPersona;
import FRMs.FrmSeleccionarVehiculo;
import FRMs.FrmTramites;

/**
 *
 * @author daniel
 */
public class ControlNavegacion {
    
    private static ControlNavegacion control;

    private ControlNavegacion() {
    }
    
    public static ControlNavegacion getInstancia() {
        if (control == null) {
            control = new ControlNavegacion();
        }
        return control;
    }
    
    public void mostrarFrmMenuPrincipal() {
        new FrmMenuPrincipal().setVisible(true);
    }
    
    public void mostrarFrmSeleccionarPersona() {
        new FrmSeleccionarPersona().setVisible(true);
    }
    
    public void mostrarFrmTramites() {
        new FrmTramites().setVisible(true);
    }
    
    public void mostrarFrmSeleccionarVehiculo() {
        new FrmSeleccionarVehiculo().setVisible(true);
    }
    
    public void mostrarFrmHistorialPlacas() {
        new FrmHistorialPlacas().setVisible(true);
    }
    
    public void mostrarFrmRegistrarVehiculo() {
        new FrmRegistrarVehiculo().setVisible(true);
    }
    
    public void mostrarFrmPagoPlacas() {
        new FrmPagoPlacas().setVisible(true);
    }
}
