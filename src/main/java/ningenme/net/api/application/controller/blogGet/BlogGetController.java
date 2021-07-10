package ningenme.net.api.application.controller.blogGet;

import lombok.RequiredArgsConstructor;
import ningenme.net.api.domain.service.BlogService;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class BlogGetController {

  private final BlogService blogService;

//  @ApiOperation(value = "BlogGet")
//  @ApiResponses(value = {
//          @ApiResponse(code = 200, message = "OK"),
//  })
//  @GetMapping("/v1/blogs")
//  ResponseEntity<BlogGetResponse> getBlog(
//          @RequestParam("types") List<BlogType> blogTypeList) {
//    return ResponseEntity
//            .ok(BlogGetResponse.of(blogService.get(blogTypeList)));
//  }

}
