package DAOs;

import Conexion.ConexionBD;
import Conexion.IConexionBD;
import DTOs.SeleccionarVehiculoSalidaDTO;
import Entidades.Vehiculo;
import Exception.PersistenciaException;
import Interfaces.IVehiculoDAO;
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
public class VehiculoDAO implements IVehiculoDAO {

    private IConexionBD conexion;

    public VehiculoDAO() {
        this.conexion = conexion = new ConexionBD();
    }
    
    @Override
    public List<SeleccionarVehiculoSalidaDTO> obtenerVehiculos(String idPersona, String numPlacas) throws PersistenciaException {
        String consultaSQL = "{CALL consultar_vehiculo_por_idPersona_y_numPlaca(?, ?)}";
        
        try (Connection con = conexion.crearConexion();
                CallableStatement cb = con.prepareCall(consultaSQL)) {
            
            cb.setInt(1, Integer.valueOf(idPersona));
            cb.setString(2, numPlacas);
            
            List<SeleccionarVehiculoSalidaDTO> vehiculos = new ArrayList<>();
            
            try(ResultSet rs = cb.executeQuery()) {
                while (rs.next()) {
                    vehiculos.add(new SeleccionarVehiculoSalidaDTO(
                            rs.getInt("id"), 
                            rs.getString("numero"), 
                            rs.getString("numSerie"), 
                            rs.getString("marca"), 
                            rs.getString("linea"), 
                            rs.getString("color"), 
                            rs.getString("modelo"), 
                            rs.getString("tipo")
                    ));      
                }
            }
            
            return vehiculos;
        } catch(SQLException e) {
            throw new PersistenciaException("No se pudo obtener la lista de Vehiculos.");
        }
    }

    @Override
    public boolean registrarVehiculo(Vehiculo vehiculo) throws PersistenciaException {
        String consultaSQL = "{CALL insertar_vehiculo_con_placas(?, ?, ?, ?, ?, ?, ?)}";
        
        try (Connection con = conexion.crearConexion();
                CallableStatement cb = con.prepareCall(consultaSQL)) {
            
            cb.setString(1, vehiculo.getNumSerie());
            cb.setString(2, vehiculo.getMarca());
            cb.setString(3, vehiculo.getLinea());
            cb.setString(4, vehiculo.getColor());
            cb.setString(5, vehiculo.getModelo());
            cb.setString(6, vehiculo.getTipo());
            cb.setInt(7, vehiculo.getIdPersona());
            
            int resultados = cb.executeUpdate();
            if (resultados == 0) {
                return false;
            }
            
            return true;
        } catch (SQLException ex) {
            throw new PersistenciaException("No se pudo registrar el Vehiculo.");
        }
    }
    
}
