package com.raisetech.homework9.controller;

import com.raisetech.homework9.entity.CreateForm;
import com.raisetech.homework9.entity.Name;
import com.raisetech.homework9.entity.UpdateForm;
import java.net.URI;
import java.util.List;
import com.raisetech.homework9.service.NameService;
import java.util.Map;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RequestMapping("/names")
@RestController
public class NameController {

  private final NameService nameService;

  public NameController(NameService nameService) {
    this.nameService = nameService;
  }

  @GetMapping
  public List<NameResponse> getNames() {
    return nameService.findAll().stream().map(NameResponse::new).toList();
  }

  @GetMapping("/{id}")
  public NameResponse getNameById(@PathVariable("id") int id) throws Exception {
    return new NameResponse(nameService.findById(id));
  }

  @PostMapping
  public ResponseEntity<String> CreateName(@RequestBody @Validated CreateForm form,
      UriComponentsBuilder builder) {

    // 登録処理
    Name name = NameService.createName(form);
    URI url = builder.path("/names/" + name.getId()) // id部分は実際に登録された際に発⾏したidを設定する
        .build().toUri();

    return ResponseEntity.created(url).body(Map.of("message", "name successfully created"));
  }

  @PatchMapping("/{id}")
  public ResponseEntity<Map<String, String>> updateUser(@PathVariable("id") int id,
      @Validated @RequestBody UpdateForm updateForm) {

    //更新処理
    nameService.updateName(id, updateForm);

    return ResponseEntity.ok(Map.of("message", "user successfully updated"));
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Map<String, String>> deleteUser(@PathVariable("id") int id) {

    // 削除処理
    nameService.deleteName(id);

    return ResponseEntity.ok(Map.of("message", "user successfully deleted"));
  }
}