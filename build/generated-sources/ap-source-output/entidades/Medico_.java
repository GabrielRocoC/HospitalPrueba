package entidades;

import entidades.Especializacion;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-11-29T13:59:29")
@StaticMetamodel(Medico.class)
public class Medico_ { 

    public static volatile SingularAttribute<Medico, String> area;
    public static volatile SingularAttribute<Medico, String> nombreM;
    public static volatile SingularAttribute<Medico, String> rutM;
    public static volatile SingularAttribute<Medico, String> apellidoM;
    public static volatile CollectionAttribute<Medico, Especializacion> especializacionCollection;

}