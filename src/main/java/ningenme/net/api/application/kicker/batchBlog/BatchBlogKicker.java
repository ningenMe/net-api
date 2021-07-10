package ningenme.net.api.application.kicker.batchBlog;

import lombok.RequiredArgsConstructor;
import ningenme.net.api.domain.service.BlogService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class BatchBlogKicker {

  private final BlogService blogService;

  @Scheduled(cron = "0 0 5 * * *", zone = "Asia/Tokyo")
  void kickBatchBlog() {
    blogService.processBlog();
  }

}
