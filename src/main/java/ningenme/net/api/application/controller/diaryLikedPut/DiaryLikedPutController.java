package ningenme.net.api.application.controller.diaryLikedPut;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import ningenme.net.api.application.OkResponse;
import ningenme.net.api.domain.service.BlogService;
import ningenme.net.api.domain.value.PostedDate;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class DiaryLikedPutController {

  private final BlogService blogService;

  @ApiOperation(value = "DiaryLikedPut")
  @ApiResponses(value = {
          @ApiResponse(code = 200, message = "OK"),
  })
  @PutMapping("/v1/diaries/{date}/liked")
  ResponseEntity<OkResponse> putDiaryLiked(
          @PathVariable("date") String date) {
    blogService.putDiaryLiked(PostedDate.of(date));
    return ResponseEntity
            .ok(OkResponse.of());
  }
}
