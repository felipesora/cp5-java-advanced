package br.com.cp5_java_advanced.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Table(name = "TDS_FERRAMENTAS")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Ferramenta {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ferramenta_seq")
    @SequenceGenerator(name = "ferramenta_seq", sequenceName = "SEQ_TDS_FERRAMENTAS", allocationSize = 1)
    @Column(name = "id_ferramenta")
    private Long id;

    @Column(nullable = false, length = 100)
    private String nome;

    @Column(nullable = false, length = 150)
    private String descricao;

    @Column(nullable = false, length = 40)
    private String categoria;

    @Column(nullable = false, length = 40)
    private String marca;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal preco;

    @Column(nullable = false, precision = 10)
    private int quantidade;
}
