package com.emirhaneraslan;

import com.emirhaneraslan.Model.User;
import com.emirhaneraslan.Repository.UserRepository;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Log4j2
class RegisterApplicationTests implements ITestData{

    @Autowired
    UserRepository repository;

    @PersistenceContext
    EntityManager entityManager;


    //Create Success Test
    @Override
    @Test
    public void testSuccessCreate() {
        User user= User.builder().
                userFirstName("Emirhan Talha").
                userLastName("Eraslan").
                userMail("emraefha@hotmail.com").
                userPassword("159753").
                build();

        log.info(user);

        repository.save(user);
    }

    //Create Unsuccessful Test
    @Override
    @Test
    public void testUnsuccessfulCreate() {
        User user= User.builder().
                userLastName("Eraslan").
                userMail("emraefha@hotmail.com").
                userPassword("159753").
                build();

        log.info(user);

        repository.save(user);
    }

    @Override
    @Test
    public void testFind() {
        User user=(User) entityManager
                .createNamedQuery("User.findById")
                .setParameter("userId",1L)
                .getSingleResult();

        log.info(user);

        assertEquals("Rahime",user.getUserFirstName());
    }

    @Override
    @Test
    public void testList() {
        List<User> entityList=(List<User>) entityManager
                .createNamedQuery("User.findAll")
                .getResultList();

        log.info(entityList);

        assertThat(entityList).size().isGreaterThan(0);

    }

    @Override
    @Test
    public void testUpdate() {
        User user=(User) entityManager
                .createNamedQuery("User.findById")
                .setParameter("userId",2L)
                .getSingleResult();

        user.setUserFirstName("Emirhan");
        user.setUserLastName("Eraslan");
        user.setUserMail("xxx@gmail.com");
        user.setUserPassword("emraefha119598");

        repository.save(user);

        log.info(user);



    }

    @Override
    @Test
    public void testDelete() {
        /*repository.deleteById(4L);
        assertThat(repository.existsById(4L)).isFalse();*/
    }

    @Override
    @Test
    public void testUserByFirstName() {
        List<User> entityList= (List<User>) entityManager.
                createNamedQuery("User.findByUserFirstName").
                setParameter("userFirstName","Emirhan Talha").
                getResultList();

        log.info(entityList);

        assertThat(entityList).size().isGreaterThan(0);
    }

}
