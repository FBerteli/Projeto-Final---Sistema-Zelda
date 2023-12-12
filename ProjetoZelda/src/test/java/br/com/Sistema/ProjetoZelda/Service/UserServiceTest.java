package br.com.Sistema.ProjetoZelda.Service;

import br.com.Sistema.ProjetoZelda.Model.UserModel;
import br.com.Sistema.ProjetoZelda.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testAcharTodosUsuarios() {
        List<UserModel> userList = Arrays.asList(new UserModel(), new UserModel());
        when(userRepository.findAll()).thenReturn(userList);

        ResponseEntity<List<UserModel>> response = userService.acharTodosUsuarios();

        assertEquals(ResponseEntity.ok(userList), response);
        verify(userRepository, times(1)).findAll();
    }

    @Test
    void testAdicionarUsuario() {
        UserModel user = new UserModel(1L, "Fulano", "fulano@gmail.com", "senha123");

        when(userRepository.save(any(UserModel.class))).thenReturn(user);

        ResponseEntity<UserModel> response = userService.adicionarUsuario(user);

        assertEquals(ResponseEntity.ok(user), response);
        verify(userRepository, times(1)).save(any(UserModel.class));
    }

    @Test
    void testBuscarUsuarioExistente() {
        Long userId = 1L;
        UserModel user = new UserModel(userId, "Fulano", "fulano@gmail.com", "senha123");

        when(userRepository.findById(userId)).thenReturn(Optional.of(user));

        ResponseEntity<Optional<UserModel>> response = userService.buscarUsuario(userId);

        assertEquals(ResponseEntity.ok(Optional.of(user)), response);
        verify(userRepository, times(1)).findById(userId);
    }

    @Test
    void testBuscarUsuarioNaoExistente() {
        Long userId = 1L;

        when(userRepository.findById(userId)).thenReturn(Optional.empty());

        ResponseEntity<Optional<UserModel>> response = userService.buscarUsuario(userId);

        assertEquals(ResponseEntity.notFound().build(), response);
        verify(userRepository, times(1)).findById(userId);
    }

    @Test
    void testEditarUsuarioExistente() {
        Long userId = 1L;
        UserModel updatedUser = new UserModel(userId, "Ciclano", "ciclano@gmail.com", "senhasegura");

        when(userRepository.existsById(userId)).thenReturn(true);
        when(userRepository.save(any(UserModel.class))).thenReturn(updatedUser);

        ResponseEntity<UserModel> response = userService.editarUsuario(userId, updatedUser);

        assertEquals(ResponseEntity.ok(updatedUser), response);
        verify(userRepository, times(1)).existsById(userId);
        verify(userRepository, times(1)).save(any(UserModel.class));
    }

    @Test
    void testEditarUsuarioNaoExistente() {
        Long userId = 1L;
        UserModel updatedUser = new UserModel(userId, "Beltrano", "beltrano@gmail.com", "senha456");

        when(userRepository.existsById(userId)).thenReturn(false);

        ResponseEntity<UserModel> response = userService.editarUsuario(userId, updatedUser);

        assertEquals(ResponseEntity.notFound().build(), response);
        verify(userRepository, times(1)).existsById(userId);
        verify(userRepository, times(0)).save(any(UserModel.class));
    }

    @Test
    void testDeletarUsuarioExistente() {
        Long userId = 1L;

        when(userRepository.existsById(userId)).thenReturn(true);

        ResponseEntity<String> response = userService.deletarUsuario(userId);

        assertEquals(ResponseEntity.ok("Usuário deletado com sucesso"), response);
        verify(userRepository, times(1)).existsById(userId);
        verify(userRepository, times(1)).deleteById(userId);
    }

    @Test
    void testDeletarUsuarioNaoExistente() {
        Long userId = 1L;

        when(userRepository.existsById(userId)).thenReturn(false);

        ResponseEntity<String> response = userService.deletarUsuario(userId);

        assertEquals(ResponseEntity.notFound().build(), response);
        verify(userRepository, times(1)).existsById(userId);
        verify(userRepository, times(0)).deleteById(userId);
    }
}