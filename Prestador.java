package br.com.freeladaquebrada.model;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "prestador")
public class Prestador {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) private Long id;
    @Column(name = "nome") private String nome;
    @Column(name = "telefone") private String telefone;
    @Column(name = "bairro") private String bairro;
    @Column(name = "especialidade") private String especialidade;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getNome() { return nome; }
    public void setNome(String v) { this.nome = v; }
    public String getTelefone() { return telefone; }
    public void setTelefone(String v) { this.telefone = v; }
    public String getBairro() { return bairro; }
    public void setBairro(String v) { this.bairro = v; }
    public String getEspecialidade() { return especialidade; }
    public void setEspecialidade(String v) { this.especialidade = v; }
}
