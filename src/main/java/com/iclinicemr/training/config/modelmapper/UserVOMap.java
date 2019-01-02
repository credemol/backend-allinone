package com.iclinicemr.training.config.modelmapper;

import com.iclinicemr.training.domain.entity.User;
import com.iclinicemr.training.message.RoleVO;
import com.iclinicemr.training.message.UserVO;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.beans.BeanUtils;
import org.springframework.util.ObjectUtils;

import java.util.stream.Collectors;

public class UserVOMap extends PropertyMap<User, UserVO> {

    @Override
    protected void configure() {
//        Converter<>

        map().setRoles(source.getRoles().stream().map(
                userRole -> {
                    System.out.println("============> " + userRole);
                    RoleVO roleVO = new RoleVO();

                    //BeanUtils.copyProperties(userRole, roleVO);

                    return roleVO;
                }).collect(Collectors.toSet()));
    }
}
