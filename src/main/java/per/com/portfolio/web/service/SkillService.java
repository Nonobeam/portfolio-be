package per.com.portfolio.web.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import per.com.portfolio.web.model.response.SkillResponse;
import per.com.portfolio.web.repository.SkillRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SkillService {

  private final SkillRepository skillRepository;

  public List<SkillResponse> getSkillList() {
    return skillRepository.findAll()
            .stream()
            .map(SkillResponse::fromSkill)
            .collect(Collectors.toList());
  }
}
