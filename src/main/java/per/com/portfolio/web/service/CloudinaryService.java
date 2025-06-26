package per.com.portfolio.web.service;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

@Slf4j
@Service
@RequiredArgsConstructor
public class CloudinaryService {
  private final Cloudinary cloudinary;

  public Map<?, ?> upload(MultipartFile file) {
    try {
      return cloudinary.uploader().upload(file.getBytes(), ObjectUtils.emptyMap());
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

  public static String getImageUrl(Map<?, ?> uploadResult) {
    if (uploadResult == null || !uploadResult.containsKey("secure_url")) {
      throw new IllegalArgumentException("Invalid upload result: " + uploadResult);
    }
    return uploadResult.get("secure_url").toString();
  }
}
