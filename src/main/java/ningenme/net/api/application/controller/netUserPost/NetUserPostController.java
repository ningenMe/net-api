package ningenme.net.api.application.controller.netUserPost;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import ningenme.net.api.application.OkResponse;
import ningenme.net.api.domain.entity.NetUser;
import ningenme.net.api.domain.service.NetUserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class NetUserPostController {

  private final NetUserService netUserService;

  @ApiOperation(value = "NetUserPost")
  @ApiResponses(value = {
          @ApiResponse(code = 200, message = "OK"),
  })
  @PostMapping("/v1/net/users")
  ResponseEntity<OkResponse> postNetUser(
          @RequestBody final NetUserPostRequest netUserPostRequest) {

    netUserService.post(NetUser.of(netUserPostRequest));

    return ResponseEntity
            .ok(OkResponse.of());
  }

}
