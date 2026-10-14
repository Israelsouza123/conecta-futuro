package br.com.freeladaquebrada.model;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "avaliacao")
public class Avaliacao {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) private Long id;
    @Column(name = "cliente") private String cliente;
    @Column(name = "nota") private Integer nota;
    @Column(name = "comentario") private String comentario;
    @Column(name = "servico_id") private Long servicoId;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getCliente() { return cliente; }
    public void setCliente(String v) { this.cliente = v; }
    public Integer getNota() { return nota; }
    public void setNota(Integer v) { this.nota = v; }
    public String getComentario() { return comentario; }
    public void setComentario(String v) { this.comentario = v; }
    public Long getServicoId() { return servicoId; }
    public void setServicoId(Long v) { this.servicoId = v; }
}
