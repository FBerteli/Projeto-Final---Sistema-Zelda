package br.com.Sistema.ProjetoZelda.repository;

import br.com.Sistema.ProjetoZelda.Model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.*;

@Repository
public interface UserRepository extends JpaRepository<UserModel, Long>{

}