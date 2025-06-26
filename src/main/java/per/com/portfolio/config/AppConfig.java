package per.com.portfolio.config;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.introspect.DefaultAccessorNamingStrategy.Provider;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import per.com.portfolio.config.settings.CloudinarySetting;
import per.com.portfolio.config.settings.UISetting;

@Configuration
public class AppConfig {
  @Bean
  @Primary
  ObjectMapper objectMapper() {
    ObjectMapper objectMapper =
        JsonMapper.builder()
            .accessorNaming(new Provider().withBuilderPrefix(""))
            .configure(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES, true)
            .configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false)
            .disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES)
            .propertyNamingStrategy(PropertyNamingStrategies.LOWER_CAMEL_CASE)
            .serializationInclusion(Include.NON_NULL)
            .build();
    objectMapper.registerModules(new JavaTimeModule());
    return objectMapper;
  }

  @Bean
  MappingJackson2HttpMessageConverter jackson2HttpMessageConverter(ObjectMapper objectMapper) {
    MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
    converter.setObjectMapper(objectMapper);
    return converter;
  }

  @Bean
  @ConfigurationProperties("app.ui-setting")
  UISetting uiSetting() {
    return new UISetting();
  }

  @Bean("cloudinarySetting")
  @ConfigurationProperties("cloudinary")
  public CloudinarySetting cloudinarySetting() {
    return new CloudinarySetting();
  }
}
