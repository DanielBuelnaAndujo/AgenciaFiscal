package Interfaces;

import DTOs.PersonaNuevaDTO;
import DTOs.PersonaViejaDTO;
import Exception.NegocioException;
import java.util.List;

/**
 *
 * @author daniel
 */
public interface IPersonaBO {
    
    public List<PersonaViejaDTO> obtenerPersonas() throws NegocioException;
    public List<PersonaViejaDTO> obtenerPersonas(String rfc, String telefono) throws NegocioException;
    public boolean registrarPersonaYLisencia(PersonaNuevaDTO p, int vigencia) throws NegocioException;
    
}
