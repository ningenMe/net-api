package ningenme.net.api.application.controller.blogGet;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import ningenme.net.api.domain.service.BlogService;
import ningenme.net.api.domain.value.BlogType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class BlogGetController {

  private final BlogService blogService;

  @ApiOperation(value = "BlogGet")
  @ApiResponses(value = {
          @ApiResponse(code = 200, message = "OK"),
  })
  @GetMapping("/v1/blogs")
  ResponseEntity<BlogGetResponse> getApplicationMetaLatest(
          @RequestParam("types") List<BlogType> blogTypeList) {
    return ResponseEntity
            .ok(BlogGetResponse.of(blogService.get(blogTypeList)));
  }

}
