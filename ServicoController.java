package br.com.freeladaquebrada.controller;

import br.com.freeladaquebrada.model.Servico;
import br.com.freeladaquebrada.repository.ServicoRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/servicos")
public class ServicoController {
    private final ServicoRepository repo;
    public ServicoController(ServicoRepository repo) { this.repo = repo; }

    @GetMapping public List<Servico> listar() { return repo.findAll(); }

    @GetMapping("/{id}") public ResponseEntity<Servico> buscar(@PathVariable Long id) {
        return repo.findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping public Servico criar(@RequestBody Servico item) { item.setId(null); return repo.save(item); }

    @PutMapping("/{id}") public ResponseEntity<Servico> atualizar(@PathVariable Long id, @RequestBody Servico item) {
        if (!repo.existsById(id)) return ResponseEntity.notFound().build();
        item.setId(id); return ResponseEntity.ok(repo.save(item));
    }

    @DeleteMapping("/{id}") public ResponseEntity<Void> remover(@PathVariable Long id) {
        if (!repo.existsById(id)) return ResponseEntity.notFound().build();
        repo.deleteById(id); return ResponseEntity.noContent().build();
    }
}
