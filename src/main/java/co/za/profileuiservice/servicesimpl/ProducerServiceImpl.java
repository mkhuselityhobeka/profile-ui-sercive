package co.za.profileuiservice.servicesimpl;

import co.za.profileuiservice.data.TokenResponseData;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;

import co.za.profileuiservice.config.jms.RabbitMqSenderConfiguration;
import co.za.profileuiservice.data.ProfileEmailDTO;
import co.za.profileuiservice.services.ProducerService;
import lombok.RequiredArgsConstructor;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;

@Service
@RequiredArgsConstructor
public class ProducerServiceImpl implements ProducerService{
	
	private final RabbitTemplate rabbitTemplate;
    private final DirectExchange directExchange;
	private final RabbitMqSenderConfiguration rabbitMqSenderConfiguration;

	private final WebClient.Builder webClientBuilder;


	MultiValueMap<String,String> multiValueMap = new LinkedMultiValueMap<>();


	private String tokenUrl = "http://localhost:8089/realms/my-profile-realm/protocol/openid-connect/token";
	private String clientId="profile-ui-service";
	private String clientSecret="k1tXUwXTmyO3M5QidZSNolAQyFeDytrC";
	private String grant_type="password";
	private String username="mkhuseli";
	private String password="testing123";
	@Override
	public ProfileEmailDTO sendEmailMessageToQueue(ProfileEmailDTO emailDTO){
		rabbitTemplate.convertSendAndReceive(directExchange.getName(), rabbitMqSenderConfiguration.getRoutingKey(), emailDTO);
		return emailDTO;
	}
	/**
	    retrieve access token from keycloak authorization server
	 */
	public TokenResponseData retrieveAccessToken(){
		TokenResponseData tokenResponseData = webClientBuilder.build().post()
				.uri(tokenUrl)
				.header("Authorization","Bearer Token")
				.contentType(MediaType.APPLICATION_FORM_URLENCODED)
				.accept(MediaType.APPLICATION_JSON)
				.body(BodyInserters.fromFormData(mapPostHeaders()))
				.retrieve()
				.bodyToMono(TokenResponseData.class).block();
		return tokenResponseData;
	}

	/**
	    adding access credentials to multi valued map
	 */
	public MultiValueMap<String,String> mapPostHeaders(){

		multiValueMap.add("client_id",clientId);
		multiValueMap.add("client_secret",clientSecret);
		multiValueMap.add("grant_type",grant_type);
		multiValueMap.add("username",username);
		multiValueMap.add("password",password);
		return multiValueMap;
	}
}
