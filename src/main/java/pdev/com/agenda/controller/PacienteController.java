package pdev.com.agenda.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pdev.com.agenda.model.Paciente;
import pdev.com.agenda.service.PacienteService;

import java.util.List;

@RestController
@RequestMapping("/paciente")
public class PacienteController
{

    @Autowired
    private PacienteService service;

    @PostMapping
    public ResponseEntity<Paciente> salvar(@RequestBody Paciente paciente)
    {
        Paciente pacienteSalvo = service.salvar(paciente);

        return  ResponseEntity.status(HttpStatus.CREATED).body(pacienteSalvo);
    }

    @GetMapping
    public ResponseEntity<List<Paciente>> buscarTodos()
    {
        List<Paciente> pacientes = service.listarTodos();

        return ResponseEntity.status(HttpStatus.OK).body(pacientes);
    }
}
