package ningenme.net.api.application.controller.applicationMeta;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import ningenme.net.api.application.OkResponse;
import ningenme.net.api.application.controller.applicationMeta.getDto.ApplicationMetaGetResponse;
import ningenme.net.api.application.controller.applicationMeta.latestGetDto.ApplicationMetaLatestGetResponse;
import ningenme.net.api.domain.service.ApplicationMetaService;
import ningenme.net.api.domain.value.ApplicationMetaId;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ApplicationMetaController {

    private final ApplicationMetaService applicationMetaService;

    @ApiOperation(value = "ApplicationMetaGet")
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "OK"),
    })
    @GetMapping("/v1/application-metas/{applicationMetaId}")
    ResponseEntity<ApplicationMetaGetResponse> getApplicationMetaGet(
        @PathVariable("applicationMetaId") String applicationMetaId) {
        return ResponseEntity
            .ok(
                ApplicationMetaGetResponse.of(applicationMetaService.get(ApplicationMetaId.of(applicationMetaId)))
               );
    }

    @ApiOperation(value = "ApplicationMetaLatestGet")
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "OK"),
    })
    @GetMapping("/v1/application-metas/{applicationMetaId}/latest")
    ResponseEntity<ApplicationMetaLatestGetResponse> getApplicationMetaLatest(
        @PathVariable("applicationMetaId") String applicationMetaId) {
        return ResponseEntity
            .ok(
                ApplicationMetaLatestGetResponse.of(
                    applicationMetaService.getLatestOne(ApplicationMetaId.of(applicationMetaId)))
               );
    }

    @ApiOperation(value = "ApplicationMetaPost")
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "OK"),
    })
    @PostMapping("/v1/application-metas/{applicationMetaId}")
    ResponseEntity<OkResponse> postApplicationMeta(
        @PathVariable("applicationMetaId") String applicationMetaId) {
        applicationMetaService.post(ApplicationMetaId.of(applicationMetaId));
        return ResponseEntity
            .ok(OkResponse.of());
    }

}
