package com.restser.utility;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;

import com.restser.exception.HttpBadRequestException;
import com.restser.exception.HttpNotFoundException;
import com.restser.exception.HttpUnauthorizedException;

public class CreateResponse {
	public ResponseEntity<?> doPostForEntity(String url, Object request, Class<?> responseType) {

        ResponseEntity<?> responseEntity = null;
        try {
            responseEntity = new RestTemplate().postForEntity(url, request, responseType);
        } catch (HttpStatusCodeException e) {
            if (e.getStatusCode() == HttpStatus.BAD_REQUEST) {
                throw new HttpBadRequestException(e.getResponseBodyAsString());
            } else if (e.getStatusCode() == HttpStatus.NOT_FOUND) {
                throw new HttpNotFoundException(e.getResponseBodyAsString());
            }else if (e.getStatusCode() == HttpStatus.UNAUTHORIZED) {
                throw new HttpUnauthorizedException(e.getResponseBodyAsString());
            } else {
                throw new RuntimeException();
            }
        }

        return responseEntity;

    }
}
