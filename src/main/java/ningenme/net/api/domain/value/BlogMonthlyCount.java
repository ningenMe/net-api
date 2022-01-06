package ningenme.net.api.domain.value;

import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import ningenme.net.api.domain.entity.Blog;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.stream.Collectors;

@Data
@RequiredArgsConstructor(staticName = "of")
public class BlogMonthlyCount implements Comparable<BlogMonthlyCount> {
    @NonNull
    private final String month;
    @NonNull
    private final Integer count;


    public static List<BlogMonthlyCount> getBlogMonthlyCountList(
        @NonNull final List<Blog> blogList
    ) {
        return blogList
            .stream()
            .collect(Collectors.groupingBy(
                blog -> blog.getPostedDate().getMonth(),
                Collectors.summingInt(blog -> 1)
            ))
            .entrySet()
            .stream()
            .map(entry -> BlogMonthlyCount.of(entry.getKey(), entry.getValue()))
            .sorted()
            .collect(Collectors.toList());
    }

    @Override
    public int compareTo(@NotNull BlogMonthlyCount o) {
        return month.compareTo(o.month);
    }
}
