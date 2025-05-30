package BOs;

import DTOs.PersonaViejaDTO;
import Entidades.Persona;
import Exception.NegocioException;
import Exception.PersistenciaException;
import Interfaces.IPersonaBO;
import Interfaces.IPersonaDAO;
import Mappers.PersonaMapper;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author daniel
 */
public class PersonaBO implements IPersonaBO {

    private IPersonaDAO personaDAO;
    
    public PersonaBO(IPersonaDAO personaDAO) {
        this.personaDAO = personaDAO;
    }
    
    @Override
    public List<PersonaViejaDTO> obtenerPersonas() throws NegocioException {
        try {
            List<Persona> personas = personaDAO.obtenerPersonas();
            
            List<PersonaViejaDTO> personasDTO = personas.stream()
                                                        .map(PersonaMapper::toViejoDTO)
                                                        .collect(Collectors.toList());
            
            return personasDTO;
        } catch (PersistenciaException ex) {
            throw new NegocioException("No se pudo obtener la lista de Personas.");
        }
    }

    @Override
    public List<PersonaViejaDTO> obtenerPersonas(String rfc, String telefono) throws NegocioException {
        try {
            List<Persona> personas = personaDAO.obtenerPersonas(rfc, telefono);
            
            List<PersonaViejaDTO> personasDTO = personas.stream()
                                                        .map(PersonaMapper::toViejoDTO)
                                                        .collect(Collectors.toList());
            
            return personasDTO;
        } catch (PersistenciaException ex) {
            throw new NegocioException("No se pudo obtener la lista de Personas.");
        }
    }
    
}
