package org.egov.wsCalculation.repository;

import java.util.List;

import org.egov.wsCalculation.model.MeterConnectionRequest;
import org.egov.wsCalculation.model.MeterReading;
import org.egov.wsCalculation.model.MeterReadingSearchCriteria;
import org.egov.wsCalculation.producer.WSCalculationProducer;
import org.egov.wscalculation.builder.WSCalculatorQueryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Repository
public class WSCalculationDaoImpl implements WSCalculationDao {
	
	@Autowired
	WSCalculationProducer wSCalculationProducer;
	
	@Autowired
	WSCalculatorQueryBuilder queryBuilder;
	
	
	@Value("${egov.waterservice.createWaterConnection}")
	private String createMeterConnection;

	@Override
	public void saveWaterConnection(MeterConnectionRequest meterConnectionRequest) {
     wSCalculationProducer.push(createMeterConnection, meterConnectionRequest);
	}

	@Override
	public List<MeterReading> searchMeterReadings(MeterReadingSearchCriteria criteria) {
		
		return null;
	}

}