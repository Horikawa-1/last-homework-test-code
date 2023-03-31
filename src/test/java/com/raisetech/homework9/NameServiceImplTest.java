package com.raisetech.homework9;


import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.verify;

import com.raisetech.homework9.entity.CreateForm;
import com.raisetech.homework9.entity.Name;
import com.raisetech.homework9.exception.ResourceNotFoundException;
import com.raisetech.homework9.mapper.NameMapper;
import com.raisetech.homework9.service.NameServiceImpl;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class NameServiceImplTest {

  @InjectMocks
  NameServiceImpl nameServiceImpl;

  @Mock
  NameMapper nameMapper;

  @Test
  public void すべてのメッセージが返されること() {
    doReturn(List.of(new Name(1, "Honma"), new Name(2, "Nakashima"), new Name(3, "Itou"))).when(
        nameMapper).findAll();

    List<Name> actual = nameServiceImpl.findAll();
    assertThat(actual).isEqualTo(
        List.of(new Name(1, "Honma"), new Name(2, "Nakashima"), new Name(3, "Itou")));
    verify(nameMapper).findAll();
  }

  @Test
  public void 存在するユーザーのIDを指定したときに正常にユーザーが返されること() throws Exception {
    doReturn(Optional.of(new Name(1, "Honma"))).when(nameMapper).findById(1);
    //findById(1)実行時、必ずid:1, name:Honma　を返す

    Name actual = nameServiceImpl.findById(1);
    assertThat(actual).isEqualTo(new Name(1, "Honma"));
    verify(nameMapper).findById(1);
  }

  @Test
  public void 存在しないユーザーIDを指定したときにResourceNotFoundExceptionがスローされること() {
    doReturn(Optional.empty()).when(nameMapper).findById(0);
    assertThatThrownBy(() -> nameServiceImpl.findById(0))
        .isInstanceOf(ResourceNotFoundException.class)
        .hasMessage("ID:" + "0" + " Not Found");

    verify(nameMapper).findById(0);
  }

  @Test
  public void ユーザーのnameが入力された時に正常にユーザーの登録をすること() throws Exception {
    doNothing().when(nameMapper).insertName(new Name (1, "Honma"));

    CreateForm actual = nameServiceImpl.createUser(name);
    assertThat(actual, equalTo(new UserForm("suzuki", 30)));
    verify(userMapper).registryUser("suzuki", 30);
  }
}
