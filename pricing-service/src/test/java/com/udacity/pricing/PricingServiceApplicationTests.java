package com.udacity.pricing;

import com.udacity.pricing.api.PricingController;

import com.udacity.pricing.service.PricingService;
import org.junit.jupiter.api.Test;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.net.URI;

@WebMvcTest(value= PricingController.class)
public class PricingServiceApplicationTests {

	@Autowired
	private MockMvc mvc;

	@MockBean
	PricingService pricingService;

	@Test
	public void contextLoads() {
	}

	@Test
	public void getVehiclePrice() throws Exception {
		mvc.perform(get(new URI("/services/price?vehicleId=1"))
						.contentType(MediaType.APPLICATION_JSON_UTF8)
						.accept(MediaType.APPLICATION_JSON_UTF8))
						.andExpect(status().isOk());
	}
}