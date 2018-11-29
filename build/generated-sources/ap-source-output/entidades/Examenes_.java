package entidades;

import entidades.Paciente;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-11-29T13:59:29")
@StaticMetamodel(Examenes.class)
public class Examenes_ { 

    public static volatile SingularAttribute<Examenes, Paciente> rut;
    public static volatile SingularAttribute<Examenes, Integer> sala;
    public static volatile SingularAttribute<Examenes, Integer> id;
    public static volatile SingularAttribute<Examenes, String> tipoExamen;

}