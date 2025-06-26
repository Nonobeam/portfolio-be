package per.com.portfolio.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import per.com.portfolio.web.model.response.ApiResp;
import per.com.portfolio.web.service.CertificationService;
import per.com.portfolio.web.service.HeadlineService;
import per.com.portfolio.web.service.ProjectService;
import per.com.portfolio.web.service.SkillService;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class MyController {

  private final SkillService skillService;
  private final ProjectService projectService;
  private final HeadlineService headlineService;
  private final CertificationService certificationService;

  @GetMapping("/headlines")
  public ResponseEntity<?> getHeadlines() {
    return ApiResp.success(headlineService.findAll());
  }

  @GetMapping("/skills")
  public ResponseEntity<?> getSkillList() {
    return ApiResp.success(skillService.getSkillList());
  }

  @GetMapping("/certifications")
  public ResponseEntity<?> getCertificationList() {
    return ApiResp.success(certificationService.getCertificationList());
  }

  @GetMapping("/projects")
  public ResponseEntity<?> getProjectList() {
    return ApiResp.success(projectService.getAll());
  }
}
