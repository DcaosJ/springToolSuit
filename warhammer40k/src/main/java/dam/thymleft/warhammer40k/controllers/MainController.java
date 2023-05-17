package dam.thymleft.warhammer40k.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import dam.thymleft.warhammer40k.model.Producto;
import dam.thymleft.warhammer40k.repositories.ProductRepository;
import dam.thymleft.warhammer40k.service.CategoryService;
import dam.thymleft.warhammer40k.service.ProductService;

@Controller
public class MainController {


	@Autowired
	private CategoryService categoryService;

	@Autowired
	private ProductService productService;

	@GetMapping("/")
	public String index(@RequestParam(name="idCategoria", required=false) Long idCategoria,Model model) {
		List<Producto> productos;
		if(idCategoria == null) {
			productos = productService.obtenerProductosAleatorios(ProductRepository.PRODUCTOS_ALEATORIOS);
		}
		else {
			productos=productService.findAllByCategoria(idCategoria);
		}
		model.addAttribute("categorias", categoryService.findAll());
		model.addAttribute("productos", productos);
		return "index";
	}
	@GetMapping("/producto/{id}")
	public String showDeatails(@PathVariable("id") Long id, Model model) {
		Producto producto = productService.findById(id);
		if(producto!=null) {
			model.addAttribute(producto);
			return "detail";
		}
		return"redirect:/";
	}
	
	@GetMapping("/buscar")
	public String buscar(Model model, @Param("palabraClave") String palabraClave) {
		List<Producto> listaProducto = productService.listAll(palabraClave);
		model.addAttribute("productos", listaProducto);
		model.addAttribute("categorias", categoryService.findAll());
		model.addAttribute("palabraClave", palabraClave);
		return "index";
	}
}

