package DAOs;

import Conexion.ConexionBD;
import Conexion.IConexionBD;
import DTOs.HistorialPlacasDTO;
import Entidades.Placas;
import Exception.PersistenciaException;
import Interfaces.IPlacasDAO;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author daniel
 */
public class PlacasDAO implements IPlacasDAO {

    private IConexionBD conexion;

    public PlacasDAO() {
        this.conexion = new ConexionBD();
    }
    
    @Override
    public List<HistorialPlacasDTO> obtenerHistorialPlacas(String idVehiculo, LocalDate fechaTramite) throws PersistenciaException {
        String consultaSQL = "{CALL consultar_placas_por_idVehiculo_y_fechaTramite(?, ?)}";
        
        try (Connection con = conexion.crearConexion();
                CallableStatement cb = con.prepareCall(consultaSQL)) {
            
            cb.setInt(1, Integer.valueOf(idVehiculo));
            cb.setDate(2, Date.valueOf(fechaTramite));
            
            List<HistorialPlacasDTO> placas = new ArrayList<>();
            
            try(ResultSet rs = cb.executeQuery()) {
               while (rs.next()) {
                   placas.add(new HistorialPlacasDTO(
                           rs.getString("numero"),
                           rs.getString("estado"),
                           rs.getDate("fecha").toLocalDate(),
                           rs.getDouble("costo"),
                           rs.getDate("fechaRecepcion").toLocalDate()
                   ));
               } 
            }
            
            return placas;
        } catch(SQLException e) {
            throw new PersistenciaException("No se pudo obtener el Historial de Placas.");
        }
    }

    @Override
    public boolean registrarPlacas(Placas placas) throws PersistenciaException {
        String consultaSQL = "{CALL insertar_placas_a_vehiculo_viejo(?, ?)}";
        
        try (Connection con = conexion.crearConexion();
                CallableStatement cb = con.prepareCall(consultaSQL)) {
            
            cb.setInt(1, placas.getIdVehiculo());
            cb.setInt(2, placas.getIdPersona());
            
            int resultados = cb.executeUpdate();
            if (resultados == 0) {
                return false;
            }
            
            return true;
        } catch (SQLException ex) {
            throw new PersistenciaException("No se pudo registrar las Placas.");
        }
    }
    
}
