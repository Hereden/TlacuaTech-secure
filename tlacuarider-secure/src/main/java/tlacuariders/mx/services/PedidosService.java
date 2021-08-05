package tlacuariders.mx.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tlacuariders.mx.models.PedidosModel;
import tlacuariders.mx.repositories.PedidosRepository;

@Service
public class PedidosService {
	@Autowired
	PedidosRepository pedidosRepository;
	
	public ArrayList<PedidosModel> getPedidos(){
		return (ArrayList<PedidosModel>) pedidosRepository.findAll();
	}
	
	public PedidosModel savePedidos(PedidosModel pedido) {
		return pedidosRepository.save(pedido);
	}
	
	public boolean deletePedidos(Integer id) {
		try {
			pedidosRepository.deleteById(id);
			return true;
		}catch(Exception error) {
			return false;
		}
	}
	
	public Optional<PedidosModel> getPedidoById(int id) {
		return pedidosRepository.findById(id);
	}
}
