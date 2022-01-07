package ningenme.net.api.application.controller.blog;

import lombok.NonNull;
import ningenme.net.api.application.generated.model.BlogsPostedCountsGetResponseView;
import ningenme.net.api.application.generated.model.MonthCountView;
import ningenme.net.api.domain.value.BlogMonthlyCount;

import java.util.List;
import java.util.stream.Collectors;

public class WrapperBlogsPostedCountGetResponseView extends BlogsPostedCountsGetResponseView {

    public WrapperBlogsPostedCountGetResponseView(
        @NonNull final List<BlogMonthlyCount> blogMonthlyCountList
    ) {
        super();
        this.monthCounts(
            blogMonthlyCountList
                .stream()
                .map(e -> new MonthCountView().month(e.getMonth()).count(e.getCount()))
                .collect(Collectors.toList())
        );
    }
}
