package ningenme.net.api.application.controller.comic;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import ningenme.net.api.application.controller.comic.isbnGet.IsbnGetResponse;
import ningenme.net.api.domain.entity.Comic;
import ningenme.net.api.domain.service.ComicService;
import ningenme.net.api.domain.value.Isbn13;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ComicController {

    private final ComicService comicService;

    @ApiOperation(value = "IsbnGet")
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "OK"),
    })
    @GetMapping("/v1/comics/isbns/{isbnList}")
    ResponseEntity<IsbnGetResponse> getComicByIsbn(
        @PathVariable("isbnList") List<String> isbnList) {
        final List<Comic> comicList = comicService.getComicByIsbn(Isbn13.of(isbnList));
        return ResponseEntity
            .ok(IsbnGetResponse.of(comicList));
    }

}
