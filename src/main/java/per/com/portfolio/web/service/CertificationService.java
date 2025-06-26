package per.com.portfolio.web.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import per.com.portfolio.web.model.response.CertificationResponse;
import per.com.portfolio.web.repository.CertificationRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CertificationService {

  private final CertificationRepository certificationRepository;

  public List<CertificationResponse> getCertificationList() {
    return certificationRepository.findAll()
            .stream()
            .map(CertificationResponse::fromCertification)
            .collect(Collectors.toList());
  }
}
