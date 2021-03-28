package br.com.rodrigogmartins.restwithspringboot.converters;

import com.github.dozermapper.core.DozerBeanMapperBuilder;
import com.github.dozermapper.core.Mapper;

import java.util.ArrayList;
import java.util.List;

public class DozerConverter {

    private static Mapper mapper = DozerBeanMapperBuilder.buildDefault();

    public static <Origin, Destination> Destination parseObject(Origin origin, Class<Destination> destinationClass) {
        return mapper.map(origin, destinationClass);
    }

    public static <Origin, Destination> List<Destination> parseObjectsList(List<Origin> originObjects, Class<Destination> destinationClass) {
        List<Destination> destinationObjects = new ArrayList<>();

        for (Object originObject : originObjects) {
            destinationObjects.add(mapper.map(originObject, destinationClass));
        }

        return destinationObjects;
    }
}
