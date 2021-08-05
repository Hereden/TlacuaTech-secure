package tlacuariders.mx.controllers;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import tlacuariders.mx.models.CodigoPostalModel;
import tlacuariders.mx.services.CodigoPostalService;

@RestController
@RequestMapping("/codigo_postal")
public class CodigoPostalController {
	@Autowired 
	CodigoPostalService cpService;
	
	@PostMapping
	public CodigoPostalModel saveCodigoPostal(@RequestBody CodigoPostalModel codigo_postal) {
		return cpService.saveCodigoPostal(codigo_postal);
	}
	
	@GetMapping(path="/{id}")
	public Optional<CodigoPostalModel> getCodigoPostalById(@PathVariable("id") Integer id){
		return cpService.getCodigoPostalById(id);
	}
	
	@GetMapping
	public ArrayList<CodigoPostalModel> getCodigoPostalAll(){
		return cpService.getCodigoPostalAll();
	}
	
	
	
}
