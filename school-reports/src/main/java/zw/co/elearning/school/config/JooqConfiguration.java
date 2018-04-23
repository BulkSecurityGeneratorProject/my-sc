package zw.co.elearning.school.config;

import javax.sql.DataSource;

import org.jooq.ConnectionProvider;
import org.jooq.DSLContext;
import org.jooq.ExecuteListenerProvider;
import org.jooq.SQLDialect;
import org.jooq.TransactionProvider;
import org.jooq.impl.DataSourceConnectionProvider;
import org.jooq.impl.DefaultConfiguration;
import org.jooq.impl.DefaultDSLContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.TransactionAwareDataSourceProxy;

import zw.co.elearning.school.config.DatabaseConfiguration;

@Configuration
@AutoConfigureAfter(value = { DatabaseConfiguration.class })
public class JooqConfiguration {

	private final Logger log = LoggerFactory.getLogger(JooqConfiguration.class);

	//@Bean
	public DataSourceTransactionManager transactionManager(DataSource dataSource) {
		return new DataSourceTransactionManager(dataSource);
	}

	@Bean
	public DSLContext dsl(DataSource dataSource) {
		return new DefaultDSLContext(dataSource,SQLDialect.MYSQL );   // (config);
	}

	//@Bean
	public ConnectionProvider connectionProvider(DataSource dataSource) {
		return new DataSourceConnectionProvider(new TransactionAwareDataSourceProxy(dataSource));
	}

	//@Bean
	public org.jooq.Configuration jooqConfig(ConnectionProvider connectionProvider,
			TransactionProvider transactionProvider, ExecuteListenerProvider executeListenerProvider) {

		return new DefaultConfiguration() //
				.derive(connectionProvider) //
				.derive(transactionProvider) //
				.derive(executeListenerProvider) //
				.derive(SQLDialect.MYSQL);
	}
}
