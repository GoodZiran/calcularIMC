package calculadora_imc.controller;


import java.util.ArrayList;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import calculadora_imc.model.InfoUsuario;
import calculadora_imc.model.Usuario;
import calculadora_imc.repository.UserRepository;

@RestController
@RequestMapping("/calcular")
public class CalculadoraController {
    @Autowired
    private UserRepository tabelaUsuarios;

    @PostMapping
    public Usuario calculoIMC(@RequestBody Usuario usuario) {
        InfoUsuario infoUsuario = new InfoUsuario();
        String imc = infoUsuario.calculoIMC(usuario.peso, usuario.altura);
        usuario.resultado = imc;

        return tabelaUsuarios.save(usuario);

    }

    @GetMapping
    public ArrayList <Usuario> getAll(){
        return (ArrayList<Usuario>) tabelaUsuarios.findAll();

    }
    
    @PutMapping ("/{id}")
    public Usuario userUpdate(@PathVariable Integer id, @RequestBody Usuario usuario) {
        Usuario idUsuario = tabelaUsuarios.findById(id).get();
        idUsuario.altura = usuario.altura;
        idUsuario.peso = usuario.peso;
        idUsuario.resultado = usuario.resultado;

        return tabelaUsuarios.saveAndFlush(idUsuario);

    }
    @DeleteMapping ("/{id}")
    public String deleteUsuario(@PathVariable Integer id){
        tabelaUsuarios.deleteById(id);
        return "Usuário deletado";

    }
}