package co.za.profileuiservice.services;

import co.za.profileuiservice.data.ProfileEmailDTO;

public interface ProducerService {
	
	public  ProfileEmailDTO sendEmailMessageToQueue(ProfileEmailDTO emailDTO);

}
