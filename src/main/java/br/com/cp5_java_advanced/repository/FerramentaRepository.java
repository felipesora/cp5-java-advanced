package br.com.cp5_java_advanced.repository;

import br.com.cp5_java_advanced.model.Ferramenta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FerramentaRepository extends JpaRepository<Ferramenta, Long> {
    @Query("""
    SELECT f FROM Ferramenta f
    WHERE (:nome IS NULL OR f.nome ILIKE :nome)
      AND (:categoria IS NULL OR f.categoria ILIKE :categoria)
    ORDER BY f.id ASC
    """)
    List<Ferramenta> findByFiltros(
            @Param("nome") String nome,
            @Param("categoria") String categoria
    );

    long count();
}
