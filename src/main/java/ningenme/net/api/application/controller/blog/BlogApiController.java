package ningenme.net.api.application.controller.blog;

import ningenme.net.api.application.generated.api.BlogApi;
import ningenme.net.api.application.generated.model.BlogsPostedCountsGetResponseView;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BlogApiController implements BlogApi {

    @Override
    public ResponseEntity<BlogsPostedCountsGetResponseView> blogsPostedCountsGet() {
        return ResponseEntity.ok(new WrapperBlogsPostedCountGetResponseView());
    }
}
