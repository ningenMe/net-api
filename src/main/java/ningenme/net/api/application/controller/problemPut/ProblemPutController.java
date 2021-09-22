package ningenme.net.api.application.controller.problemPut;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ningenme.net.api.application.OkResponse;
import ningenme.net.api.domain.entity.Problem;
import ningenme.net.api.domain.service.ProblemService;
import ningenme.net.api.domain.value.Estimation;
import ningenme.net.api.domain.value.Url;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Slf4j
public class ProblemPutController {

    private final ProblemService problemService;

    @ApiOperation(value = "ProblemPut")
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "OK"),
    })
    @PutMapping("/v1/problems")
    ResponseEntity<OkResponse> putProblem(@RequestBody final ProblemPutRequest problemPutRequest) {

        problemService.putProblem(Problem.builder()
                                         .url(Url.of(problemPutRequest.getUrl()))
                                         .estimation(Estimation.of(problemPutRequest.getEstimation()))
                                         .build());

        return ResponseEntity
            .ok(OkResponse.of());
    }
}
