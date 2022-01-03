package ningenme.net.api.application.controller.comicMe;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import ningenme.net.api.application.controller.comicMe.metaGet.ComicMeMetaGetResponse;
import ningenme.net.api.domain.service.ComicMeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ComicMeController {

    private final ComicMeService comicMeService;

    @ApiOperation(value = "MetaGet")
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "OK"),
    })
    @GetMapping("/v1/comicme/metas")
    ResponseEntity<ComicMeMetaGetResponse> getMeta() {
        return ResponseEntity
            .ok(ComicMeMetaGetResponse.of(comicMeService.getComicMeMeta()));
    }

}
