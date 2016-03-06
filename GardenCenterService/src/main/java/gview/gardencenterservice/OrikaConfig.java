package gview.gardencenterservice;


import gview.gardencenterservice.api.GardenCenterDTO;
import gview.gardencenterservice.model.GardenCenter;
import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;

public class OrikaConfig {

	private static final MapperFactory mapperFactory;

    static {
        mapperFactory = new DefaultMapperFactory.Builder().build();

        //ConverterFactory converterFactory = mapperFactory.getConverterFactory();
        //converterFactory.registerConverter(new LocalDateTimeToLocalDateConverter());

        mapperFactory.classMap(GardenCenterDTO.class, GardenCenter.class)
                .byDefault()
                .register();
        mapperFactory.classMap(GardenCenter.class, GardenCenterDTO.class)
        		.exclude("active")
		        .byDefault()
		        .register();
    }

    
    public static MapperFacade getMapperFacade() {
    	return  mapperFactory.getMapperFacade();
    }
}
