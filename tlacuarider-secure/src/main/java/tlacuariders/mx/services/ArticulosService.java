package tlacuariders.mx.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tlacuariders.mx.models.ArticulosModel;
import tlacuariders.mx.repositories.ArticulosRepository;

@Service
public class ArticulosService {
	@Autowired
	ArticulosRepository articulosRepository;
	
	public ArrayList<ArticulosModel> getArticulos() {
		return (ArrayList<ArticulosModel>) articulosRepository.findAll();
	}
	
	public ArticulosModel saveArticulo(ArticulosModel articulo) {
		return articulosRepository.save(articulo);
	}
	
	public boolean deleteArticulo(Integer id) {
		try {
			articulosRepository.deleteById(id);
			return true;
		}catch(Exception error) {
			return false;
		}
	}
	
	public ArrayList<ArticulosModel> getArticuloByNombre(String name){
		return articulosRepository.findByNombre(name);
	}
	
	
	public Optional<ArticulosModel> getArticuloById(int id) {
		return articulosRepository.findById(id);
	}
}
