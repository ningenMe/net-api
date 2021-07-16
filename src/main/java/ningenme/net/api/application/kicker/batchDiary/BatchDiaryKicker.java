package ningenme.net.api.application.kicker.batchDiary;

import lombok.RequiredArgsConstructor;
import ningenme.net.api.domain.service.BlogService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class BatchDiaryKicker {

  private final BlogService blogService;

  @Scheduled(cron = "0 */10 * * * *", zone = "Asia/Tokyo")
  void kickDiaryBlog() {
    blogService.processDiary();
  }

}
