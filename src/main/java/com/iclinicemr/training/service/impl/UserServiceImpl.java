package com.iclinicemr.training.service.impl;

import com.iclinicemr.training.config.modelmapper.UserVOMap;
import com.iclinicemr.training.domain.entity.User;
import com.iclinicemr.training.domain.repository.UserRepository;
import com.iclinicemr.training.message.UserListVO;
import com.iclinicemr.training.message.UserVO;
import com.iclinicemr.training.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    private ModelMapper modelMapper;
    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(ModelMapper modelMapper, UserRepository userRepository) {
        this.modelMapper = modelMapper;
        this.userRepository = userRepository;

//        this.modelMapper.addMappings(new UserVOMap());
    }

    @Override
    public Page<UserListVO> getUsers(Pageable pageRequest) {
        Page page = userRepository.findAll(pageRequest);

        return page.map( user -> modelMapper.map(user, UserListVO.class));
    }

    @Override
    @Transactional
    public UserVO get(UUID id) {
        User user = userRepository.findById(id).orElse(null);

        if(user == null) {
            throw new EntityNotFoundException();
        }
        return modelMapper.map(user, UserVO.class);
    }

    @Override
    public UserVO create(UserVO user) {
        return modelMapper.map(this.userRepository.save(modelMapper.map(user, User.class)), UserVO.class);
    }


    @Override
    public UserVO update(UUID id, UserVO user) {
        User entity = userRepository.findById(id).orElse(null);

        if(entity == null) {
            throw new EntityNotFoundException();
        }

        User converted = modelMapper.map(user, User.class);

        BeanUtils.copyProperties(converted, entity, "id", "version");

        return modelMapper.map(this.userRepository.save(entity), UserVO.class);

    }

    @Override
    public void delete(UUID id) {
        User entity = userRepository.findById(id).orElse(null);

        if(entity == null) {
            throw new EntityNotFoundException();
        }
        userRepository.delete(entity);
    }
}
