package ningenme.net.api.infrastructure.comicmeMysql.mapper;

import ningenme.net.api.infrastructure.comicmeMysql.dto.ComicDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ComicMysqlMapper {

    @Select(
        "<script>" +
            "SELECT comic_id,isbn13,url,comics.work_id,comic_name,published_date,work_name,publisher_name FROM comics JOIN works ON comics.work_id = works.work_id WHERE isbn13 IN " +
            "<foreach item='item' collection='isbn13List' open='(' separator=',' close=') '>" +
            "#{item} " +
            "</foreach>" +
            "ORDER BY published_date DESC" +
            "</script>"
    )
    List<ComicDto> select(@Param("isbn13List") List<String> isbn13List);

    @Select(
        "SELECT COUNT(comic_id) FROM comics"
    )
    Integer selectCount();

}
