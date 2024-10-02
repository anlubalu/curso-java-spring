package med.vell.api.domain.consulta;

import med.vell.api.domain.medico.Medico;
import med.vell.api.domain.paciente.Paciente;

import java.time.LocalDateTime;
import java.util.List;

public record DadosListagemConsulta(Long id, String nomeMedico, String nomePaciente, MotivoCancelamento motivo) {

    public DadosListagemConsulta(Consulta consulta) {
        this(consulta.getId(), consulta.getMedico().getNome(), consulta.getPaciente().getNome(), consulta.getMotivoCancelamento());
    }
}
