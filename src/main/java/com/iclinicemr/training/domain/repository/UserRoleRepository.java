package com.iclinicemr.training.domain.repository;

import com.iclinicemr.training.domain.entity.UserRole;
import com.iclinicemr.training.domain.entity.UserRoleId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRoleRepository extends JpaRepository<UserRole, UUID> {
}
