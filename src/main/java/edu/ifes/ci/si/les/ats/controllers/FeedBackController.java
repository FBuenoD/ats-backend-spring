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

import edu.ifes.ci.si.les.ats.model.FeedBack;
import edu.ifes.ci.si.les.ats.services.FeedBackService;
import edu.ifes.ci.si.les.ats.services.exceptions.ConstraintException;

@RestController
@RequestMapping(value = "/api/v1/feedbacks")
public class FeedBackController {

	@Autowired
	private FeedBackService service;

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<Collection<FeedBack>> findAll() {
		Collection<FeedBack> collection = service.findAll();
		return ResponseEntity.ok().body(collection);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<FeedBack> find(@PathVariable Integer id) {
		FeedBack obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<FeedBack> insert(@Valid @RequestBody FeedBack obj, BindingResult br) {
		if (br.hasErrors())
			throw new ConstraintException(br.getAllErrors().get(0).getDefaultMessage());
		obj = service.insert(obj);
		return ResponseEntity.ok().body(obj);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PATCH)
	public ResponseEntity<FeedBack> update(@Valid @RequestBody FeedBack obj, BindingResult br) {
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
	
    @RequestMapping(value="/findBySatisfacao/{satisfacao}", method=RequestMethod.GET)
	public ResponseEntity<Collection<FeedBack>> findBySatisfacao(@PathVariable String satisfacao) {
		Collection<FeedBack> collection = service.findBySatisfacao(satisfacao);
		return ResponseEntity.ok().body(collection);
	}

}
 


