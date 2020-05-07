import com.codahale.metrics.annotation.Timed;
import freemarker.template.Template;
import io.dropwizard.hibernate.UnitOfWork;

import javax.ws.rs.core.MediaType;
import java.util.List;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.io.StringWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("/resource")
@Produces(MediaType.APPLICATION_JSON)

public class MyResource {
    private InfoDao infoDao;

    public MyResource(InfoDao infoDao) {
        this.infoDao = infoDao;
    }

    @GET
    @Timed
    @Path("/getName")
    public String getName() {
        return "Anjali";
    }

    @POST
    @Timed
    @Path("/postName")
    public String postName(String name) {
        System.out.println("Name given by : " + name);
        return "Ok";
    }

    @GET
    @Timed
    @UnitOfWork
    @Path("/findAllEmp")
    public List<Info> findAllEmp() {
        System.out.println("All Emp  : " + infoDao.findAll());
        return infoDao.findAll();
    }

    @POST
    @Timed
    @UnitOfWork
    @Path("/saveEmp")
    public String saveEmp(Info info) {
        return infoDao.create(info);
    }

    @POST
    @Timed
    @UnitOfWork
    @Path("/enterData")
    public String saveEmp(@FormParam("full_name") String name,
                          @FormParam("id") String id,
                          @FormParam("address") String address,
                          @FormParam("email") String email,
                          @FormParam("dob") String dob) {
        Info info = new Info();
        info.setEmpid(id);
        info.setName(name);
        info.setAddress(address);
        info.setEmail(email);
        info.setDob(dob);
        return infoDao.create(info);
    }

    @POST
    @Timed
    @UnitOfWork
    @Produces({MediaType.TEXT_HTML})
    @Path("/deleteDetails")
    public Response deleteDetails(@FormParam("id") String empid) {
        try {
            System.out.println("Emp id is " + empid);
            infoDao.deleteByEmpId(empid);
            Template temp = TemplateConfigurationContext.getConfiguration().getTemplate("deleted.ftl");
            Map root = new HashMap();
            Writer writer = new StringWriter();
            temp.process(root, writer);
            return Response.status(Response.Status.ACCEPTED).entity((writer.toString())).build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(("Oops! Try again later")).build();
        }
    }


    @POST
    @Timed
    @UnitOfWork
    @Produces({MediaType.TEXT_HTML})
    @Path("/showDetails")
    public Response showDetails(@FormParam("id") String empid) {
        Info info = infoDao.findByEmpId(empid);
        try {
            Template temp = TemplateConfigurationContext.getConfiguration().getTemplate("showDetail.ftl");
            Map root = new HashMap();
            root.put("empName", info.getName());
            root.put("email", info.getEmail());
            root.put("dob", info.getDob());
            root.put("address", info.getAddress());

            Writer writer = new StringWriter();
            temp.process(root, writer);
            return Response.status(Response.Status.ACCEPTED).entity((writer.toString())).build();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(("Oops! Try again later")).build();
    }


    @GET
    @Timed
    @Produces({MediaType.TEXT_HTML})
    @Path("/helloWorld")
    public Response getHelloWorld() {
        try {
            Template temp = TemplateConfigurationContext.getConfiguration().getTemplate("helloWorld.ftl");
            Map root = new HashMap();
            root.put("user", "Anjali");
            Writer writer = new StringWriter();
            temp.process(root, writer);
            return Response.status(Response.Status.ACCEPTED).entity((writer.toString())).build();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(("Oops! Try again later")).build();
    }

    @POST
    @Timed
    @UnitOfWork
    @Produces({MediaType.TEXT_HTML})
    @Path("/updateName")
    public Response updateName(@FormParam("id") String empid,
                               @FormParam("full_name") String name) {
        try {
            System.out.println("Emp id is " + empid);
            infoDao.updateNameByEmpId(empid, name);
            Template temp = TemplateConfigurationContext.getConfiguration().getTemplate("updated.ftl");
            Map root = new HashMap();
            Writer writer = new StringWriter();
            temp.process(root, writer);
            return Response.status(Response.Status.ACCEPTED).entity((writer.toString())).build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(("Oops! Try again later")).build();
        }
    }

    @POST
    @Timed
    @UnitOfWork
    @Produces({MediaType.TEXT_HTML})
    @Path("/updateEmail")
    public Response updateEmail(@FormParam("id") String empid,
                                @FormParam("email") String email) {
        try {
            System.out.println("Emp id is " + empid);
            infoDao.updateEmailByEmpId(empid, email);
            Template temp = TemplateConfigurationContext.getConfiguration().getTemplate("updated.ftl");
            Map root = new HashMap();
            Writer writer = new StringWriter();
            temp.process(root, writer);
            return Response.status(Response.Status.ACCEPTED).entity((writer.toString())).build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(("Oops! Try again later")).build();
        }

    }

    @POST
    @Timed
    @UnitOfWork
    @Produces({MediaType.TEXT_HTML})
    @Path("/updateDob")
    public Response updateDob(@FormParam("id") String empid,
                                @FormParam("dob") String dob) {
        try {
            System.out.println("Emp id is " + empid);
            infoDao.updateDobByEmpId(empid, dob);
            Template temp = TemplateConfigurationContext.getConfiguration().getTemplate("updated.ftl");
            Map root = new HashMap();
            Writer writer = new StringWriter();
            temp.process(root, writer);
            return Response.status(Response.Status.ACCEPTED).entity((writer.toString())).build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(("Oops! Try again later")).build();
        }

    }

    @POST
    @Timed
    @UnitOfWork
    @Produces({MediaType.TEXT_HTML})
    @Path("/updateAddress")
    public Response updateAddress(@FormParam("id") String empid,
                              @FormParam("address") String address) {
        try {
            System.out.println("Emp id is " + empid);
            infoDao.updateAddressByEmpId(empid, address);
            Template temp = TemplateConfigurationContext.getConfiguration().getTemplate("updated.ftl");
            Map root = new HashMap();
            Writer writer = new StringWriter();
            temp.process(root, writer);
            return Response.status(Response.Status.ACCEPTED).entity((writer.toString())).build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(("Oops! Try again later")).build();
        }

    }
}