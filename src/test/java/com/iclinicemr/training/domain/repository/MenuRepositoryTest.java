package com.iclinicemr.training.domain.repository;

import com.iclinicemr.training.domain.entity.Menu;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class MenuRepositoryTest {
    @Autowired
    MenuRepository menuRepository;


    @Test
    @DisplayName("Insert menus")
    public void test_01_InsertMenus() {
        Menu juniperLatte = new Menu("Juniper Latte", new BigDecimal(3.5));
        Menu icedJuniperLatte = new Menu("Iced Juniper Latte", new BigDecimal(4.0));
        Menu caffeLatte = new Menu("Caffe Latte", new BigDecimal(5.0));

        menuRepository.save(juniperLatte);
        menuRepository.save(icedJuniperLatte);
        menuRepository.save(caffeLatte);
    }

}
