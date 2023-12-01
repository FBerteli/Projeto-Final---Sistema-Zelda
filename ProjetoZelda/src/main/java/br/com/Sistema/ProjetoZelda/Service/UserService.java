package br.com.Sistema.ProjetoZelda.Service;

import br.com.Sistema.ProjetoZelda.Model.UserModel;
import br.com.Sistema.ProjetoZelda.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserService {
    @Autowired

    private UserRepository userRepository;

    public ResponseEntity<List<UserModel>> acharTodosUsuarios() {
        return ResponseEntity.ok(userRepository.findAll());
    }

    public ResponseEntity<UserModel> adicionarUsuario(UserModel user) {
        return ResponseEntity.ok(userRepository.save(user));
    }


    public ResponseEntity<Optional<UserModel>> buscarUsuario(Long id) {
        if (userRepository.findById(id).isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        else {
            return ResponseEntity.ok(userRepository.findById(id));
        }
    }

    public ResponseEntity<UserModel> editarUsuario(Long id_user, UserModel user) {
        if (userRepository.existsById(id_user)) {
            user.setIdUser(id_user);
            return ResponseEntity.ok(userRepository.save(user));
        }
        return ResponseEntity.notFound().build();
    }

    public ResponseEntity<String> deletarUsuario(Long id) {
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
            return ResponseEntity.ok("Usuário deletado com sucesso");
        }
        return ResponseEntity.notFound().build();
    }
}
