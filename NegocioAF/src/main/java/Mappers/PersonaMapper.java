package Mappers;

import DTOs.PersonaNuevaDTO;
import DTOs.PersonaViejaDTO;
import Entidades.Persona;
import java.time.LocalDate;

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
    
    public static Persona toEntity(PersonaNuevaDTO p) {
        if (p == null) {
            return null;
        }
        return new Persona(
                p.getNombre(), 
                p.getApellidoPaterno(), 
                p.getApellidoMaterno(), 
                p.getTelefono(), 
                p.getFechaNacimiento(), 
                p.getRfc());
    }
    
}
