package lk.ijse.thogakadepos_backend.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@ComponentScan(basePackages = "lk.ijse.thogakadepos_backend")
@EnableWebMvc
public class WebAppConfig {
}
