package forum.alura.api.domain.topico;

import java.time.LocalDateTime;

public record DadosDetalhamentoTopico(String titulo, String mensagem, LocalDateTime dataCriacao, String status,
                                      String autor, String curso) {
  public DadosDetalhamentoTopico(Topico topico) {
    this(topico.getTitulo(), topico.getMensagem(), topico.getDataCriacao(), topico.getStatus(),
            topico.getAutor(), topico.getCurso());
  }
}
