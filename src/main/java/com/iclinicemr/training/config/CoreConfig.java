package com.iclinicemr.training.config;

import com.iclinicemr.training.config.modelmapper.UserVOMap;
import com.iclinicemr.training.domain.entity.OrderItem;
import com.iclinicemr.training.domain.entity.User;
import com.iclinicemr.training.domain.entity.UserRole;
import com.iclinicemr.training.message.OrderItemVO;
import com.iclinicemr.training.message.RoleVO;
import com.iclinicemr.training.message.UserVO;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.modelmapper.TypeToken;
import org.modelmapper.convention.MatchingStrategies;
import org.modelmapper.convention.NameTokenizers;
import org.modelmapper.convention.NamingConventions;
import org.modelmapper.spi.MappingContext;
import org.modelmapper.spi.MatchingStrategy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Configuration

public class CoreConfig {

    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();


        org.modelmapper.config.Configuration modelMapperConfig = modelMapper.getConfiguration();
        modelMapperConfig.setMatchingStrategy(MatchingStrategies.LOOSE);
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


//        modelMapper.addConverter(new Converter<User, UserVO>() {
//            @Override
//            public UserVO convert(MappingContext<User, UserVO> context) {
//                UserVO vo = new UserVO();
//                User  user = context.getSource();
//
//                vo.setUsername(user.getUsername());
//                System.out.println("============> " + user.getRoles());
//                vo.setRoles(user.getRoles().stream().map(userRole -> {
//                    RoleVO roleVO = new RoleVO();
//                    roleVO.setRole(userRole.getRole());
//                    return roleVO;
//                }).collect(Collectors.toSet()));
//                return vo;
//            }
//        });
//
//        modelMapper.addConverter(new Converter<UserRole, RoleVO>() {
//            @Override
//            public RoleVO convert(MappingContext<UserRole, RoleVO> context) {
//                RoleVO vo = new RoleVO();
//
//                vo.setRole(context.getSource().getRole().getRole());
//                return vo;
//            }
//        });
        //modelMapper.addMappings(new UserVOMap());

        return modelMapper;
    }
}
