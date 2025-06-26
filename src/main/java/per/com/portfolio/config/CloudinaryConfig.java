package per.com.portfolio.config;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import per.com.portfolio.config.settings.CloudinarySetting;

@Configuration
@DependsOn("cloudinarySetting")
public class CloudinaryConfig {
  private static final String CLOUD_NAME = "cloud_name";
  private static final String API_KEY = "api_key";
  private static final String SECRET_KEY = "api_secret";

  private final CloudinarySetting cloudinary;

  public CloudinaryConfig(CloudinarySetting cloudinary) {
    this.cloudinary = cloudinary;
  }

  @Bean
  public Cloudinary cloudinary() {
    if (cloudinary.getName() == null
        || cloudinary.getKey() == null
        || cloudinary.getSecret() == null) {
      throw new IllegalStateException(
          "Cloudinary configuration is incomplete. Check cloud_name, api_key, and api_secret.");
    }

    return new Cloudinary(
        ObjectUtils.asMap(
            CLOUD_NAME, cloudinary.getName(),
            API_KEY, cloudinary.getKey(),
            SECRET_KEY, cloudinary.getSecret()));
  }
}
