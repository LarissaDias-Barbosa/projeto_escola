package dobasicoaoavancado.escola.controller;

import dobasicoaoavancado.escola.infratructure.entitys.Aluno;
import dobasicoaoavancado.escola.service.AlunoService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/aluno")
@AllArgsConstructor
public class AlunoController {

    public final AlunoService alunoService;

    @PostMapping
    public ResponseEntity<Void> salvarAluno(@RequestBody Aluno aluno){
       alunoService.salvarAluno(aluno);
       return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<Aluno> buscarAlunoPorCpf(@RequestParam String cpf){
       return ResponseEntity.ok(alunoService.buscarAlunoPorCpf(cpf));
    }

    @DeleteMapping
    public ResponseEntity<Void> deletarAlunoPorCpf(@RequestParam String cpf){
        alunoService.deletarAlunoPorCpf(cpf);
          return ResponseEntity.ok().build();
    }

    @PutMapping
    public ResponseEntity<Void> atualizarAlunoPorId(@RequestParam Integer id,
                                                    @RequestBody Aluno aluno){
    alunoService.atualizarAlunoPorId(id, aluno);
        return ResponseEntity.ok().build();
    }


}
