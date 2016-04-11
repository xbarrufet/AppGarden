package gview.gardenservice;




import gview.gardenservice.api.GardenDTO;
import gview.gardenservice.model.Garden;
import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;

public class OrikaConfig {

	private static final MapperFactory mapperFactory;

    static {
        mapperFactory = new DefaultMapperFactory.Builder().build();

        //ConverterFactory converterFactory = mapperFactory.getConverterFactory();
        //converterFactory.registerConverter(new LocalDateTimeToLocalDateConverter());

        mapperFactory.classMap(GardenDTO.class, Garden.class)
                .byDefault()
                .register();
        mapperFactory.classMap(Garden.class, GardenDTO.class)
        		.exclude("active")
		        .byDefault()
		        .register();
    }

    
    public static MapperFacade getMapperFacade() {
    	return  mapperFactory.getMapperFacade();
    }
}
