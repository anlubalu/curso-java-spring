package med.vell.api.controller;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import med.vell.api.domain.paciente.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("pacientes")
public class PacienteController {

    @Autowired
    private PacienteRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid DadosCadastroPaciente dados, UriComponentsBuilder uriBuilder) {
        var paciente = new Paciente(dados);
        repository.save(new Paciente(dados));

        // Importa o uri componente para montar uma url no cabeçalho da resposta http
        var uri = uriBuilder.path("/pacientes/{id}").buildAndExpand(paciente.getId()).toUri();
        return ResponseEntity.created(uri).body(new DadosDetalhamentoPaciente(paciente));
    }

    //@GetMapping
    //public Page<DadosListagemPaciente> listar(@PageableDefault(page = 0, size = 10, sort = {"nome"}) Pageable paginacao) {
        //return repository.findAll(paginacao).map(DadosListagemPaciente::new);
    //}

    // Esse código em Java Spring recebe uma configuração de paginação, busca pacientes ativos no banco de dados, mapeia os resultados para um objeto específico e retorna uma página desses objetos em uma resposta HTTP.
    @GetMapping
    public ResponseEntity<Page<DadosListagemPaciente>> listar(@PageableDefault(page = 0, size = 10, sort = { "nome" }) Pageable paginacao) {
        var page = repository.findAllByAtivoTrue(paginacao).map(DadosListagemPaciente::new);
        return ResponseEntity.ok(page);
    }

    @PutMapping
    @Transactional
    public ResponseEntity atualizar(@RequestBody @Valid DadosAtualizacaoPaciente dados) {
        var paciente = repository.getReferenceById(dados.id());
        paciente.atualizarInformacoes(dados);

        // Essa linha constrói e retorna uma resposta HTTP com status 200 OK, contendo um novo objeto DadosDetalhamentoPaciente criado a partir do objeto paciente.
        return ResponseEntity.ok(new DadosDetalhamentoPaciente(paciente));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity remover(@PathVariable Long id) {
        var paciente = repository.getReferenceById(id);
        paciente.inativar();

        // Essa linha constrói e retorna uma resposta HTTP com status 204 No Content, indicando que a solicitação foi bem-sucedida, mas não há conteúdo a ser retornado.
        return ResponseEntity.noContent().build();
    }

    // O response entity retorna uma resposta http adequada. Retornando um DTO para essa requisição.
    @GetMapping("/{id}")
    public ResponseEntity detalhar(@PathVariable Long id) {
        var paciente = repository.getReferenceById(id);
        return ResponseEntity.ok(new DadosDetalhamentoPaciente(paciente));
    }

}
