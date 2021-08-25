package ningenme.net.api.infrastructure.mysql.mapper;

import ningenme.net.api.infrastructure.mysql.dto.BlogDto;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.time.LocalDate;
import java.util.List;

@Mapper
public interface BlogMysqlMapper {

  @Insert(
          "<script>" +
          "INSERT INTO blogs (url,date,type,title,liked) VALUES " +
          "<foreach item='item' collection='blodDtoList' open='' separator=',' close=''>" +
          "(#{item.url},#{item.postedDate},#{item.blogType},#{item.blogTitle},#{item.liked}) " +
          "</foreach>" +
          "ON DUPLICATE KEY UPDATE title=VALUES(title), liked=VALUES(liked)" +
          "</script>"
  )
  void upsert(@Param("blodDtoList") List<BlogDto> blogDtoList);

  @Insert(
          "<script>" +
          "INSERT INTO blogs (url,date,type,title,liked) VALUES " +
          "<foreach item='item' collection='blodDtoList' open='' separator=',' close=''>" +
          "(#{item.url},#{item.postedDate},#{item.blogType},#{item.blogTitle},#{item.liked}) " +
          "</foreach>" +
          "ON DUPLICATE KEY UPDATE title=VALUES(title)" +
          "</script>"
  )
  void insert(@Param("blodDtoList") List<BlogDto> blogDtoList);


  @Select(
          "<script>" +
          "SELECT url,date AS postedDate,type AS blogType,title AS blogTitle,liked FROM blogs WHERE type IN " +
          "<foreach item='item' collection='blogTypeList' open='(' separator=',' close=') '>" +
          "#{item} " +
          "</foreach>" +
          "ORDER BY postedDate DESC" +
          "</script>"
  )
  List<BlogDto> select(@Param("blogTypeList") List<String> blogTypeList);

  @Select(
          "SELECT url,date AS postedDate,type AS blogType,title AS blogTitle,liked FROM blogs WHERE type = 'DIARY' " +
          "AND date = #{postedDate} LIMIT 1"
  )
  BlogDto getDiaryByPostedDate(@Param("postedDate") LocalDate postedDate);

}
