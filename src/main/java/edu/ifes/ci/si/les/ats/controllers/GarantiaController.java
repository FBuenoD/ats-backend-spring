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

import edu.ifes.ci.si.les.ats.model.Garantia;
import edu.ifes.ci.si.les.ats.model.StatusGarantia;
import edu.ifes.ci.si.les.ats.services.GarantiaService;
import edu.ifes.ci.si.les.ats.services.exceptions.ConstraintException;

@RestController
@RequestMapping(value = "/api/v1/garantias")
public class GarantiaController {

	@Autowired
	private GarantiaService service;

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<Collection<Garantia>> findAll() {
		Collection<Garantia> collection = service.findAll();
		return ResponseEntity.ok().body(collection);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Garantia> find(@PathVariable Integer id) {
		Garantia obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Garantia> insert(@Valid @RequestBody Garantia obj, BindingResult br) {
		if (br.hasErrors())
			throw new ConstraintException(br.getAllErrors().get(0).getDefaultMessage());
		obj = service.insert(obj);
		return ResponseEntity.ok().body(obj);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PATCH)
	public ResponseEntity<Garantia> update(@Valid @RequestBody Garantia obj, BindingResult br) {
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
	
    @RequestMapping(value="/findByStatusGarantia/{idStatus}", method=RequestMethod.GET)
	public ResponseEntity<Collection<Garantia>> findByStatusGarantia(@PathVariable Integer idStatus) {
    	StatusGarantia obj = new StatusGarantia();
		obj.setId(idStatus);
		Collection<Garantia> collection = service.findByStatusGarantia(obj);
		return ResponseEntity.ok().body(collection);
	}

}
