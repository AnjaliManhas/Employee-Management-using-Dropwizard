
import javax.persistence.*;

@Entity
@Table(name = "info")
@NamedQueries({
        @NamedQuery(name = "com.wordpress.compilationerrors.info.findAll",
                query = "select e from Info e"),
        @NamedQuery(name = "com.wordpress.compilationerrors.info.findByEmpId",
                query = "select e from Info e where e.empid= :empIdParam"),
        @NamedQuery(name = "com.wordpress.compilationerrors.info.deleteByEmpId",
                query = "delete from Info e where e.empid= :empIdParam"),
        @NamedQuery(name = "com.wordpress.compilationerrors.info.updateNameByEmpId",
                query = "update Info e set e.name= :nameParam where e.empid= :empIdParam"),
        @NamedQuery(name = "com.wordpress.compilationerrors.info.updateEmailByEmpId",
                query = "update Info e set e.email= :emailParam where e.empid= :empIdParam"),
        @NamedQuery(name = "com.wordpress.compilationerrors.info.updateDobByEmpId",
                query = "update Info e set e.dob= :dobParam where e.empid= :empIdParam"),
        @NamedQuery(name = "com.wordpress.compilationerrors.info.updateAddressByEmpId",
                query = "update Info e set e.address= :addressParam where e.empid= :empIdParam"),


})
public class Info {
    @Column(name = "name")
    private String name;
    @Column( name = "email")
    private String email;
    @Column( name = "address")
    private String address;
    @Column( name = "dob")
    private String dob;
    @Id
    @Column(name = "empid")
    private String empid;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmpid() {
        return empid;
    }

    public void setEmpid(String empid) {
        this.empid = empid;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }
}