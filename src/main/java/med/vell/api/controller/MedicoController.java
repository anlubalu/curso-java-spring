package med.vell.api.controller;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import med.vell.api.medico.DadosCadastroMedico;
import med.vell.api.medico.DadosListagemMedico;
import med.vell.api.medico.Medico;
import med.vell.api.medico.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("medicos")
public class MedicoController {

    @Autowired
    private MedicoRepository repository;

    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody @Valid DadosCadastroMedico dados) {

        repository.save(new Medico(dados));

    }

    @GetMapping
    public List<DadosListagemMedico> listar(){
        return repository.findAll().stream().map(DadosListagemMedico::new).toList();
    }

}
