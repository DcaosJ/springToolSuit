package dam.thymleft.warhammer40k.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import dam.thymleft.warhammer40k.model.Producto;
import dam.thymleft.warhammer40k.model.Categoria;
import dam.thymleft.warhammer40k.service.CategoryService;
import dam.thymleft.warhammer40k.service.ProductService;



@Controller
@RequestMapping("/admin/producto")
public class ProductController {

	@Autowired
	private ProductService productService;
	
	@Autowired
	private CategoryService categoryService;

	@GetMapping("/")
	public String index(Model model) {
		model.addAttribute("productos", productService.findAll());
		return "admin/list-producto";
	}
	
	@GetMapping("/nuevo")
	public String nuevoProducto(Model model) {
		Producto producto = new Producto();
		List<Categoria> categorias = this.categoryService.findAll();
		
		model.addAttribute("producto" ,producto);
		
		model.addAttribute("categorias" ,categorias);
		
		return "admin/form-producto";
		
		
	}
	
	@PostMapping("/nuevo/submit")
	public String submitNuevoProducto(Producto producto, Model model) {
		productService.save(producto);
		return "redirect:admin/producto";
	}
}