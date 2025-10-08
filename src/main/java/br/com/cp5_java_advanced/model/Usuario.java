package br.com.cp5_java_advanced.model;

import br.com.cp5_java_advanced.model.enums.Perfil;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "TDS_USUARIOS")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "usuario_seq")
    @SequenceGenerator(name = "usuario_seq", sequenceName = "SEQ_TDS_USUARIOS", allocationSize = 1)
    @Column(name = "id_usuario")
    private Long id;

    @Column(nullable = false, length = 150)
    private String nome;

    @Column(nullable = false, length = 150, unique = true)
    private String email;

    @Column(nullable = false, length = 150)
    private String senha;

    @Enumerated(EnumType.STRING)
    @Column(name = "perfil", nullable = false, length = 20)
    private Perfil perfil;
}
