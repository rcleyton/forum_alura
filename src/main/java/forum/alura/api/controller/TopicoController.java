package forum.alura.api.controller;

import forum.alura.api.topico.*;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("topicos")
public class TopicoController {

  @Autowired
  private TopicoRepository repository;

  @PostMapping
  @Transactional
  public ResponseEntity cadastrar(@RequestBody @Valid DadosCadastroTopico dados, UriComponentsBuilder uriBuilder){
    var topico = new Topico(dados);
    repository.save(topico);
    var uri = uriBuilder.path("/topicos/{id}").buildAndExpand(topico.getId()).toUri();
    return ResponseEntity.created(uri).body(new DadosDetalhamentoTopico(topico));
  }

  @GetMapping
  public Page<DadosListagemTopico> listar(@PageableDefault(size = 10, sort = {"dataCriacao"}) Pageable paginacao){
    return repository.findAll(paginacao).map(DadosListagemTopico::new);
  }

  @GetMapping("/{id}")
  public ResponseEntity detalhar(@PathVariable Long id){
    var topico = repository.getReferenceById(id);
    return ResponseEntity.ok(new DadosDetalhamentoTopico(topico));
  }

  @PutMapping
  @Transactional
  public ResponseEntity atualizar(@RequestBody @Valid DadosAtualizacaoTopico dados){
    var topico = repository.getReferenceById(dados.id());
    topico.atualizarInformacoes(dados);
    return ResponseEntity.ok(new DadosDetalhamentoTopico(topico));
  }

  @DeleteMapping("/{id}")
  @Transactional
  public ResponseEntity excluir(@PathVariable Long id){
    repository.deleteById(id);
    return ResponseEntity.noContent().build();
  }
}
