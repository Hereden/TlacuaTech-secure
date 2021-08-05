package tlacuariders.mx.controllers;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import tlacuariders.mx.models.ArticulosModel;
import tlacuariders.mx.services.ArticulosService;

@RestController
@RequestMapping("/articulos")
public class ArticuloController {
	@Autowired
	ArticulosService articulosService;
	
	@GetMapping
	public ArrayList<ArticulosModel> getArticulos(){
		return articulosService.getArticulos();
	}
	
	@PostMapping
	public ArticulosModel saveArticulo(@RequestBody ArticulosModel articulo) {
		return articulosService.saveArticulo(articulo);
	}
	
	
	@GetMapping(path="/{id}")
	public Optional<ArticulosModel> getArticuloById(@PathVariable("id") Integer id){
		return articulosService.getArticuloById(id);
	}
	
	@DeleteMapping(path="/{id}")
	public String deleteArticulo(@PathVariable("id") Integer id) {
		boolean ok=articulosService.deleteArticulo(id);
		if (ok) {
			return "El usuario se pudo borrar";
		}else {
			return "El usuario no existe o no se pudo borrar";
		}
	}
	
	
	@GetMapping(path= "/query")
	public ArrayList<ArticulosModel> getArticuloByNombre(@RequestParam(value="name", defaultValue="") String name){
		return articulosService.getArticuloByNombre(name);
	}
}
