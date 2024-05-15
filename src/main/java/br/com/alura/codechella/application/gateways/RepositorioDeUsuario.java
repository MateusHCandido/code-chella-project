package br.com.alura.codechella.application.gateways;

import br.com.alura.codechella.domain.Usuario;

import java.util.List;

public interface RepositorioDeUsuario {

    Usuario cadastrarUsuario(Usuario usuario);

    List<Usuario> listarTodos();

    Usuario alterarUsuario(String cpf, String email);
}
