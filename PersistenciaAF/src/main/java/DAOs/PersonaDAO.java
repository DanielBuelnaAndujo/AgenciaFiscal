package DAOs;

import Conexion.ConexionBD;
import Conexion.IConexionBD;
import Entidades.Persona;
import Exception.PersistenciaException;
import Interfaces.IPersonaDAO;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

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

    @Override
    public List<Persona> obtenerPersonas(String rfc, String telefono) throws PersistenciaException {
        String consultaSQL = "{CALL consultar_persona_por_rfc_y_telefono(?, ?)}";
        
        try (Connection con = conexion.crearConexion();
                CallableStatement cb = con.prepareCall(consultaSQL)) {
            
            cb.setString(1, rfc);
            cb.setString(2, telefono);
            
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

    @Override
    public boolean registrarPersonaYLicencia(Persona p, int vigencia) throws PersistenciaException {
        String consultaSQL = "{CALL insertar_persona_y_lisencia(?, ?, ?, ?, ?, ?, ?)}";
        
        try (Connection con = conexion.crearConexion();
                CallableStatement cb = con.prepareCall(consultaSQL)) {
            
            cb.setString(1, p.getNombre());
            cb.setString(2, p.getApellidoPaterno());
            cb.setString(3, p.getApellidoMaterno());
            cb.setString(4, p.getTelefono());
            cb.setDate(5, Date.valueOf(p.getFechaNacimiento()));
            cb.setString(6, p.getRfc());
            cb.setInt(7, vigencia);
            
            int resultados = cb.executeUpdate();
            if (resultados == 0) {
                return false;
            }
            
            return true;  
        } catch (SQLException ex) {
            throw new PersistenciaException("No se pudo registrar a la Persona y su Licencia.");
        }
    }
    
}
