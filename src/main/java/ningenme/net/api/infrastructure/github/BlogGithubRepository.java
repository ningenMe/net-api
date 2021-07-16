package ningenme.net.api.infrastructure.github;

import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import ningenme.net.api.domain.entity.Blog;
import ningenme.net.api.domain.value.BlogTitle;
import ningenme.net.api.domain.value.BlogType;
import ningenme.net.api.domain.value.PostedDate;
import ningenme.net.api.domain.value.Url;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Repository
@Slf4j
public class BlogGithubRepository {

  private final static String URL = "https://github.com/ningenMe/net-front/tree/main/public/markdown/";
  private final static String RAW_URL = "https://raw.githubusercontent.com/ningenMe/net-front/main/public/markdown/";
  private final static String DOMAIN = "https://ningenme.net/diaries/";

  public List<Blog> getBlog() {
    List<Blog> blogList = List.of();
    for(Integer year=2021; year < 2040; year += 1) {
      try {
        blogList = Stream.concat(blogList.stream(),getBlog(year).stream())
                         .collect(Collectors.toList());
      } catch (Exception ex) {
      }
    }
    return blogList;
  }

  private List<Blog> getBlog(@NonNull final Integer year) {
    try {
      Document document = Jsoup.connect(URL + year.toString()).get();
      final Elements elements = document.select("[class=js-navigation-open Link--primary]");

      List<Blog> blogList = new ArrayList<>();
      for (final Element element: elements.stream().collect(Collectors.toList())) {
        final String md  = element.text();
        final String date = md.substring(0,5);
        final String postedDate = year.toString() + "-" + date;
        final String url = DOMAIN + postedDate;
        Document mdDocument = Jsoup.connect(RAW_URL + year.toString() + "/" + md).get();
        final String title = Arrays.asList(mdDocument.select("body").toString().split("\\r?\\n")).get(1).substring(3);
        blogList.add(
                Blog.builder()
                    .blogType(BlogType.DIARY)
                    .blogTitle(BlogTitle.of(title))
                    .postedDate(PostedDate.of(postedDate))
                    .url(Url.of(url))
                    .build());
      }
      return blogList;
    }
    catch (Exception ex) {
      throw new RuntimeException(ex);
    }
  }

}
