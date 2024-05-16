package br.com.alura.codechella.infra.controller;

public record UsuarioUpdateDto(
        Long usuarioId,
        String cpf,
        String email
) {
}
