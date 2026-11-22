package grace.guides;

import javax.sql.DataSource;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// import org.grails.orm.hibernate.HibernateDatastore;

/**
 * This configuration allow to use dataSource provided in hibernate plugin,
 * but currently we use dataSource provided in grace-plugin-datasource, so comment it now.
 */
// @Configuration(proxyBeanMethods = false)
public class DatasourceConfig {

    // @Bean
    // DataSource dataSource(ObjectProvider<HibernateDatastore> hibernateDatastore) {
    //     return hibernateDatastore.getIfUnique().getDataSource();
    // }

}
