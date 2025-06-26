package per.com.portfolio.web.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import per.com.portfolio.web.domain.Project;
import per.com.portfolio.web.repository.ProjectRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProjectService {

  private final ProjectRepository projectRepository;

  public List<Project> getAll() {
    return projectRepository.findAll();
  }
}
