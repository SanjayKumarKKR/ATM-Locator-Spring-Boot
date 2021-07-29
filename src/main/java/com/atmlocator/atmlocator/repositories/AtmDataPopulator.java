package com.atmlocator.atmlocator.repositories;

import com.atmlocator.atmlocator.model.ATMLocation;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Component
public class AtmDataPopulator {
    private Logger atmDataPopulatorLogger = LoggerFactory.getLogger(AtmDataPopulator.class);

    @Autowired
    private RestTemplate restTemplate;

    public List<ATMLocation> getData() throws Exception {
        String response = restTemplate.getForObject("https://www.ing.nl/api/locator/atms/", String.class);
        atmDataPopulatorLogger.debug("GARBAGE IN RESPONSE:" + "\n\n" + response.substring(0, 5) + "\n\n");
        String toBeParsed = response.substring(6, response.length());
        atmDataPopulatorLogger.debug("TO BE PARSED RESPONSE:" + "\n\n" + toBeParsed + "\n\n");
        ObjectMapper objectMapper = new ObjectMapper();
        ATMLocation[] atmLocations = objectMapper.readValue(toBeParsed, ATMLocation[].class);
        atmDataPopulatorLogger.debug("PARSED RESPONSE:" + "\n\n" + atmLocations.toString() + "\n\n");
        return Arrays.asList(atmLocations);

    }
}
