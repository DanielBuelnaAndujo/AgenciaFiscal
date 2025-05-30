package BOs;

import DTOs.PersonaNuevaDTO;
import DTOs.PersonaViejaDTO;
import Entidades.Persona;
import Exception.NegocioException;
import Exception.PersistenciaException;
import Interfaces.IPersonaBO;
import Interfaces.IPersonaDAO;
import Mappers.PersonaMapper;
import java.util.Base64;
import java.util.List;
import java.util.stream.Collectors;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

/**
 *
 * @author daniel
 */
public class PersonaBO implements IPersonaBO {

    private IPersonaDAO personaDAO;
    private static final String clave = "1234567890123456";
    
    public PersonaBO(IPersonaDAO personaDAO) {
        this.personaDAO = personaDAO;
    }
    
    @Override
    public List<PersonaViejaDTO> obtenerPersonas() throws NegocioException {
        try {
            List<Persona> personas = personaDAO.obtenerPersonas();
            
            for (Persona p : personas) {
                try {
                    String telefonoDes = desencriptar(p.getTelefono());
                    p.setTelefono(telefonoDes);
                } catch (Exception e) {
                }
            }
            
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
            
            for (Persona p : personas) {
                try {
                    String telefonoDes = desencriptar(p.getTelefono());
                    p.setTelefono(telefonoDes);
                } catch (Exception e) {
                }
            }
            
            List<PersonaViejaDTO> personasDTO = personas.stream()
                                                        .map(PersonaMapper::toViejoDTO)
                                                        .collect(Collectors.toList());
            
            return personasDTO;
        } catch (PersistenciaException ex) {
            throw new NegocioException("No se pudo obtener la lista de Personas.");
        }
    }
    
    @Override
    public boolean registrarPersonaYLisencia(PersonaNuevaDTO p, int vigencia) throws NegocioException {
        if (p.getNombre().isBlank()) {
            throw new NegocioException("El Nombre no puede estar vacio.");
        }
        if (p.getApellidoPaterno().isBlank()) {
            throw new NegocioException("El Apellido Paterno no puede estar vacio.");
        }
        if (p.getApellidoMaterno().isBlank()) {
            throw new NegocioException("El Apellido Materno no puede estar vacio.");
        }
        if (p.getTelefono().isBlank()) {
            throw new NegocioException("El Télefono no puede estar vacio.");
        }
        if (p.getFechaNacimiento() == null) {
            throw new NegocioException("La Fecha no puede estar vacia.");
        }
        if (p.getRfc().isBlank()) {
            throw new NegocioException("El RFC no puede estar vacio.");
        }
        
        try {
            String telefonoEn = encriptar(p.getTelefono());
            p.setTelefono(telefonoEn);
        } catch(Exception e) {
            throw new NegocioException("No se pudo encriptar el Télefono.");
        }
        
        Persona persona = PersonaMapper.toEntity(p);
        
        try {
            boolean exito = personaDAO.registrarPersonaYLicencia(persona, vigencia);
            
            return exito;
        } catch(PersistenciaException e) {
            throw new NegocioException(e.getMessage());
        }
    }
    
    private String encriptar(String texto) throws Exception {
        SecretKeySpec key = new SecretKeySpec(clave.getBytes(), "AES");
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE, key);

        byte[] textoEncriptado = cipher.doFinal(texto.getBytes());
        return Base64.getEncoder().encodeToString(textoEncriptado);
    }
    
    public String desencriptar(String textoEncriptado) throws Exception {
        SecretKeySpec key = new SecretKeySpec(clave.getBytes(), "AES");
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.DECRYPT_MODE, key);

        byte[] bytesDesencriptados = cipher.doFinal(Base64.getDecoder().decode(textoEncriptado));
        return new String(bytesDesencriptados);
    }
    
}
