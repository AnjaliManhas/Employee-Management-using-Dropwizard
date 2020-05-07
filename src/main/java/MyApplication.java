import io.dropwizard.Application;
import io.dropwizard.db.DataSourceFactory;
import io.dropwizard.hibernate.HibernateBundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class MyApplication extends Application<MyConfiguration> {
    public static void main(String[] args) throws Exception {
        new MyApplication().run(args);
    }
    public void run(MyConfiguration myConfiguration, Environment environment) throws Exception {
        System.out.println("Value from dev.yml is "+myConfiguration.getDataSourceFactory().getUser());
        InfoDao infoDao = new InfoDao(hibernate.getSessionFactory());
        final MyResource resource = new MyResource(infoDao);
        environment.jersey().register(resource);
    }
    private HibernateBundle<MyConfiguration> hibernate = new HibernateBundle<MyConfiguration>(Info.class) {
        @Override
        public DataSourceFactory getDataSourceFactory(MyConfiguration configuration) {
            return configuration.getDataSourceFactory();
        }
    };
    @Override
    public String getName() {
        return "dropwizard-hibernate";
    }
    @Override
    public void initialize(Bootstrap<MyConfiguration> bootstrap) {
        bootstrap.addBundle(hibernate);
    }
}
