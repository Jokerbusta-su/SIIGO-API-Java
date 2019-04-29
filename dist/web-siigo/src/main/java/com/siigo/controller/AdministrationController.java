package com.siigo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.siigo.constants.AdministrationConstants;
import com.siigo.model.Developer;
import com.siigo.model.Product;

@Controller
public class AdministrationController {

	private static final Logger LOGGER = LoggerFactory.getLogger(AdministrationController.class);
	private static final String TOKEN_BASIC = "Basic U2lpZ29XZWI6QUJBMDhCNkEtQjU2Qy00MEE1LTkwQ0YtN0MxRTU0ODkxQjYx";
	private static final String BODY_TOKEN = "grant_type=password&username=Empresadeperas\\admin@peras.com&password=siigo2019&scope=WebApi offline_access";
	private static final String SUBSCRIPTION_KEY = "a21a8a8413134995b658925143dc87e7";
	
	@Autowired
	private RestTemplate restService;

	@GetMapping(AdministrationConstants.HOME_MAPPING)
	public String home(Model model) {
		try {
			Developer[] developers = getDevelopers();
			model.addAttribute("developers", developers);
			Product[] products = getProducts();
			model.addAttribute("products", products);
		} catch (Exception e) {
			LOGGER.error("ERROR: ", e);
		}
		return AdministrationConstants.HOME_JSP;
	}

	@PostMapping(AdministrationConstants.CREATE_PRODUCT)
	public String createProduct(Product product, Model model) {
		try {
			product = this.createProduct(product);
		} catch (Exception e) {
			LOGGER.error("ERROR: ", e);
		}
		return "redirect:" + AdministrationConstants.HOME_MAPPING;
	}

	@GetMapping(AdministrationConstants.DELETE_PRODUCT + "/{idProduct}")
	public String deleteProduct(@PathVariable Long idProduct, Model model) {
		try {
			this.deleteProduct(idProduct);
		} catch (Exception e) {
			LOGGER.error("ERROR: ", e);
		}
		return "redirect:" + AdministrationConstants.HOME_MAPPING;
	}

	public String getToken() {
		String token = null;
		try {
			HttpHeaders headers = new HttpHeaders();
			headers.set("Authorization", TOKEN_BASIC);
			headers.set("Accept", "application/json");
			headers.set("Content-Type", "application/x-www-form-urlencoded");
			String body = BODY_TOKEN;
			HttpEntity<String> requestEntity = new HttpEntity<>(body, headers);
			ResponseEntity<String> response = restService.exchange(AdministrationConstants.REST_TOKEN, HttpMethod.POST,
					requestEntity, String.class);
			token = response.getBody();
		} catch (Exception e) {
			LOGGER.error("ERROR: ", e);
		}
		return token;
	}

	public Developer[] getDevelopers() {
		Developer[] listDeveloper = null;
		try {
			HttpHeaders headers = new HttpHeaders();
			headers.set("Authorization", getToken());
			headers.set("Ocp-Apim-Subscription-Key", SUBSCRIPTION_KEY);
			HttpEntity<MultiValueMap<String, Object>> requestEntity = new HttpEntity<>(headers);
			ResponseEntity<Developer[]> response = restService.exchange(AdministrationConstants.REST_GET_DEVELOPERS,
					HttpMethod.GET, requestEntity, Developer[].class);
			listDeveloper = response.getBody();
		} catch (Exception e) {
			LOGGER.error("ERROR: ", e);
		}
		return listDeveloper;
	}

	public Product[] getProducts() {
		Product[] listProducts = null;
		try {
			HttpHeaders headers = new HttpHeaders();
			headers.set("Authorization", getToken());
			headers.set("Ocp-Apim-Subscription-Key", SUBSCRIPTION_KEY);
			HttpEntity<MultiValueMap<String, Object>> requestEntity = new HttpEntity<>(headers);
			ResponseEntity<Product[]> response = restService.exchange(AdministrationConstants.REST_GET_PRODUCTS,
					HttpMethod.GET, requestEntity, Product[].class);
			listProducts = response.getBody();
		} catch (Exception e) {
			LOGGER.error("ERROR: ", e);
		}
		return listProducts;
	}

	public Product createProduct(Product product) {
		try {
			HttpHeaders headers = new HttpHeaders();
			headers.set("Content-Type", "application/json");
			headers.set("Authorization", getToken());
			headers.set("Ocp-Apim-Subscription-Key", SUBSCRIPTION_KEY);
			ObjectMapper mapper = new ObjectMapper();
			String strJSON = mapper.writeValueAsString(product);
			HttpEntity<String> requestEntity = new HttpEntity<>(strJSON, headers);
			ResponseEntity<Product> response = restService.exchange(AdministrationConstants.REST_CREATE_PRODUCT,
					HttpMethod.POST, requestEntity, Product.class);
			product = response.getBody();
		} catch (Exception e) {
			LOGGER.error("ERROR: ", e);
		}
		return product;
	}

	public boolean deleteProduct(Long product) {
		boolean status = false;
		try {
			HttpHeaders headers = new HttpHeaders();
			headers.set("Authorization", getToken());
			headers.set("Ocp-Apim-Subscription-Key", SUBSCRIPTION_KEY);
			HttpEntity<String> requestEntity = new HttpEntity<>(headers);
			ResponseEntity response = restService.exchange(
					AdministrationConstants.REST_DELETE_PRODUCT + product + "?namespace=v1", HttpMethod.DELETE,
					requestEntity, Object.class);
			if (response.getStatusCode() == HttpStatus.OK)
				status = true;
			else
				status = false;
		} catch (Exception e) {
			LOGGER.error("ERROR: ", e);
		}
		return status;
	}

}
