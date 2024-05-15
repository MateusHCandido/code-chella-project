package br.com.alura.codechella.application.usecases;

import br.com.alura.codechella.application.gateways.RepositorioDeUsuario;
import br.com.alura.codechella.domain.Usuario;

public class AlterarUsuario {

    private final RepositorioDeUsuario repositorio;

    public AlterarUsuario(RepositorioDeUsuario repositorio) {
        this.repositorio = repositorio;
    }

    public Usuario alterarDadosUsuario(Usuario usuario){
        return repositorio.alterarUsuario(usuario.getCpf(), usuario.getEmail());
    }
}
