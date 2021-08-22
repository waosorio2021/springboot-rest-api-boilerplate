package org.boilerplate.microservice.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class AccountDTO {
	
	private Integer id;
	@NonNull
	private String name;

}
