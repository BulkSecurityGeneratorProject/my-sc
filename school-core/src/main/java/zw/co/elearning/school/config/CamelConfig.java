package zw.co.elearning.school.config;

import org.apache.camel.spring.javaconfig.CamelConfiguration;
import org.springframework.context.annotation.Configuration;

import de.codecentric.boot.admin.config.EnableAdminServer;

@Configuration
@EnableAdminServer
//@ImportResource("classpath:META-INF/cxf/cxf.xml")
//@ComponentScan("com.raibledesigns.camel")
public class CamelConfig extends CamelConfiguration {
//    @Value("${logging.trace.enabled}")
//    private Boolean tracingEnabled;
// 
//    @Override
//    protected void setupCamelContext(CamelContext camelContext) throws Exception {
//        PropertiesComponent pc = new PropertiesComponent();
//        pc.setLocation("classpath:application.properties");
//        camelContext.addComponent("properties", pc);
//        // see if trace logging is turned on
//        if (tracingEnabled) {
//            camelContext.setTracing(true);
//        }
//        super.setupCamelContext(camelContext);
//    }
 
//    @Bean
//    public Tracer camelTracer() {
//        Tracer tracer = new Tracer();
//        tracer.setTraceExceptions(false);
//        tracer.setTraceInterceptors(true);
//        tracer.setLogName("com.raibledesigns.camel.trace");
//        return tracer;
//    }
}