package dam.thymleft.warhammer40k.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import dam.thymleft.warhammer40k.model.Categoria;
import dam.thymleft.warhammer40k.model.Producto;


public interface ProductRepository extends JpaRepository<Producto, Long> {
	public final int PRODUCTOS_ALEATORIOS=8;
	
	public List<Producto> findByCategoria(Categoria categoria);
	
	@Query("select p.id from Producto p")
	public List<Long> obtenerIds();
	
	@Query("select p from Producto p where p.categoria.id = ?1")
	public List<Producto> findByCategoriaId(Long categoriaId);
	
	@Query("select count(p) from Producto p where p.categoria = ?1")
	public int findNumProductosByCategoria(Categoria categoria);
		
	
	@Query("select p from Producto p where p.nombre like %?1%")
	public List<Producto> findAll(String nombreProducto);
	
	@Query("select p from Producto p where p.precio <= ?1")
	public List<Producto> findAll(float precio);

	
}
