package edu.ifes.ci.si.les.ats.controllers;

import java.util.Collection;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import edu.ifes.ci.si.les.ats.model.Marca;
import edu.ifes.ci.si.les.ats.model.Modelo;
import edu.ifes.ci.si.les.ats.services.ModeloService;
import edu.ifes.ci.si.les.ats.services.exceptions.ConstraintException;

@RestController
@RequestMapping(value = "/api/v1/modelos")
public class ModeloController {

	@Autowired
	private ModeloService service;

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<Collection<Modelo>> findAll() {
		Collection<Modelo> collection = service.findAll();
		return ResponseEntity.ok().body(collection);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Modelo> find(@PathVariable Integer id) {
		Modelo obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Modelo> insert(@Valid @RequestBody Modelo obj, BindingResult br) {
		if (br.hasErrors())
			throw new ConstraintException(br.getAllErrors().get(0).getDefaultMessage());
		obj = service.insert(obj);
		return ResponseEntity.ok().body(obj);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PATCH)
	public ResponseEntity<Modelo> update(@Valid @RequestBody Modelo obj, BindingResult br) {
		if (br.hasErrors())
			throw new ConstraintException(br.getAllErrors().get(0).getDefaultMessage());
		obj = service.update(obj);
		return ResponseEntity.ok().body(obj);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
    @RequestMapping(value="/findByMarca/{idMarca}", method=RequestMethod.GET)
	public ResponseEntity<Collection<Modelo>> findByMarca(@PathVariable Integer idMarca) {
		Marca obj = new Marca();
		obj.setId(idMarca);
		Collection<Modelo> collection = service.findByMarca(obj);
		return ResponseEntity.ok().body(collection);
	}

}
