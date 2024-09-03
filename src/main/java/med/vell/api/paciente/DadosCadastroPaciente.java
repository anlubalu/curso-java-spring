package med.vell.api.paciente;

import med.vell.api.endereco.DadosEndereco;

public record DadosCadastroPaciente(
        String nome,
        String email,
        String telefone,
        String cpf,
        DadosEndereco endereco) {
}
