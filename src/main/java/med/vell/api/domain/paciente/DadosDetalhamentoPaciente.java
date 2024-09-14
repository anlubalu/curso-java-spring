package med.vell.api.domain.paciente;

import med.vell.api.domain.endereco.Endereco;

// O Record aplica os getters e setters para a classe. Podendo se fosse o caso aplicar as anotações para cada campo para validações.
public record DadosDetalhamentoPaciente(String nome, String email, String telefone, String cpf, Endereco endereco) {

    // Um construtor que recebe a entidade paciente e recebe somente os getters
    public DadosDetalhamentoPaciente(Paciente paciente) {
        this(paciente.getNome(), paciente.getEmail(), paciente.getTelefone(), paciente.getCpf(), paciente.getEndereco());
    }

}
