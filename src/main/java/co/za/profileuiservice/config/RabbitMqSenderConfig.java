package co.za.profileuiservice.config;


import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import lombok.Getter;
import lombok.Setter;




@Configuration
@Getter@Setter
public class RabbitMqSenderConfig {
	
	@Value("${spring.rabbitmq.host}")
	private String host;
	@Value("${spring.rabbitmq.username}")
	private String username;
	@Value("${spring.rabbitmq.password}")
	private String password;
	@Value("${spring.rabbitmq.template.default-receive-queue}")
	private String queue;
	@Value("${spring.rabbitmq.template.exchange}")
	private String directExchange;
	@Value("${spring.rabbitmq.template.routing-key}")
	private String routingKey;
	
	 @Bean
	 CachingConnectionFactory connectionFactory() {
		 CachingConnectionFactory connectionFactory = new CachingConnectionFactory(host);
		 connectionFactory.setUsername(username);
		 connectionFactory.setPassword(password);
		 return connectionFactory;
	 }	
	
	 //Convert message to json
	 @Bean
	 public MessageConverter jsonMessageConverter() {
		 return new Jackson2JsonMessageConverter();
	 }
	
	//initialise rabbitTemplate with default connection
	 @Bean
	RabbitTemplate rabbitTemplate(CachingConnectionFactory connectionFactory) {
		 RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
		 rabbitTemplate.setMessageConverter(jsonMessageConverter());
		return rabbitTemplate;
	}
	 
	 @Bean
	 public DirectExchange exchange() {
		 return new DirectExchange(directExchange);
	 }
	 
	 @Bean
	 public Queue queue() {
		 return new Queue(queue,false);
		 
	 }
	 @Bean
	 public Binding queueBinding(Queue queue, DirectExchange directExchange){
		 return BindingBuilder.bind(queue).to(directExchange).with(routingKey);
	 }
	 

}
