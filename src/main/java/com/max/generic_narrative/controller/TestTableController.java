package com.max.generic_narrative.controller;

import com.max.generic_narrative.bean.TestTable;
import com.max.generic_narrative.mapper.TestTableMapper;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/table")
public class TestTableController {

  @Resource
  private TestTableMapper mapper;

  @GetMapping("/queryAll")
  public Object queryAll() {
    return mapper.selectAll();
  }

  /**
    curl -X POST http://localhost:10087/table/insertOne \
         -H "Content-Type: application/json" \
         -d '{
               "id": 1,
               "money": 1000,
               "userId": 123
             }'

   Invoke-WebRequest -Uri http://localhost:10087/table/insertOne -Method POST -ContentType "application/json" -Body '{"id": 1, "money": 1000, "userId": 123}'
   */
  @PostMapping("insertOne")
  public Object insertOne(@RequestBody TestTable testTable) {
    return mapper.insert(testTable);
  }

}
