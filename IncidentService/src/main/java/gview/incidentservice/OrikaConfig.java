package gview.incidentservice;


import gview.incidentservice.api.IncidentDTO;
import gview.incidentservice.model.Incident;
import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;

public class OrikaConfig {

	private static final MapperFactory mapperFactory;

    static {
        mapperFactory = new DefaultMapperFactory.Builder().build();

        //ConverterFactory converterFactory = mapperFactory.getConverterFactory();
        //converterFactory.registerConverter(new LocalDateTimeToLocalDateConverter());

        mapperFactory.classMap(IncidentDTO.class, Incident.class)
                .byDefault()
                .register();
        mapperFactory.classMap(Incident.class, IncidentDTO.class)
        		.exclude("active")
		        .byDefault()
		        .register();
    }

    
    public static MapperFacade getMapperFacade() {
    	return  mapperFactory.getMapperFacade();
    }
}
