package co.za.profileuiservice.web;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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
	
	@PostMapping("send/message")
	public ResponseEntity<ProfileEmailDTO>sendMessage(@Validated@RequestBody ProfileEmailDTO emailDTO){
		   log.info("input message " + emailDTO);
		   emailDTO = producerServiceImpl.sendEmailMessageToQueue(emailDTO);
		   if(emailDTO != null) {
				return new ResponseEntity<ProfileEmailDTO>(emailDTO, HttpStatus.OK);

		   }
		   return null;
	}
	

}
