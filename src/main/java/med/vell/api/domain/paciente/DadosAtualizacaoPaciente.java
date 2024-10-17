package med.vell.api.domain.paciente;

import jakarta.validation.Valid;
import med.vell.api.domain.endereco.DadosEndereco;

public record DadosAtualizacaoPaciente(
        Long id,
        String nome,
        String telefone,
        @Valid DadosEndereco endereco
) {
}