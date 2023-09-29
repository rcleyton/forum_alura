package forum.alura.api.topico;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Table(name = "topicos")
@Entity(name = "Topicos")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Topico {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String titulo;

  private String mensagem;

  private String autor;

  private String curso;

  @Column(name = "data_criacao")
  private LocalDateTime dataCriacao;

  private String status;

  @PrePersist
  protected void onCreate(){
    dataCriacao = LocalDateTime.now();
  }

  public Topico(DadosCadastroTopico dados) {
    this.titulo = dados.titulo();
    this.mensagem = dados.mensagem();
    this.autor = dados.autor();
    this.curso = dados.curso();
    this.status = "Aberto";
  }

  public void atualizarInformacoes(DadosAtualizacaoTopico dados) {
    if (dados.titulo() != null){
      this.titulo = dados.titulo();
    }
    if (dados.mensagem() != null){
      this.mensagem = dados.mensagem();
    }
    if (dados.status() != null){
      this.status = dados.status();
    }
    if (dados.autor() != null){
      this.autor = dados.autor();
    }
    if (dados.curso() != null){
      this.curso = dados.curso();
    }
  }
}
