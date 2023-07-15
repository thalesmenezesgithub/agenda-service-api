package pdev.com.agenda.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pdev.com.agenda.mapper.PacienteMapper;
import pdev.com.agenda.model.Paciente;
import pdev.com.agenda.request.PacienteRequest;
import pdev.com.agenda.response.PacienteResponse;
import pdev.com.agenda.service.PacienteService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/paciente")
public class PacienteController
{

    @Autowired
    private PacienteService service;

    @PostMapping
    public ResponseEntity<PacienteResponse> salvar(@RequestBody PacienteRequest request)
    {
        //Faz o mapeamento com a classe
        Paciente paciente = PacienteMapper.toPaciente(request);

        Paciente salvaPaciente = service.salvar(paciente);

        PacienteResponse response = PacienteMapper.toPacienteResponse(salvaPaciente);

        return  ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping
    public ResponseEntity<List<Paciente>> buscarTodos()
    {
        List<Paciente> pacientes = service.listarTodos();

        return ResponseEntity.status(HttpStatus.OK).body(pacientes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Paciente> buscarPorId(@PathVariable Long id)
    {
        Optional<Paciente> optionalPaciente =service.buscarPorId(id);

        if(optionalPaciente.isEmpty())
        {
            return ResponseEntity.notFound().build();
        }

        return  ResponseEntity.status(HttpStatus.OK).body(optionalPaciente.get());
    }

//    @PutMapping
//    public ResponseEntity<Paciente> alterar(@ResponseBody Paciente paciente)
//    {
//        Paciente editar = service.salvar(paciente);
//
//        return  ResponseEntity.status(HttpStatus.OK).body(editar);
//    }

//    @PutMapping("/{id}")
//    public ResponseEntity<PacienteResponse> alterar(@PathVariable Long id, @RequestBody PacienteRequest request) {
//        Paciente paciente = mapper.toPaciente(request);
//        Paciente pacienteSalvo = service.alterar(id, paciente);
//        PacienteResponse pacienteResponse = mapper.toPacienteResponse(pacienteSalvo);
//        return ResponseEntity.status(HttpStatus.OK).body(pacienteResponse);
//    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id)
    {
        service.deletar(id);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
