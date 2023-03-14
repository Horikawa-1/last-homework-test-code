package com.raisetech.homework9.mapper;


import java.util.List;
import java.util.Optional;
import com.raisetech.homework9.entity.Name;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper    // MyBatisのMapperである⽬印として@Mapperアノテーションを付与する
public interface NameMapper {     // classではなくinterfaceで定義する

  @Select("SELECT * FROM names")
  List<Name> findAll();

  @Select("SELECT * FROM names WHERE id = #{id}")
  Optional<Name> findById(int id);

  @Options(useGeneratedKeys = true, keyColumn = "id")
  @Insert("INSERT INTO names (name) VALUES (#{name})")
  void insertName(Name name);

  @Update("UPDATE names SET name=#{name} WHERE id = #{id}")
  void updateName(int id, String name);

  @Delete("DELETE FROM names WHERE id = #{id}")
  void deleteName(int id);
}
