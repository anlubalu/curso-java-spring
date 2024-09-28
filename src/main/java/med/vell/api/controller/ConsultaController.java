package med.vell.api.controller;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import med.vell.api.domain.consulta.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("consultas")
public class ConsultaController {

    @Autowired
    private AgendaDeConsultas agenda;

    @Autowired
    private ConsultaRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity agendar(@RequestBody @Valid DadosAgedamentoConsulta dados){
      var dto = agenda.agendar(dados);
        return ResponseEntity.ok(dto);
    }

    @DeleteMapping
    @Transactional
    public ResponseEntity cancelar(@RequestBody @Valid DadosCancelamentoConsulta dados) {
        var agenda = repository.getReferenceById(dados.idConsulta());
        agenda.cancelar(dados.motivo());
        return ResponseEntity.noContent().build();
    }

}
