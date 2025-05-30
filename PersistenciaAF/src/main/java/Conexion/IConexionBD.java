package Conexion;

import Exception.PersistenciaException;
import java.sql.Connection;

/**
 *
 * @author daniel
 */
public interface IConexionBD {
    
    public Connection crearConexion() throws PersistenciaException;
    
}
