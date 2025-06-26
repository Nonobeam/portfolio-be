package per.com.portfolio.web.model.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.http.ResponseEntity;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ApiResp<T> {
  private boolean success;
  private T data;
  private ErrorResp error;

  public static <T> ResponseEntity<ApiResp<T>> success(T data) {
    return ResponseEntity.ok(ApiResp.<T>builder().success(true).data(data).build());
  }

  @Data
  @Builder
  public static class ErrorResp {
    private int code;
    private String message;
    private Object details;
  }
}
