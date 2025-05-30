package Interfaces;

import Entidades.Persona;
import Exception.PersistenciaException;
import java.util.List;

/**
 *
 * @author daniel
 */
public interface IPersonaDAO {
    
    public List<Persona> obtenerPersonas() throws PersistenciaException;
    
}
