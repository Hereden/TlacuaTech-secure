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
import org.springframework.web.bind.annotation.RestController;

import tlacuariders.mx.models.PedidosModel;
import tlacuariders.mx.services.PedidosService;

@RestController
@RequestMapping("/pedidos")
public class PedidosController {
	@Autowired
	PedidosService pedidosService;
	
	@GetMapping
	public ArrayList<PedidosModel> getPedidos(){
		return pedidosService.getPedidos();
	}
	
	@PostMapping
	public PedidosModel savePedido(@RequestBody PedidosModel pedidos) {
		return pedidosService.savePedidos(pedidos);
	}
	
	
	@GetMapping(path="/{id}")
	public Optional<PedidosModel> getPedidoById(@PathVariable("id") Integer id){
		return pedidosService.getPedidoById(id);
	}
	
	@DeleteMapping(path="/{id}")
	public String deletePedido(@PathVariable("id") Integer id) {
		boolean ok=pedidosService.deletePedidos(id);
		if (ok) {
			return "El pedido se pudo borrar";
		}else {
			return "El pedido no existe o no se pudo borrar";
		}
	}
	
	
}
