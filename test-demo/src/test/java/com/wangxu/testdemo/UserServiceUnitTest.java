package com.wangxu.testdemo;

import com.wangxu.testdemo.api.UserRepository;
import com.wangxu.testdemo.module.User;
import com.wangxu.testdemo.service.UserService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.assertj.core.api.Assertions.assertThat;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class UserServiceUnitTest {
    @Mock
    private UserRepository userRepository;
    @InjectMocks
    private UserService userService;
    @Test
    void testCreateUser_success(){
        User savedFromRepo = new User(1L, "Bob", 30);
        when(userRepository.save(any(User.class))).thenReturn(savedFromRepo);

        User result = userService.createUser("Bob", 30);

        assertThat(result).isNotNull();
        assertThat(result.getId()).isEqualTo(1L);
        assertThat(result.getName()).isEqualTo("Bob");

        // 使用 ArgumentCaptor 验证传入 repository.save 的对象（即 createUser 构造的 user）
        ArgumentCaptor<User> captor = ArgumentCaptor.forClass(User.class);
        verify(userRepository, times(1)).save(captor.capture());
        User passedToSave = captor.getValue();
        assertThat(passedToSave.getId()).isNull();   // 在保存前 id 应该为空
        assertThat(passedToSave.getName()).isEqualTo("Bob");
        assertThat(passedToSave.getAge()).isEqualTo(30);

        // 验证没有其他与 mock 的交互
        verifyNoMoreInteractions(userRepository);

    }

    @Test
    void testCreateUser_invalidName_throws() {
        // 传入非法 name 应直接抛出异常，不调用 repository.save
        assertThatThrownBy(() -> userService.createUser("", 20))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("name");
        verify(userRepository, never()).save(any());
    }

    @Test
    void testCreateUser_repositoryThrowsRuntimeException_propagates() {
        // 模拟 repository 抛异常，检测 service 是否会抛出（或如何处理）
        when(userRepository.save(any())).thenThrow(new RuntimeException("db down"));

        assertThatThrownBy(() -> userService.createUser("Alice", 25))
                .isInstanceOf(RuntimeException.class)
                .hasMessageContaining("db down");

        verify(userRepository).save(any());
    }
}
