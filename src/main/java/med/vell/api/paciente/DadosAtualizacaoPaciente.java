package med.vell.api.paciente;

import jakarta.validation.Valid;
import med.vell.api.endereco.DadosEndereco;

public record DadosAtualizacaoPaciente(
        Long id,
        String nome,
        String telefone,
        @Valid DadosEndereco endereco
) {
}