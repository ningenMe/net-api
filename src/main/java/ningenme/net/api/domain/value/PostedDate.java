package ningenme.net.api.domain.value;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Data
@Slf4j
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class PostedDate {

    @NonNull
    private final LocalDate value;

    public static PostedDate of(@NonNull final LocalDate value) {
        return new PostedDate(value);
    }

    public static PostedDate of(@NonNull final String value) {
        return new PostedDate(LocalDate.parse(value.substring(0,10)));
    }
}
