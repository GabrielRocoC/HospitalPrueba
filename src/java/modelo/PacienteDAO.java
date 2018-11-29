package modelo;

import entidades.Paciente;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import org.springframework.stereotype.Service;

/**
 *
 * @author gabrielroco
 */
@Service
public class PacienteDAO {
    @PersistenceContext
    private EntityManager em;
    
    @Transactional(rollbackOn = {ServicioException.class})
    //@Transactional
    
    public void create(Paciente dto) throws ServicioException{
        em.persist(dto);
        //em.merge(dto); Actualizar
        //em.remove(dto); Borrar
        //em.find(Paciente.class, "1"); Buscar por PK
    }
    
    public Paciente readByRut(String rut)throws SecurityException{
        return em.find(Paciente.class, rut);
    }
    
    public Paciente readByRutJPQL(String rut)throws SecurityException{
        String sql="Select a from Paciente a Where a.rut = :rut";
        
        Query q=em.createQuery(sql);
        q.setParameter("rut", rut);
        
        try{
            return (Paciente)q.getSingleResult();
        } catch (Exception e){
            return null;
        }
    }
    
    public List<Paciente> readAllJPQL()throws SecurityException{
        String sql="Select a from Paciente a";
        
        Query q=em.createQuery(sql);
        return q.getResultList();
    }
    
    public boolean readByRutJPQLCreate(String rut) throws SecurityException{
        String sql="Select a from Paciente a Where a.rut = :rut";
        
        Query q=em.createQuery(sql);
        q.setParameter("rut", rut);
        
        if(q.getResultList().size()>0){
            return true;
        }
        else{
            return false;
        }
    }
    
    public int createJPQL(Paciente dto)throws SecurityException{
        if(readByRutJPQLCreate(dto.getRut())){
            return 0;
        }
        else{
            em.persist(dto);
            return 1;
        }
    }
    public void update(Paciente dto) throws ServicioException{
        em.merge(dto);
    }
    
    public void delete(Paciente dto) throws ServicioException{
        em.remove(dto);
    }
    
    public void find(Paciente dto) throws ServicioException{
        em.find(Paciente.class, "1");
    }
}

