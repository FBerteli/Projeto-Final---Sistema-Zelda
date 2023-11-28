package br.com.Sistema.ProjetoZelda.repository;

import br.com.Sistema.ProjetoZelda.Model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends JpaRepository<UserModel, Long>{
}