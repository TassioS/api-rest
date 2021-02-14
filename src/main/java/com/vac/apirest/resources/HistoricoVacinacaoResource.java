package com.vac.apirest.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vac.apirest.models.HistoricoVacinacao;
import com.vac.apirest.models.Usuario;
import com.vac.apirest.repository.HistoricoVacinaRepository;
import com.vac.apirest.repository.UsuarioRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/api")
@Api(value = "API Rest para cadastro de vacinações.")
@CrossOrigin(origins = "*")
public class HistoricoVacinacaoResource {

	@Autowired
	HistoricoVacinaRepository historicoVacinaRepository;
	
	@GetMapping("/vaccinations")
	@ApiOperation(value = "Lista todos os registros de vacinações cadastrados.")
	public List<HistoricoVacinacao> listVaccinations(){
		return historicoVacinaRepository.findAll();
	}
	
	@PostMapping("/vaccine-historic")
	@ApiOperation(value = "Método para registrar uma vacinação.")
	public ResponseEntity<HttpStatus> addVaccineHistoric(@RequestBody HistoricoVacinacao historicVaccine) {
		try {
			historicoVacinaRepository.save(historicVaccine);
			return new ResponseEntity<HttpStatus>(HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<HttpStatus>(HttpStatus.BAD_REQUEST);
		}
	}
}