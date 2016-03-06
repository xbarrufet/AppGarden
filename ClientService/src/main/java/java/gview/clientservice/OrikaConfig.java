package java.gview.clientservice;


import java.gview.clientservice.api.ClientDTO;
import java.gview.clientservice.model.Client;

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
        		.exclude("active")
		        .byDefault()
		        .register();
    }

    
    public static MapperFacade getMapperFacade() {
    	return  mapperFactory.getMapperFacade();
    }
}
