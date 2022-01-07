package ningenme.net.api.domain.value;

import lombok.*;
import lombok.extern.slf4j.Slf4j;
import ningenme.net.api.domain.entity.Blog;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@EqualsAndHashCode
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class PostedMonth {

    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM");

    @NonNull
    private final LocalDate value; //yyyy-MM-01の形式のみ

    public static PostedMonth of(@NonNull final PostedDate postedDate) {
        return new PostedMonth(postedDate.getValue().withDayOfMonth(1));
    }

    public static Map<PostedMonth,Integer> getPostedMonthCountMap(
        @NonNull final List<Blog> blogList
    ) {
        return blogList
            .stream()
            .collect(Collectors.groupingBy(
                Blog::getPostedMonth,
                Collectors.summingInt(blog -> 1)
            ));
    }

    public static List<PostedMonth> getPostedMonthList() {
        final LocalDate endMonth = LocalDate.now().withDayOfMonth(1);
        final LocalDate startMonth = endMonth.minusYears(2L);
        final List<PostedMonth> postedMonthList = new ArrayList<>();
        for(LocalDate month = startMonth; !month.isAfter(endMonth); month = month.plusMonths(1L)) {
            postedMonthList.add(new PostedMonth(month));
        }
        return postedMonthList;
    }

    public String getYearMonth() {
        return value.format(DATE_TIME_FORMATTER);
    }
}
