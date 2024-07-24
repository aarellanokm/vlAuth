package com.knowmadmood.vlauth.service;

import com.knowmadmood.vlauth.config.VLAuthRequestConfig;
import com.knowmadmood.vlauth.model.VLAuthResponse;
import com.knowmadmood.vlauth.utils.VLAuthUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;


@Service
public class VLAuthService {

	private final String DATE_FORMAT = "MMMM d',' yyyy";
	@Autowired
	private VLAuthRequestConfig requestConfig;
	@Autowired
	private VLAuthUtils utils;

	//Crea la response y setea los datos
	public VLAuthResponse getToken(){

		VLAuthResponse response = new VLAuthResponse();

		response.setDate(utils.dateFormat(DATE_FORMAT, LocalDate.now()));

		response.setToken(retrieveToken());

		return response;

	}

	//Peticiona el token al docker, en caso de error devuelve token por defecto
	public String retrieveToken() {

		String url = requestConfig.getRequestUrl();
		String requestJson = requestConfig.getRequestData();
		String contentType = requestConfig.getRequestContentType();

		HttpHeaders headers = new HttpHeaders();
		headers.set(HttpHeaders.CONTENT_TYPE, contentType);

		HttpEntity<String> request = new HttpEntity<>(requestJson, headers);

		RestTemplate restTemplate = new RestTemplate();

		try{

			ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.POST, request, String.class);
			return response.getBody();

		}catch(Exception e){

			System.err.println("Error getting token: "+e.getMessage());
			return "Default Token";

		}

	}



}
