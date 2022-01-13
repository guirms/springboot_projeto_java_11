package com.cursojava.projetocurso.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.cursojava.projetocurso.entidades.Categoria;
import com.cursojava.projetocurso.entidades.Pedido;
import com.cursojava.projetocurso.entidades.Usuario;
import com.cursojava.projetocurso.entidades.enums.StatusPedido;
import com.cursojava.projetocurso.repositorios.CategoriaRepositorio;
import com.cursojava.projetocurso.repositorios.PedidoRepositorio;
import com.cursojava.projetocurso.repositorios.UsuarioRepositorio;

@Configuration
@Profile("test")
public class TesteConfig implements CommandLineRunner {

	@Autowired //tras as dependencias do objeto instanciado
	private UsuarioRepositorio usuarioRepositorio;
	
	@Autowired
	private PedidoRepositorio pedidoRepositorio;
	
	@Autowired
	private CategoriaRepositorio categoriaRepositorio;
	
	@Override
	public void run(String... args) throws Exception {
		
		Categoria c1 = new Categoria(null, "Eletronicos");
		Categoria c2 = new Categoria(null, "Livros");
		Categoria c3 = new Categoria(null, "Computadores");

		categoriaRepositorio.saveAll(Arrays.asList(c1, c2, c3));
		
		Usuario u1 = new Usuario(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
		Usuario u2 = new Usuario(null, "Alex Green", "alex@gmail.com", "977777777", "123456");
		
		Pedido p1 = new Pedido(null, Instant.parse("2019-06-20T19:53:07Z"), StatusPedido.PAGO ,u1);
		Pedido p2 = new Pedido(null, Instant.parse("2019-07-21T03:42:10Z"), StatusPedido.AGUARDANDO_PAGAMENTO ,u2);
		Pedido p3 = new Pedido(null, Instant.parse("2019-07-22T15:21:22Z"), StatusPedido.AGUARDANDO_PAGAMENTO ,u1); 
		
		
		usuarioRepositorio.saveAll(Arrays.asList(u1, u2));
		pedidoRepositorio.saveAll(Arrays.asList(p1, p2, p3));
	
		
		
	}
	
	
}
