package com.max.generic_narrative.mapper;

import com.max.generic_narrative.bean.TestTable;
import java.util.List;
import org.apache.ibatis.annotations.*;

@Mapper
public interface TestTableMapper {

  @Insert("INSERT INTO test_table (money, user_id) VALUES (#{money}, #{userId})")
  @Options(useGeneratedKeys = true, keyProperty = "id")
  int insert(TestTable testTable);

  @Delete("DELETE FROM test_table WHERE id = #{id}")
  void delete(Long id);

  @Update("UPDATE test_table SET money = #{money}, user_id = #{userId} WHERE id = #{id}")
  void update(TestTable testTable);

  @Select("SELECT id, money, user_id FROM test_table WHERE id = #{id}")
  TestTable selectById(Long id);

  @Select("SELECT id, money, user_id FROM test_table")
  List<TestTable> selectAll();

}
