package co.za.profileuiservice.web;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import co.za.profileuiservice.data.ProfileEmailDTO;
import co.za.profileuiservice.servicesimpl.ProducerServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/my-profile")
@RequiredArgsConstructor
@Slf4j
public class ProducerController {

	private final ProducerServiceImpl producerServiceImpl;

	
	@PostMapping("v1/send/message")
	public ResponseEntity<ProfileEmailDTO>sendMessage(@Validated@RequestBody ProfileEmailDTO emailDTO){
		   log.info("input message " + emailDTO);
		   emailDTO = producerServiceImpl.sendEmailMessageToQueue(emailDTO);
		   if(emailDTO != null) {
				return new ResponseEntity<ProfileEmailDTO>(emailDTO, HttpStatus.OK);

		   }
		   return null;
	}

	@PostMapping("v1/retrieve/token")
	public ResponseEntity<?>retriveToken(){

		return new ResponseEntity<>(producerServiceImpl.retrieveAccessToken(),HttpStatus.OK);
	}




}
