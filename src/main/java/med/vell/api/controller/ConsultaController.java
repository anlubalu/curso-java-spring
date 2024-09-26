package med.vell.api.controller;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import med.vell.api.domain.consulta.ConsultaRepository;
import med.vell.api.domain.consulta.DadosCancelamentoConsulta;
import med.vell.api.domain.consulta.DadosDetalhamentoConsulta;
import med.vell.api.domain.consulta.DadosAgedamentoConsulta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("consultas")
public class ConsultaController {

    @Autowired
    private ConsultaRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity agendar(@RequestBody @Valid DadosAgedamentoConsulta dados){
        System.out.println(dados);
        return ResponseEntity.ok(new DadosDetalhamentoConsulta(null, null, null, null));
    }

    @DeleteMapping
    @Transactional
    public ResponseEntity cancelar(@RequestBody @Valid DadosCancelamentoConsulta dados) {
        var agenda = repository.getReferenceById(dados.idConsulta());
        agenda.cancelar(dados.motivo());
        return ResponseEntity.noContent().build();
    }

}
