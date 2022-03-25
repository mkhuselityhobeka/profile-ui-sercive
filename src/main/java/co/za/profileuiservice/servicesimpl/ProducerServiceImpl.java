package co.za.profileuiservice.servicesimpl;

import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import co.za.profileuiservice.config.RabbitMqSenderConfig;
import co.za.profileuiservice.data.ProfileEmailDTO;
import co.za.profileuiservice.services.ProducerService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProducerServiceImpl implements ProducerService{
	
	private final RabbitTemplate rabbitTemplate;
    private final DirectExchange directExchange;
	private final RabbitMqSenderConfig rabbitMqSenderConfig;
	
	@Override
	public ProfileEmailDTO sendEmailMessageToQueue(ProfileEmailDTO emailDTO){
		rabbitTemplate.convertSendAndReceive(directExchange.getName(), rabbitMqSenderConfig.getRoutingKey(), emailDTO);
		return emailDTO;
	}

}
