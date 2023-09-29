package forum.alura.api.topico;

import java.time.LocalDateTime;

public record DadosListagemTopico(Long id, String titulo, String mensagem, LocalDateTime dataCriacao, String status,
                                  String autor, String curso) {

  public DadosListagemTopico(Topico topico){
    this(topico.getId(), topico.getTitulo(), topico.getMensagem(), topico.getDataCriacao(), topico.getStatus(),
            topico.getAutor(), topico.getCurso());
  }
}
