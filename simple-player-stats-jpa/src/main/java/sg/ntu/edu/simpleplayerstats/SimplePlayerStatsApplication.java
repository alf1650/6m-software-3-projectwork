package sg.ntu.edu.simpleplayerstats;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class SimplePlayerStatsApplication {

    private static final Logger logger = LoggerFactory.getLogger(SimplePlayerStatsApplication.class);

    public static void main(String[] args) {
        logger.info("🟢 Starting SimplePlayerStatsApplication");
        logger.debug("❓ Debugging information...An exception occurred");
        logger.warn("🟠 Test Warning");
        logger.error("🔴 Error Warning");
        SpringApplication.run(SimplePlayerStatsApplication.class, args);
    }

    @Bean
    public WebMvcConfigurer configure() {
        return new WebMvcConfigurer() {

            @Override
            public void addCorsMappings(CorsRegistry corsRegistry) {
                corsRegistry.addMapping("/**").allowedOrigins("*");
            }

        };
    }

}

