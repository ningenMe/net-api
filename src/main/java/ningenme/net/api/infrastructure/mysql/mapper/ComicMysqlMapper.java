package ningenme.net.api.infrastructure.mysql.mapper;

import ningenme.net.api.infrastructure.mysql.dto.ComicDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ComicMysqlMapper {

  @Select(
          "<script>" +
          "SELECT comic_id,isbn13,url,work_id,comic_name,published_date FROM comics WHERE isbn13 IN " +
          "<foreach item='item' collection='isbn13List' open='(' separator=',' close=') '>" +
          "#{item} " +
          "</foreach>" +
          "ORDER BY published_date DESC" +
          "</script>"
  )
  List<ComicDto> select(@Param("isbn13List") List<String> isbn13List);

}
