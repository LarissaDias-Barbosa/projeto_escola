package dobasicoaoavancado.escola;

import dobasicoaoavancado.escola.infratructure.entitys.Aluno;
import dobasicoaoavancado.escola.repository.AlunoRepository;
import dobasicoaoavancado.escola.service.AlunoService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
public class AlunoServiceTest {

    @Mock
    private AlunoRepository alunoRepository;

    @InjectMocks
    private AlunoService alunoService;

    @BeforeEach
    void SetUp(){

    }

    @Test
    void DeveSalvarAlunoComSucesso(){
        Aluno alunoParaSalvar = Aluno.builder()
                        .id(1)
                        .nome("Marcela")
                        .cpf("87655589")
                        .dataNascimento(LocalDate.of(2000,1,15))
                        .build();

        // Act: executa o metodo de salvar
        alunoService.salvarAluno(alunoParaSalvar);

        //Act: Verifica se o repositório foi chamado corretamente
        verify(alunoRepository).saveAndFlush(alunoParaSalvar);
    }

    @Test
    void DeveBuscarAlunoPorCpfComSucesso(){
        String cpf = "87655589";
        Aluno alunoEsperado = Aluno.builder()
                .id(1)
                .nome("Marcela")
                .cpf("87655589")
                .dataNascimento(LocalDate.of(2000,1,15))
                .build();

        when(alunoRepository.findByCpf(cpf)).thenReturn(Optional.of(alunoEsperado));

        //Act: executa o metodo de buscar o aluno
        Aluno resultado = alunoService.buscarAlunoPorCpf(cpf);

        //Assert
        assertEquals(alunoEsperado, resultado);
        verify(alunoRepository).findByCpf(cpf);
    }

    @Test
    void DeveDeletarAlunoPorCpfComSucesso(){
        String cpf = "87655589";

        alunoService.deletarAlunoPorCpf(cpf);

        verify(alunoRepository).deleteByCpf(cpf);
    }

    @Test
    void DeveAtualizarAlunoPorId(){
        Integer id = 1;

        Aluno alunoExistente = Aluno.builder()
                .id(1)
                .nome("Marcela")
                .cpf("87655589")
                .build();

        Aluno dadosAtualizados = Aluno.builder()
                .nome("Marcela")
                .build();

        Aluno alunoEsperadoParaSalvar = Aluno.builder()
                .id(1)
                .nome("Marcela")
                .cpf("87655589")
                .build();

        when(alunoRepository.findById(id)).thenReturn(Optional.of(alunoExistente));

        alunoService.atualizarAlunoPorId(id, dadosAtualizados);

        verify(alunoRepository).saveAndFlush(dadosAtualizados);
    }
}
