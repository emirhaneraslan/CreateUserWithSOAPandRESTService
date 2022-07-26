package com.emirhaneraslan.Application;

import com.emirhaneraslan.Model.User;
import com.emirhaneraslan.Service.Impl.UserServiceImpl;
import com.emirhaneraslan.student.*;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
@Endpoint
public class UserEndpoint {

    private static final String NAMESPACE_URI = "http://com.emirhaneraslan/register";

    @Autowired
    private UserServiceImpl userService;

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "addUserRequest")
    @ResponsePayload
    public AddUserResponse addUser(@RequestPayload AddUserRequest request) {
        AddUserResponse response = new AddUserResponse();
        ServiceStatus serviceStatus = new ServiceStatus();

        User user = new User();
        BeanUtils.copyProperties(request.getUserInfo(), user);
        userService.AddUser(user);
        serviceStatus.setStatus("Başarılı");
        serviceStatus.setMessage("İçerik Başarıyla Eklendi.");
        response.setServiceStatus(serviceStatus);
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getUserByIdRequest")
    @ResponsePayload
    public GetUserResponse getUser(@RequestPayload GetUserByIdRequest request) {
        GetUserResponse response = new GetUserResponse();
        UserInfo userInfo = new UserInfo();
        BeanUtils.copyProperties(userService.getUserById(request.getUserId()), userInfo);
        response.setUserInfo(userInfo);
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "updateUserRequest")
    @ResponsePayload
    public UpdateUserResponse updateUser(@RequestPayload UpdateUserRequest request) {
        User user = new User();
        BeanUtils.copyProperties(request.getUserInfo(), user);
        userService.updateUser(user);
        ServiceStatus serviceStatus = new ServiceStatus();
        serviceStatus.setStatus("Başarılı");
        serviceStatus.setMessage("İçerik Başarıyla Güncellendi.");
        UpdateUserResponse response = new UpdateUserResponse();
        response.setServiceStatus(serviceStatus);
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "deleteUserRequest")
    @ResponsePayload
    public DeleteUserResponse deleteUser(@RequestPayload DeleteUserRequest request) {
        userService.deleteUser(request.getUserId());
        ServiceStatus serviceStatus = new ServiceStatus();

        serviceStatus.setStatus("Başarılı");
        serviceStatus.setMessage("İçerik Başarıyla Silindi.");
        DeleteUserResponse response = new DeleteUserResponse();
        response.setServiceStatus(serviceStatus);
        return response;
    }
}
