package dam.thymleft.warhammer40k.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import dam.thymleft.warhammer40k.model.Categoria;



public interface CategoryRepository extends JpaRepository<Categoria, Long> {

}
