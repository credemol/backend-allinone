package com.iclinicemr.training.config;

import com.iclinicemr.training.domain.entity.OrderItem;
import com.iclinicemr.training.message.OrderItemVO;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.modelmapper.TypeToken;
import org.modelmapper.convention.MatchingStrategies;
import org.modelmapper.convention.NameTokenizers;
import org.modelmapper.convention.NamingConventions;
import org.modelmapper.spi.MatchingStrategy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

@Configuration

public class CoreConfig {

    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();


        org.modelmapper.config.Configuration modelMapperConfig = modelMapper.getConfiguration();
        modelMapperConfig.setMatchingStrategy(MatchingStrategies.STRICT);
//        modelMapperConfig.setSourceNamingConvention(NamingConventions.NONE);
//        modelMapperConfig.setDestinationNamingConvention(NamingConventions.NONE);
        modelMapperConfig.setMethodAccessLevel(org.modelmapper.config.Configuration.AccessLevel.PUBLIC);
        modelMapperConfig.setSourceNameTokenizer(NameTokenizers.CAMEL_CASE);
        modelMapperConfig.setDestinationNameTokenizer(NameTokenizers.CAMEL_CASE);
        modelMapperConfig.setSourceNamingConvention(NamingConventions.JAVABEANS_ACCESSOR);
        modelMapperConfig.setDestinationNamingConvention(NamingConventions.JAVABEANS_MUTATOR);

//        modelMapper.addMappings(new PropertyMap<OrderItem, OrderItemVO>() {
//            @Override
//            protected void configure() {
//                System.out.println("configure OrderItem");
//            }
//        });
//
//        modelMapper.addMappings(new PropertyMap<List<OrderItem>, List<OrderItemVO>>() {
//            @Override
//            protected void configure() {
//                System.out.println("configure List<OrderItem>");
//            }
//        });


        //Type type = new TypeToken<List<OrderItem>>(){}.getType();

//        modelMapper.createTypeMap();
//
//        modelMapper.addMappings(new PropertyMap<ArrayList<OrderItem>, ArrayList<OrderItemVO>>() {
//            @Override
//            protected void configure() {
//                System.out.println("configure ArrayList<OrderItem>");
//            }
//        });



//        modelMapper.
//        modelMapper.createTypeMap(List<OrderItem>, List<O>)



        return modelMapper;
    }
}
