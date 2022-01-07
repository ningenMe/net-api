package ningenme.net.api.domain.value;

import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import ningenme.net.api.domain.entity.Blog;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Data
@RequiredArgsConstructor
public class BlogMonthlyCount {
    @NonNull
    private final String month;
    @NonNull
    private final Integer count;

    private static BlogMonthlyCount of(
        @NonNull final PostedMonth postedMonth,
        @NonNull final Integer count
    ) {
        return new BlogMonthlyCount(postedMonth.getYearMonth(), count);
    }

    public static List<BlogMonthlyCount> getBlogMonthlyCountList(
        @NonNull final Map<PostedMonth,Integer> postedMonthCountMap
    ) {
        return PostedMonth
            .getPostedMonthList()
            .stream()
            .map(postedMonth -> BlogMonthlyCount.of(postedMonth,postedMonthCountMap.getOrDefault(postedMonth,0)))
            .collect(Collectors.toList());
    }

}
