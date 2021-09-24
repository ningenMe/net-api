package ningenme.net.api.application.controller.swagger;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Api(value = "Swagger")
@Controller
public class SwaggerController {

  @ApiOperation(value = "SwaggerGet")
  @ApiResponses(value = {
          @ApiResponse(code = 200, message = "OK"),
  })
  @GetMapping("/v1/swagger")
  String getSwagger() {
    return "forward:/v2/api-docs?group=ningenme.net.api";
  }

}
