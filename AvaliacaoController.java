package br.com.freeladaquebrada.controller;

import br.com.freeladaquebrada.model.Avaliacao;
import br.com.freeladaquebrada.repository.AvaliacaoRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/avaliacoes")
public class AvaliacaoController {
    private final AvaliacaoRepository repo;
    public AvaliacaoController(AvaliacaoRepository repo) { this.repo = repo; }

    @GetMapping public List<Avaliacao> listar() { return repo.findAll(); }

    @GetMapping("/{id}") public ResponseEntity<Avaliacao> buscar(@PathVariable Long id) {
        return repo.findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping public Avaliacao criar(@RequestBody Avaliacao item) { item.setId(null); return repo.save(item); }

    @PutMapping("/{id}") public ResponseEntity<Avaliacao> atualizar(@PathVariable Long id, @RequestBody Avaliacao item) {
        if (!repo.existsById(id)) return ResponseEntity.notFound().build();
        item.setId(id); return ResponseEntity.ok(repo.save(item));
    }

    @DeleteMapping("/{id}") public ResponseEntity<Void> remover(@PathVariable Long id) {
        if (!repo.existsById(id)) return ResponseEntity.notFound().build();
        repo.deleteById(id); return ResponseEntity.noContent().build();
    }
}
