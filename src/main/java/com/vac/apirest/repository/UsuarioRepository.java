package com.vac.apirest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vac.apirest.models.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
	}
