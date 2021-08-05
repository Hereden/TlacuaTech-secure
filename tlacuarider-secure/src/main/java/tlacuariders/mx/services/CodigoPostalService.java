package tlacuariders.mx.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tlacuariders.mx.models.CodigoPostalModel;
import tlacuariders.mx.repositories.CodigoPostalRepository;

@Service
public class CodigoPostalService {
	@Autowired
	CodigoPostalRepository cpRepository;
	
	public CodigoPostalModel saveCodigoPostal(CodigoPostalModel codigo_postal) {
		return cpRepository.save(codigo_postal);	
	}
	
	public Optional<CodigoPostalModel> getCodigoPostalById(int id) {
		return cpRepository.findById(id);
	}
	
	public ArrayList<CodigoPostalModel> getCodigoPostalAll(){
		return (ArrayList<CodigoPostalModel>)cpRepository.findAll();
	}

}
