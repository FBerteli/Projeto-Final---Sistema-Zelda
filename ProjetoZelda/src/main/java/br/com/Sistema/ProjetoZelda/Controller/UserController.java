package br.com.Sistema.ProjetoZelda.Controller;

import br.com.Sistema.ProjetoZelda.Model.UserModel;
import br.com.Sistema.ProjetoZelda.repository.UserRepository;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController {
private static ArrayList<UserModel> users = new ArrayList<>();
    @Autowired
    private UserRepository userRepository;

    @RequestMapping(value = "/user", method = RequestMethod.GET, produces = "application/json")
    public List<UserModel> getAll() {
        return userRepository.findAll();
    }

    @RequestMapping(value = "/user/add", method = RequestMethod.POST, produces = "application/json")
    public ResponseEntity<String> addUser(UserModel user){
        users.add(user);
        return ResponseEntity.ok("Usuário adicionado com sucesso!");
    }

    @RequestMapping(value = "/user/att/{idUser}", method = RequestMethod.PUT, produces = "application/json")
    public ResponseEntity<String> attUser(@PathVariable long idUser, UserModel user){
        users.
    }

}
