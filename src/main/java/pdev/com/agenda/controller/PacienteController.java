package pdev.com.agenda.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pdev.com.agenda.model.Paciente;
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
    public ResponseEntity<Paciente> salvar(@RequestBody Paciente paciente)
    {
        Paciente salva = service.salvar(paciente);

        return  ResponseEntity.status(HttpStatus.CREATED).body(salva);
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

    @PutMapping
    public ResponseEntity<Paciente> alterar(@ResponseBody Paciente paciente)
    {
        Paciente editar = service.salvar(paciente);

        return  ResponseEntity.status(HttpStatus.OK).body(editar);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id)
    {
        service.deletar(id);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
