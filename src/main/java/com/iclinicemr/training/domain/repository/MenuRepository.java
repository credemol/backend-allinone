package com.iclinicemr.training.domain.repository;

import com.iclinicemr.training.domain.entity.Menu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface MenuRepository extends JpaRepository<Menu, UUID> {

    <S extends Menu> Optional<S> findOneByName(String name);
}
