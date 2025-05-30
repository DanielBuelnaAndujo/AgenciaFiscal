package Mappers;

import DTOs.PersonaViejaDTO;
import Entidades.Persona;

/**
 *
 * @author daniel
 */
public class PersonaMapper {
    
    public static PersonaViejaDTO toViejoDTO(Persona p) {
        if (p == null) {
            return null;
        }
        return new PersonaViejaDTO(
                String.valueOf(p.getId()), 
                p.getNombre(), 
                p.getApellidoPaterno(), 
                p.getApellidoMaterno(), 
                p.getTelefono(), 
                p.getFechaNacimiento(), 
                p.getRfc()
        );
    }
    
}
