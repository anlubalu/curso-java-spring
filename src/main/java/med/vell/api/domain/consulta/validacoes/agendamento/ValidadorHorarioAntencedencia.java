package med.vell.api.domain.consulta.validacoes.agendamento;

import med.vell.api.domain.ValidacaoException;
import med.vell.api.domain.consulta.DadosAgedamentoConsulta;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.LocalDateTime;

@Component("ValidadorHorarioAntecedenciaAgendamento")
public class ValidadorHorarioAntencedencia implements ValidadorAgendamentoDeConsulta{

    public void validar(DadosAgedamentoConsulta dados){
        var dataConsulta = dados.data();
        var agora = LocalDateTime.now();
        var diferencaEmMinutos = Duration.between(agora, dataConsulta).toMinutes();

        if (diferencaEmMinutos < 30) {
            throw new ValidacaoException("Consulta deve ser agendada com antencedência mínima de 10 minutos");
        }
    }



}
