package gview.clientservice;


import gview.clientservice.api.ClientDTO;
import gview.clientservice.api.GardenDTO;
import gview.clientservice.api.ServiceDTO;
import gview.clientservice.api.ScheduleDTO;
import gview.clientservice.model.Client;
import gview.clientservice.model.Garden;
import gview.clientservice.model.Service;
import gview.clientservice.model.Schedule;
import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;

public class OrikaConfig {

	private static final MapperFactory mapperFactory;

    static {
        mapperFactory = new DefaultMapperFactory.Builder().build();

        //ConverterFactory converterFactory = mapperFactory.getConverterFactory();
        //converterFactory.registerConverter(new LocalDateTimeToLocalDateConverter());

        mapperFactory.classMap(ClientDTO.class, Client.class)
                .byDefault()
                .register();
        mapperFactory.classMap(Client.class, ClientDTO.class)
		        .byDefault()
		        .register();
        
        mapperFactory.classMap(GardenDTO.class, Garden.class)
		        .byDefault()
		        .register();
		mapperFactory.classMap(Garden.class, GardenDTO.class)
		        .byDefault()
		        .register();
		
		
		mapperFactory.classMap(Service.class, ServiceDTO.class)
		        .byDefault()
		        .register();
		mapperFactory.classMap(ServiceDTO.class, Service.class)
		        .byDefault()
		        .register();
		
		mapperFactory.classMap(Schedule.class, ScheduleDTO.class)
					.byDefault()
		        .register();
		mapperFactory.classMap(ScheduleDTO.class, Schedule.class)
		        .byDefault()
		        .register();
    }

    
    public static MapperFacade getMapperFacade() {
    	return  mapperFactory.getMapperFacade();
    }
}
