package per.com.portfolio.web.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import per.com.portfolio.web.domain.Headline;
import per.com.portfolio.web.repository.HeadlineRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class HeadlineService {

  private final HeadlineRepository headlineRepository;

  public List<Headline> findAll() {
    return headlineRepository.findAll();
  }
}
