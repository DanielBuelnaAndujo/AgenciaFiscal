package DAOs;

import Conexion.ConexionBD;
import Conexion.IConexionBD;
import Entidades.Persona;
import Exception.PersistenciaException;
import Interfaces.IPersonaDAO;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author daniel
 */
public class PersonaDAO implements IPersonaDAO {

    private IConexionBD conexion;

    public PersonaDAO() {
        this.conexion = new ConexionBD();
    }
    
    @Override
    public List<Persona> obtenerPersonas() throws PersistenciaException {
        String consultaSQL = "{CALL consultar_personas()}";
        
        try (Connection con = conexion.crearConexion();
                CallableStatement cb = con.prepareCall(consultaSQL)) {
            
            List<Persona> personas = new ArrayList<>();
            try (ResultSet rs = cb.executeQuery()) {
                while (rs.next()) {
                    personas.add(new Persona(
                            rs.getInt("id"),
                            rs.getString("nombre"),
                            rs.getString("apellidoPaterno"),
                            rs.getString("apellidoMaterno"),
                            rs.getString("telefono"),
                            rs.getDate("fechaNacimiento").toLocalDate(),
                            rs.getString("rfc")
                    ));
                }
            }
            
            return personas;
        } catch (SQLException ex) {
            throw new PersistenciaException("No se pudo consultar la lista de Personas.");
        }
    }
    
}
