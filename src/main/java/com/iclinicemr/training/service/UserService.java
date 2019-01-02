package com.iclinicemr.training.service;

import com.iclinicemr.training.message.UserListVO;
import com.iclinicemr.training.message.UserVO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.UUID;

public interface UserService {
    Page<UserListVO> getUsers(Pageable pageRequest);
    UserVO get(UUID id);
    UserVO create(UserVO user);
    UserVO update(UUID id, UserVO user);
    void delete(UUID id);

}
