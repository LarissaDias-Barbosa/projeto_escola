package dobasicoaoavancado.escola.infratructure.entitys;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "Aluno")
@Entity
public class Aluno {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "cpf", unique = true)
    private String cpf;

    @Column(name = "nome")
    private String nome;

    @JsonFormat(pattern = "yy/MM/dd")
    @Column(name = "data_nascimento")
    private LocalDate dataNascimento;
}
