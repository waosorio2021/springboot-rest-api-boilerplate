package co.edu.escuela_it.microservicio.controller;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import co.edu.escuela_it.microservicio.dto.UserDTO;

@RestController
@RequestMapping("/users")
public class UserControllerRest {

	@GetMapping("/{id}")
	public ResponseEntity<UserDTO> getUserById(@PathVariable Integer id) {

		UserDTO userDTO = new UserDTO(1, "Rafael");
		userDTO.setLastName("Benedetelli");
		userDTO.setEdad(38);

		return ResponseEntity.ok(userDTO);
	}

	@GetMapping
	public ResponseEntity<List<UserDTO>> getListAllUsers(@RequestParam(required = false) String name,
			                             @RequestParam(required = false) String lastName,
			                             @RequestParam(required = false) String age) {

		// List<UserDTO> list = List.of(new UserDTO(1, "Rafael"), new UserDTO(2,
		// "Miguek"), new UserDTO(3, "Wilson"));
		List<UserDTO> list = new ArrayList<>();
		list.add(new UserDTO(1, "Rafael"));
		list.add(new UserDTO(2, "Wilson"));
		list.add(new UserDTO(3, "Andrés"));
		
		if(name != null)
	        list = list.stream().filter(u ->  u.getName().contains(name)).collect(Collectors.toList());

		return ResponseEntity.ok(list);
	}
	//para consultar como consteuir queries más complejos, consultar Rest Query Filter y Spring specification 

	/*
	 * @GetMapping("/users") public List<UserDTO> getListAllUsers() {
	 * 
	 * // List<UserDTO> list = List.of(new UserDTO(1, "Rafael"), new UserDTO(2, //
	 * "Miguek"), new UserDTO(3, "Wilson")); List<UserDTO> list = new ArrayList<>();
	 * list.add(new UserDTO(1, "Rafael")); list.add(new UserDTO(2, "Wilson"));
	 * list.add(new UserDTO(3, "Andrés"));
	 * 
	 * return list; }
	 */

	@PostMapping
	public ResponseEntity<String> createUser(@RequestBody UserDTO userDTO) {
        
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(userDTO.getId()).toUri();
				
		return ResponseEntity.ok(location + userDTO.getId().toString());		
	}

	@PutMapping
	public ResponseEntity<UserDTO> updateUser(@RequestBody UserDTO userDTO) {

		return ResponseEntity.ok(userDTO);
	}

	@PatchMapping("/{id}")
	public ResponseEntity<UserDTO> patchUser(@RequestBody Map<String, Object> attributes, @PathVariable Integer id) {

		UserDTO userDTO = new UserDTO();

		// actualizar el recurso...
		userDTO.setId(1);
		userDTO.setName("Rafael");
		userDTO.setLastName("Benedetelli");
		userDTO.setEdad((int) attributes.get("edad"));

		return ResponseEntity.ok(userDTO);
	}

}
