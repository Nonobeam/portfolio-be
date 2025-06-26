package per.com.portfolio.web.model.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import per.com.portfolio.web.domain.Skill;

import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SkillResponse {
  private UUID id;
  private String name;

  public static SkillResponse fromSkill(Skill skill) {
    return SkillResponse.builder()
            .id(skill.getId())
            .name(skill.getName())
            .build();
  }
}
