package Control;

import DTOs.HistorialPlacasDTO;
import DTOs.PersonaViejaDTO;
import DTOs.PlacasNuevasDTO;
import DTOs.VehiculoNuevoDTO;
import DTOs.VehiculoViejoDTO;
import Entidades.Persona;
import Exception.NegocioException;
import FRMs.FrmHistorialPlacas;
import FRMs.FrmMenuPrincipal;
import FRMs.FrmPagoPlacas;
import FRMs.FrmRegistrarVehiculo;
import FRMs.FrmSeleccionarPersona;
import FRMs.FrmSeleccionarVehiculo;
import FRMs.FrmTramites;
import Factory.FabricaObjetosBO;
import Interfaces.IPersonaBO;
import Interfaces.IPlacasBO;
import Interfaces.IVehiculoBO;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author daniel
 */
public class ControlNavegacion {
    
    private static ControlNavegacion control;
    
    private IPersonaBO personaBO = FabricaObjetosBO.obtenerPersonaBO();
    private IPlacasBO placasBO = FabricaObjetosBO.obtenerPlacasBO();
    private IVehiculoBO vehiculoBO = FabricaObjetosBO.obtenerVehiculoBO();
            
    private PersonaViejaDTO personaVieja;
    private VehiculoNuevoDTO vehiculoNuevo;

    private ControlNavegacion() {
    }
    
    public static ControlNavegacion getInstancia() {
        if (control == null) {
            control = new ControlNavegacion();
        }
        return control;
    }
    
    public PersonaViejaDTO getPersonaVieja() {
        return personaVieja;
    }

    public void setPersonaVieja(PersonaViejaDTO personaVieja) {
        this.personaVieja = personaVieja;
    }

    public VehiculoNuevoDTO getVehiculoNuevo() {
        return vehiculoNuevo;
    }

    public void setVehiculoNuevo(VehiculoNuevoDTO vehiculoNuevo) {
        this.vehiculoNuevo = vehiculoNuevo;
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
    
    public List<PersonaViejaDTO> obtenerPersonas() {
        try {
            return personaBO.obtenerPersonas();
        } catch(NegocioException e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        
        return new ArrayList<>();
    }
    
    public List<HistorialPlacasDTO> obtenerHistorialPlacas(String idVehiculo, LocalDate fechaTramite) {
        try {
            return placasBO.obtenerHistorialPlacas(idVehiculo, fechaTramite);
        } catch(NegocioException e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        
        return new ArrayList<>();
    }
    
    public void registrarPlacas(PlacasNuevasDTO placas) {
        try {
            boolean exito = placasBO.registrarPlacas(placas);
            if (exito) {
                JOptionPane.showMessageDialog(null, "Se registraron las Placas al Vehiculo Viejo.", "Información", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch(NegocioException e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public List<VehiculoViejoDTO> obtenerVehiculos(String idPersona, String numPlacas) {
        try {
            return vehiculoBO.obtenerVehiculos(idPersona, numPlacas);
        } catch(NegocioException e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        
        return new ArrayList<>();
    }
    
    public void registrarVehiculo(VehiculoNuevoDTO vehiculo) {
        try {
            boolean exito = vehiculoBO.registrarVehiculo(vehiculo);
            if (exito) {
                JOptionPane.showMessageDialog(null, "Se registro el Nuevo Vehiculo con Placas.", "Información", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch(NegocioException e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
            
}
