package org.egov.pgr.contract;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.egov.pgr.model.AuditDetails;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Address {

	@JsonProperty("uuid")
	public String uuid;

	@JsonProperty("houseNoAndStreetName")
	@Pattern(regexp = "^[a-zA-Z0-9!@#.,/: ()]*$")
	@Size(max=160)
	public String houseNoAndStreetName;

	@NotNull
	@JsonProperty("mohalla")
	public String mohalla;
	
	@JsonProperty("locality")
	public String locality;

	@NotNull
	@JsonProperty("city")
	public String city;

	@JsonProperty("latitude")
	private Double latitude;

	@JsonProperty("longitude")
	private Double longitude;

	@JsonProperty("landmark")
	@Pattern(regexp = "^[a-zA-Z0-9!@#.,/: ()]*$")
	public String landmark;
	
	@JsonProperty("tenantId")
	public String tenantId;
	
	@JsonProperty("auditDetails")
	public AuditDetails auditDetails;

}
