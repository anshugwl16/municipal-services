package org.egov.waterConnection.model;

import javax.validation.constraints.NotNull;



import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Unit
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Unit   {
	
        @JsonProperty("id")
        private String id;
        
        @JsonProperty("assessmentId")
        private String assessmentId;

        @JsonProperty("tenantId")
        @NotNull
        private String tenantId;

        @JsonProperty("floorNo")
        private String floorNo;

        @JsonProperty("unitArea")
        @NotNull
        private Double unitArea;

        @JsonProperty("usageCategory")
        @NotNull
        private String usageCategory;

        @JsonProperty("occupancyType")
        @NotNull
        private OccupancyType occupancyType;

        @JsonProperty("occupancyDate")
        @NotNull
        private Long occupancyDate;

        @JsonProperty("constructionType")
        @NotNull
        private String constructionType;
        
        @JsonProperty("active")
        private Boolean active;

        @JsonProperty("arv")
        private Double arv;
        
        @JsonProperty("auditDetails")
        private AuditDetails auditDetails;


}
