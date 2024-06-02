package migration.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.support.SpringBootServletInitializer;


@SpringBootApplication
public class MigrationExampleApplication extends SpringBootServletInitializer {

    public static final Logger LOG = LoggerFactory.getLogger("migration.example");

    public static void main(String[] args) {
        SpringApplication.run(MigrationExampleApplication.class, args);
    }
}




