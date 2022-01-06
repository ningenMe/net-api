package ningenme.net.api.application.controller.blog;

import lombok.RequiredArgsConstructor;
import ningenme.net.api.application.generated.api.BlogApi;
import ningenme.net.api.application.generated.model.BlogsPostedCountsGetResponseView;
import ningenme.net.api.domain.service.BlogService;
import ningenme.net.api.domain.value.BlogMonthlyCount;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class BlogApiController implements BlogApi {

    private final BlogService blogService;

    @Override
    public ResponseEntity<BlogsPostedCountsGetResponseView> blogsPostedCountsGet() {
        final List<BlogMonthlyCount> blogMonthlyCountList = blogService.getBlogMonthlyCountList();
        return ResponseEntity.ok(new WrapperBlogsPostedCountGetResponseView(blogMonthlyCountList));
    }
}
