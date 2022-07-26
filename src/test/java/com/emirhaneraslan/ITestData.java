package com.emirhaneraslan;

import com.emirhaneraslan.Model.User;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ITestData {

    //Success SAVE
    public void testSuccessCreate();

    //unsuccessful SAVE
    public void testUnsuccessfulCreate();

    //FIND
    public void testFind();

    //LIST
    public void testList();

    //UPDATE
    public void testUpdate();

    //DELETE
    public void testDelete();

    //FIND
    public void testUserByFirstName();

}
