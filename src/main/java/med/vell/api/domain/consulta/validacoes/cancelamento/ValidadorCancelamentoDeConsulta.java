package med.vell.api.domain.consulta.validacoes.cancelamento;

import med.vell.api.domain.consulta.DadosCancelamentoConsulta;

public interface ValidadorCancelamentoDeConsulta {

    void validar(DadosCancelamentoConsulta dados);

}
