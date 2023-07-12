package pdev.com.agenda.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pdev.com.agenda.model.Paciente;
import pdev.com.agenda.repository.PacienteRepository;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class PacienteService {

    @Autowired
    private PacienteRepository repository;

    public Paciente salvar(Paciente paciente)
    {
        

        return repository.save(paciente)
    }

    public List<Paciente> listarTodos()
    {
        return repository.findAll();
    }

    public Optional<Paciente> buscarPorId(Long id)
    {
        return repository.findById(id).get();
    }

    public void deletar(Long id)
    {
        repository.deleteById(id);
    }
}
