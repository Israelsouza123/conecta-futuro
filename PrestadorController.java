package br.com.freeladaquebrada.controller;

import br.com.freeladaquebrada.model.Prestador;
import br.com.freeladaquebrada.repository.PrestadorRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/prestadores")
public class PrestadorController {
    private final PrestadorRepository repo;
    public PrestadorController(PrestadorRepository repo) { this.repo = repo; }

    @GetMapping public List<Prestador> listar() { return repo.findAll(); }

    @GetMapping("/{id}") public ResponseEntity<Prestador> buscar(@PathVariable Long id) {
        return repo.findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping public Prestador criar(@RequestBody Prestador item) { item.setId(null); return repo.save(item); }

    @PutMapping("/{id}") public ResponseEntity<Prestador> atualizar(@PathVariable Long id, @RequestBody Prestador item) {
        if (!repo.existsById(id)) return ResponseEntity.notFound().build();
        item.setId(id); return ResponseEntity.ok(repo.save(item));
    }

    @DeleteMapping("/{id}") public ResponseEntity<Void> remover(@PathVariable Long id) {
        if (!repo.existsById(id)) return ResponseEntity.notFound().build();
        repo.deleteById(id); return ResponseEntity.noContent().build();
    }
}
