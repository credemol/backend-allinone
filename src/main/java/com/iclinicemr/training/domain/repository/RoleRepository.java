package com.iclinicemr.training.domain.repository;

import com.iclinicemr.training.domain.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface RoleRepository extends JpaRepository<Role, UUID> {
//    @Override
//    <S extends Role> Optional<S> findOne(Example<S> example);

    Optional<Role> findOneByRole(String role);
}
