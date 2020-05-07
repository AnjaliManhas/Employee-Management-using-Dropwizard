import io.dropwizard.hibernate.AbstractDAO;
import org.hibernate.SessionFactory;
import org.hibernate.query.QueryProducer;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

public class InfoDao extends AbstractDAO<Info> {
    public InfoDao(SessionFactory factory) {
        super(factory);
    }
    public Info findById(String id) { return get(id); }
    public String create(Info info) {
        return persist(info).getEmpid();
    }
    public List<Info> findAll() {
        return (List<Info>) namedQuery("com.wordpress.compilationerrors.info.findAll").getResultList();
    }
    public Info findByEmpId(String empId){
        Query<Info> query = currentSession().createNamedQuery("com.wordpress.compilationerrors.info.findByEmpId",
                Info.class);
        query.setParameter("empIdParam", empId);
        Info result = query.uniqueResult();
        return result;
    }
    public void deleteByEmpId(String empId){
        Query<Info> query = currentSession().createQuery("delete from Info e where e.empid= :empIdParam");
        query.setParameter("empIdParam", empId);
        int res = query.executeUpdate();
        System.out.println("empid is "+empId+" res is "+res);
    }
    public void updateNameByEmpId(String empId, String name){
        Query<Info> query = currentSession().createQuery("update Info e set e.name= :nameParam where e.empid= :empIdParam");
        query.setParameter("empIdParam", empId);
        query.setParameter("nameParam", name);
        int res = query.executeUpdate();
        System.out.println("empid is "+empId+" res is "+res);
    }

    public void updateEmailByEmpId(String empId, String email){
        Query<Info> query = currentSession().createQuery("update Info e set e.email= :emailParam where e.empid= :empIdParam");
        query.setParameter("empIdParam", empId);
        query.setParameter("emailParam", email);
        int res = query.executeUpdate();
        System.out.println("empid is "+empId+" res is "+res);
    }

    public void updateDobByEmpId(String empId, String dob){
        Query<Info> query = currentSession().createQuery("update Info e set e.dob= :dobParam where e.empid= :empIdParam");
        query.setParameter("empIdParam", empId);
        query.setParameter("dobParam", dob);
        int res = query.executeUpdate();
        System.out.println("empid is "+empId+" res is "+res);
    }

    public void updateAddressByEmpId(String empId, String address){
        Query<Info> query = currentSession().createQuery("update Info e set e.address= :addressParam where e.empid= :empIdParam");
        query.setParameter("empIdParam", empId);
        query.setParameter("addressParam", address);
        int res = query.executeUpdate();
        System.out.println("empid is "+empId+" res is "+res);
    }


}



