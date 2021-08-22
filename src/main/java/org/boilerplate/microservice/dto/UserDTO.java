package org.boilerplate.microservice.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class UserDTO {

	@NonNull
	private Integer id;

	@NonNull
	private String name;

	private String lastName;

	private int edad;

}
