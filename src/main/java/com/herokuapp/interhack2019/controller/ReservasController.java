package com.herokuapp.interhack2019.controller;

import com.herokuapp.interhack2019.controller.dto.*;
import com.herokuapp.interhack2019.controller.form.AgendamentoForm;
import com.herokuapp.interhack2019.modelo.*;
import com.herokuapp.interhack2019.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.net.URI;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
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
	@GetMapping("/listarHorarios/{id}e{data}")
	@Transactional
	public List<ReservasDto> listarHorarios(@PathVariable Integer id, @PathVariable String data) {
		LocalDateTime dia = LocalDateTime.parse(data+" 09:00:00", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
		List<AgendamentoDto> horarios;
		List<ReservasDto> reservasDtos = new ArrayList<>();

		horarios = AgendamentoDto.converter(agendamentoRepository.findByAgendamentoKey_IdAndReserva(id,dia));
		if (horarios.isEmpty()){
			reservasDtos.add(new ReservasDto(dia, StatusAgendamento.LIVRE));
		}
		else {
			reservasDtos.add(new ReservasDto(dia, horarios.get(0).getStatus()));
			horarios.clear();
		}
		for (int i = 10; i < 22; i++) {

			dia = LocalDateTime.parse(data+" "+i+":00:00", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
			horarios = AgendamentoDto.converter(agendamentoRepository.findByAgendamentoKey_IdAndReserva(id,dia));
			if (horarios.isEmpty()){
				reservasDtos.add(new ReservasDto(dia, StatusAgendamento.LIVRE));
			}
			else {
				reservasDtos.add(new ReservasDto(dia, horarios.get(0).getStatus()));
				horarios.clear();
			}
		}
		return reservasDtos;
	}

	@PostMapping("/adicionarAgendamento")
	public ResponseEntity<AgendamentoDto> cadastrar(@RequestBody AgendamentoForm form, UriComponentsBuilder uriBuilder) {
		Agendamento agendamento = form.converter(
							espacoRepository.findFirstById(form.getIdE()),
							modalidadeRepository.findFirstById(form.getIdM())
							);
		System.out.println(agendamento.getJustificativa());
		agendamentoRepository.save(agendamento);

		URI uri = uriBuilder.path("/agendamentos/{id}").buildAndExpand(agendamento.getAgendamentoKey().getId()).toUri();
		return ResponseEntity.created(uri).body(new AgendamentoDto(agendamento));
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







