package Factory;

import BOs.GestorPagosBO;
import BOs.PersonaBO;
import BOs.PlacasBO;
import BOs.VehiculoBO;
import Control.GestorPagos;
import Control.IGestorPagos;
import DAOs.PersonaDAO;
import DAOs.PlacasDAO;
import DAOs.VehiculoDAO;
import Interfaces.IPersonaBO;
import Interfaces.IPersonaDAO;
import Interfaces.IPlacasBO;
import Interfaces.IPlacasDAO;
import Interfaces.IVehiculoBO;
import Interfaces.IVehiculoDAO;
import Interfaces.IGestorPagosBO;

/**
 *
 * @author daniel
 */
public class FabricaObjetosBO {
    
    public static IPersonaBO obtenerPersonaBO() {
        IPersonaDAO personaDAO = new PersonaDAO();
        IPersonaBO personaBO = new PersonaBO(personaDAO);
        return personaBO;
    }
    
    public static IPlacasBO obtenerPlacasBO() {
        IPlacasDAO placasDAO = new PlacasDAO();
        IPlacasBO placasBO = new PlacasBO(placasDAO);
        return placasBO;
    }
    
    public static IVehiculoBO obtenerVehiculoBO() {
        IVehiculoDAO vehiculoDAO = new VehiculoDAO();
        IVehiculoBO vehiculoBO = new VehiculoBO(vehiculoDAO);
        return vehiculoBO;
    }
    
    public static IGestorPagosBO obtenerGestorPagosBO() {
        IGestorPagos gestorPagos = new GestorPagos();
        IGestorPagosBO pagosBO = new GestorPagosBO(gestorPagos);
        return pagosBO;
    }
}
