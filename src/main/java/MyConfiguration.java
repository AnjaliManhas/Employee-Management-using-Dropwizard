import com.fasterxml.jackson.annotation.JsonProperty;
import io.dropwizard.Configuration;

import io.dropwizard.db.DataSourceFactory;

public class MyConfiguration extends Configuration {
    private String url;
    @JsonProperty("database")
    private DataSourceFactory dataSourceFactory = new DataSourceFactory();

    public String getUrl() {
        return url;
    }
    public void setUrl(String url) {
        this.url = url;
    }
    @JsonProperty("database")
    public DataSourceFactory getDataSourceFactory() {
        return dataSourceFactory;
    }
}