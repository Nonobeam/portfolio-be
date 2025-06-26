package per.com.portfolio.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import per.com.portfolio.config.settings.UISetting;

import java.util.List;

@Slf4j
@Configuration
public class CorsConfig {
  @Bean
  public CorsConfigurationSource corsConfigurationSource(UISetting uiSetting) {
    CorsConfiguration configuration = new CorsConfiguration();
    configuration.setAllowedOrigins(uiSetting.getAllowCors());
    configuration.setAllowedMethods(List.of("GET", "POST", "PUT", "DELETE", "OPTIONS"));
    configuration.setAllowedHeaders(List.of("*"));
    configuration.setAllowCredentials(true);

    log.info("CORS configuration initialized with allowed origins: {}", uiSetting.getAllowCors());

    UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
    source.registerCorsConfiguration("/**", configuration);
    return source;
  }
}
