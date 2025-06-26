package per.com.portfolio.config.settings;

import lombok.Data;

@Data
public class CloudinarySetting {
  private String name;
  private String key;
  private String secret;
  private String rootLocation = "/images";
}
