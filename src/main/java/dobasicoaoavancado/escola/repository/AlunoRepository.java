package dobasicoaoavancado.escola.repository;

import dobasicoaoavancado.escola.infratructure.entitys.Aluno;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AlunoRepository  extends JpaRepository<Aluno, Integer> {

    Optional<Aluno> findByCpf(String cpf);

    @Transactional
    void deleteByCpf(String cpf);
}
