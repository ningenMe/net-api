package ningenme.net.api.infrastructure.mysql.mapper;

import ningenme.net.api.infrastructure.mysql.dto.BlogDto;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface BlogMysqlMapper {

  @Insert(
          "<script>" +
          "REPLACE INTO blogs (url,date,type,title) VALUES " +
          "<foreach item='item' collection='blodDtoList' open='' separator=',' close=''>" +
          "(#{item.url},#{item.postedDate},#{item.blogType},#{item.blogTitle}) " +
          "</foreach>" +
          "</script>"
  )
  void insert(@Param("blodDtoList") List<BlogDto> blogDtoList);

  @Select(
          "<script>" +
          "SELECT url,date AS postedDate,type AS blogType,title AS blogTitle FROM blogs WHERE type IN " +
          "<foreach item='item' collection='blogTypeList' open='(' separator=',' close=') '>" +
          "#{item} " +
          "</foreach>" +
          "ORDER BY postedDate DESC" +
          "</script>"
  )
  List<BlogDto> select(@Param("blogTypeList") List<String> blogTypeList);

}
