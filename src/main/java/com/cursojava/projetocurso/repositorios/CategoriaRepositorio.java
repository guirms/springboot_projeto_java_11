package com.cursojava.projetocurso.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cursojava.projetocurso.entidades.Categoria;

public interface CategoriaRepositorio extends JpaRepository<Categoria, Long> {
	
	

}
