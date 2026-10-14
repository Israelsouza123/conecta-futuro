package br.com.freeladaquebrada.model;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "servico")
public class Servico {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) private Long id;
    @Column(name = "titulo") private String titulo;
    @Column(name = "descricao") private String descricao;
    @Column(name = "preco") private BigDecimal preco;
    @Column(name = "prestador_id") private Long prestadorId;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getTitulo() { return titulo; }
    public void setTitulo(String v) { this.titulo = v; }
    public String getDescricao() { return descricao; }
    public void setDescricao(String v) { this.descricao = v; }
    public BigDecimal getPreco() { return preco; }
    public void setPreco(BigDecimal v) { this.preco = v; }
    public Long getPrestadorId() { return prestadorId; }
    public void setPrestadorId(Long v) { this.prestadorId = v; }
}
