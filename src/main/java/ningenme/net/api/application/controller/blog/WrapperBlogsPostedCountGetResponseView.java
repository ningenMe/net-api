package ningenme.net.api.application.controller.blog;

import ningenme.net.api.application.generated.model.BlogsPostedCountsGetResponseView;

import java.util.List;

public class WrapperBlogsPostedCountGetResponseView extends BlogsPostedCountsGetResponseView {

    public WrapperBlogsPostedCountGetResponseView() {
        super();
        this.monthCounts(List.of());
    }
}
