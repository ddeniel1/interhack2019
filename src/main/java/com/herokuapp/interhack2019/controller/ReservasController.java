package com.herokuapp.interhack2019.controller;

import com.herokuapp.interhack2019.controller.dto.AgendamentoDto;
import com.herokuapp.interhack2019.controller.dto.EspacoDto;
import com.herokuapp.interhack2019.controller.dto.ModalidadeDto;
import com.herokuapp.interhack2019.modelo.Espaco;
import com.herokuapp.interhack2019.modelo.Modalidade;
import com.herokuapp.interhack2019.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/reservas")
public class ReservasController {

	@Autowired
	private AgendamentoRepository agendamentoRepository;
	@Autowired
	private EspacoRepository espacoRepository;
	@Autowired
	private EMRepository emRepository;
	@Autowired
	private ModalidadeRepository modalidadeRepository;

	@GetMapping
	public List<ModalidadeDto> listarModalidades() {
			List<Modalidade> modalidades = modalidadeRepository.findAll();
			return ModalidadeDto.converter(modalidades);
	}

	@GetMapping("/listar/{id}")
	@Transactional
	public List<EspacoDto> listarEspacos(@PathVariable Integer id) {
		System.out.println(id);
		return EspacoDto.converter(emRepository.findByEspacoModalidadeKey_IdM_Id(id).stream().map(Espaco::new).collect(Collectors.toList()));
	}
	@GetMapping("/listarHorarios/{id}")
	@Transactional
	public List<AgendamentoDto> listarHorarios(@PathVariable Integer id, LocalDateTime data) {
		System.out.println(id);
		return AgendamentoDto.converter(agendamentoRepository.findByAgendamentoKey_IdEAndReserva(id,data));
	}

//
//
//
//	@DeleteMapping("/{id}")
//	@Transactional
//	public ResponseEntity<?> remover(@PathVariable Long id) {
//		Optional<ProductManagement> optional = productManagementRepository.findById(id);
//		if (optional.isPresent()) {
//			estoqueRepository.save(EstoqueLegacy.converter( productManagementRepository.findById(id).get()));
//			productManagementRepository.deleteById(id);
//			return ResponseEntity.ok().build();
//		}
//
//		return ResponseEntity.notFound().build();
//	}

}







