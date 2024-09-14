package med.vell.api.domain.medico;

import jakarta.validation.constraints.NotNull;
import med.vell.api.domain.endereco.DadosEndereco;

public record DadosAtualizacaoMedico(

        @NotNull
        Long id,
        String nome,
        String telefone,
        DadosEndereco endereco

) {
}
