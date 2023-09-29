package forum.alura.api.controller;

import forum.alura.api.topico.DadosCadastroTopico;
import forum.alura.api.topico.DadosListagemTopico;
import forum.alura.api.topico.Topico;
import forum.alura.api.topico.TopicoRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("topicos")
public class TopicoController {

  @Autowired
  private TopicoRepository repository;

  @PostMapping
  @Transactional
  public void cadastrar(@RequestBody @Valid DadosCadastroTopico dados){
    repository.save(new Topico(dados));
  }

  @GetMapping
  public List<DadosListagemTopico> listar(){
    return repository.findAll().stream().map(DadosListagemTopico::new).toList();
  }
}
