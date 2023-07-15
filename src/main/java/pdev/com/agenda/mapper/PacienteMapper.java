package pdev.com.agenda.mapper;

import pdev.com.agenda.model.Paciente;
import pdev.com.agenda.request.PacienteRequest;
import pdev.com.agenda.response.PacienteResponse;

public class PacienteMapper
{
    public static Paciente toPaciente(PacienteRequest request)
    {
        Paciente paciente = new Paciente();
        paciente.setNome(request.getNome());
        paciente.setSobrenome(request.getSobrenome());
        paciente.setEmail(request.getEmail());
        paciente.setCpf(request.getCpf());

        return paciente;
    }

    public static PacienteResponse toPacienteResponse(Paciente paciente)
    {
        PacienteResponse response = new PacienteResponse();
        response.setId(paciente.getId());
        response.setNome(paciente.getNome());
        response.setSobrenome(paciente.getSobrenome());
        response.setEmail(paciente.getEmail());
        response.setCpf(paciente.getCpf());

        return response;
    }
}
