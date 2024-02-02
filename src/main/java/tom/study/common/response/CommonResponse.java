package tom.study.common.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;

import java.util.List;

/**
 * @param errors Errors가 없다면 응답이 내려가지 않게 처리
 */
@Builder
public record CommonResponse<T>(int status, String code, String message, T data,
                                @JsonInclude(JsonInclude.Include.NON_EMPTY) List<ValidationError> errors) {
    public static CommonResponse<Object> CommonResponseSuccess(Object data) {
        return CommonResponse.builder().status(200).code("SUCCESS").message("OK").data(data).build();
    }

    public static CommonResponse<Object> CommonResponseSuccessMessage() {
        return CommonResponse.builder().status(200).code("SUCCESS").message("OK").data("SUCCESS").build();
    }

    public static CommonResponse<Object> CommonResponseUnauthorized(String message) {
        return CommonResponse.builder().status(401).code("Unauthorized").message(message).build();
    }

    public static ResponseEntity<Object> ResponseEntitySuccess(Object data) {
        return ResponseEntity.status(200).body(CommonResponseSuccess(data));
    }

    public static ResponseEntity<Object> ResponseEntitySuccessMessage() {
        return ResponseEntity.status(200).body(CommonResponseSuccess("SUCCESS"));
    }

    public static ResponseEntity<Object> ResponseEntityUnauthorized(String message) {
        return ResponseEntity.status(401).body(CommonResponseUnauthorized(message));
    }
    @Getter
    @Builder
    @RequiredArgsConstructor
    public static class ValidationError {
        // @Valid 로 에러가 들어왔을 때, 어느 필드에서 에러가 발생했는 지에 대한 응답 처리
        private final String field;
        private final String message;

        public static ValidationError of(final FieldError fieldError) {
            return ValidationError.builder()
                    .field(fieldError.getField())
                    .message(fieldError.getDefaultMessage())
                    .build();
        }
    }


}
