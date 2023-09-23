package calculadora_imc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import calculadora_imc.model.Usuario;

public interface UserRepository extends JpaRepository < Usuario, Integer >{}

