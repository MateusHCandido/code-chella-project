package br.com.alura.codechella.domain.entities.usuario;

import br.com.alura.codechella.domain.Usuario;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class UsuarioTest {
    @Test
    public void naoDeveCadastrarUsuarioComCpfNoFormatoInvalido(){
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> new Usuario("123456789-99", "mateus@email.com", LocalDate.parse("1999-10-17"), "Mateus"));

       Assertions.assertThrows(IllegalArgumentException.class,
                () -> new Usuario("123456.789-99", "mateus@email.com", LocalDate.parse("1999-10-17"), "Mateus"));

        Assertions.assertThrows(IllegalArgumentException.class,
                () -> new Usuario("123.456789-99", "mateus@email.com", LocalDate.parse("1999-10-17"), "Mateus"));

        Assertions.assertThrows(IllegalArgumentException.class,
                () -> new Usuario("", "mateus@email.com", LocalDate.parse("1999-10-17"), "Mateus"));
    }

    @Test
    public void deveCadastrarUsuarioComCpfNoFormatoCorreto(){
        String mensagem = "";
        try{
            Usuario usuario = new Usuario("123.456.789-99", "mateus@email.com", LocalDate.parse("1999-10-17"), "Mateus");
            mensagem = "usuario criado";
        }catch (IllegalArgumentException e){
            e.printStackTrace();
        }

        Assertions.assertTrue("usuario criado".equals(mensagem));
    }

    @Test
    public void deveCriarUsuarioUsandoFabricaDeUsuario(){
        FabricaDeUsuario fabrica = new FabricaDeUsuario();
        Usuario usuario = fabrica.comNomeCpfNascimento("Emilly", "123.456.789-11", LocalDate.parse("1998-12-25"));

        Assertions.assertEquals(usuario.getNome(), "Emilly");

        usuario = fabrica.incluiEndereco("12345-999", 40, "Apto 623");

        Assertions.assertEquals(40, usuario.getEndereco().getNumero() );
    }
}
