package br.com.Sistema.ProjetoZelda.Controller;

import br.com.Sistema.ProjetoZelda.Model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
@RepositoryRestResource(collectionResourceRel = "model", path = "model")
public interface UserController extends JpaRepository<UserModel, Long> {
}
