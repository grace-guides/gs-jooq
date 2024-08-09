package grace.guides;

import javax.sql.DataSource;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.grails.orm.hibernate.HibernateDatastore;

@Configuration(proxyBeanMethods = false)
public class DatasourceConfig {

    @Bean
    DataSource dataSource(ObjectProvider<HibernateDatastore> hibernateDatastore) {
        return hibernateDatastore.getIfUnique().getDataSource();
    }

}
