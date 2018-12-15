package com.iclinicemr.training.domain.repository;

import com.iclinicemr.training.domain.entity.Role;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class RoleRepositoryTest {
    @Autowired
    RoleRepository roleRepository;

    @Test
    @DisplayName("Insert roles")
    public void test_01_InsertRoles() {
        Role customerRole = new Role("Customer");
        Role staffRole = new Role("Staff");
        Role managerRole = new Role("Manager");
        Role systemAdminRole = new Role("SystemAdmin");

        roleRepository.save(customerRole);
        roleRepository.save(staffRole);
        roleRepository.save(managerRole);
        roleRepository.save(systemAdminRole);
    }

}
