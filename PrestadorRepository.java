package br.com.freeladaquebrada.repository;

import br.com.freeladaquebrada.model.Prestador;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PrestadorRepository extends JpaRepository<Prestador, Long> {}
