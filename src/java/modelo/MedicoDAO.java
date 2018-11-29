package modelo;

import entidades.Medico;
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
public class MedicoDAO {
    @PersistenceContext
    private EntityManager em;
    
    @Transactional(rollbackOn = {ServicioException.class})
    //@Transactional
    
    public void create(Medico dto) throws ServicioException{
        em.persist(dto);
        //em.merge(dto); Actualizar
        //em.remove(dto); Borrar
        //em.find(Medico.class, "1"); Buscar por PK
    }
    
    public Medico readByRut(String rutM)throws SecurityException{
        return em.find(Medico.class, rutM);
    }
    
    public Medico readByRutJPQL(String rutM)throws SecurityException{
        String sql="Select a from Medico a Where a.rutM = :rutM";
        
        Query q=em.createQuery(sql);
        q.setParameter("rut", rutM);
        
        try{
            return (Medico)q.getSingleResult();
        } catch (Exception e){
            return null;
        }
    }
    
    public List<Medico> readAllJPQL()throws SecurityException{
        String sql="Select a from Paciente a";
        
        Query q=em.createQuery(sql);
        return q.getResultList();
    }
    
    public boolean readByRutJPQLCreate(String rutM) throws SecurityException{
        String sql="Select a from Paciente a Where a.rutM = :rutM";
        
        Query q=em.createQuery(sql);
        q.setParameter("rutM", rutM);
        
        if(q.getResultList().size()>0){
            return true;
        }
        else{
            return false;
        }
    }
    
    public int createJPQL(Medico dto)throws SecurityException{
        if(readByRutJPQLCreate(dto.getRutM())){
            return 0;
        }
        else{
            em.persist(dto);
            return 1;
        }
    }
}

