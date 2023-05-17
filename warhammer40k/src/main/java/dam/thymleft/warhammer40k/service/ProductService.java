package dam.thymleft.warhammer40k.service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dam.thymleft.warhammer40k.model.Categoria;
import dam.thymleft.warhammer40k.model.Producto;
import dam.thymleft.warhammer40k.repositories.ProductRepository;


@Service
public class ProductService {
	@Autowired
	private ProductRepository repositorio;
	
	public List<Producto> findAll() {
		return repositorio.findAll();
	}
	
	public List<Producto> findAllByCategoria(Categoria categoria) {
		return repositorio.findByCategoria(categoria);
	}
	
	public List<Producto> findAllByCategoria(Long categoriaId) {
		return repositorio.findByCategoriaId(categoriaId);
	}
	
	public Producto findById(Long id) {
		return repositorio.findById(id).orElse(null);
	}
	
	public Producto save(Producto producto) {
		return repositorio.save(producto);
	}
	
	public Producto delete(Producto producto) {
		Producto result = findById(producto.getId());
		repositorio.delete(result);
		return result;
	}
	
	public int numeroProductosCategoria(Categoria categoria) {
		return repositorio.findNumProductosByCategoria(categoria);
	}
	
	

	public List<Producto> obtenerProductosAleatorios(int numero) {
		
		List<Long> listaIds = repositorio.obtenerIds();
		
		Collections.shuffle(listaIds);
		
		listaIds = listaIds.stream().limit(numero).collect(Collectors.toList());

		return repositorio.findAllById(listaIds);

	}

	public List<Producto> listAll(String palabraClave){
		float precio = -1;
		String nombreProducto="";
		try {
		
			precio = Float.parseFloat(palabraClave.toString());
		}catch(NumberFormatException e) {
			nombreProducto = palabraClave.toString();
		}
		
		if(precio>-1) {
				return repositorio.findAll(precio);
		}	
		else {
			return repositorio.findAll(nombreProducto);
		}
	}
	
}


