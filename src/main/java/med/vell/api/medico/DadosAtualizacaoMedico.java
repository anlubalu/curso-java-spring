package med.vell.api.medico;

import jakarta.validation.constraints.NotNull;
import med.vell.api.endereco.DadosEndereco;

public record DadosAtualizacaoMedico(

        @NotNull
        Long id,
        String nome,
        String telefone,
        DadosEndereco endereco

) {
}
