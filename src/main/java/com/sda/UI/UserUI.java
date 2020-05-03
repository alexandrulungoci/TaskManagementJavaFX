package com.sda.UI;


import com.sda.UI.exceptions.WrongCredentialsException;
import com.sda.model.UserModel;
import com.sda.services.UsersService;

import java.util.List;
import java.util.Scanner;

public class UserUI {

    Scanner scanner = new Scanner(System.in);
    UsersService usersService = new UsersService();
    private UserModel loggedinUser;


    public void registerUser(String firstName, String lastName, String username, String password) {
        UserModel userModel = new UserModel();
        userModel.setFirstName(firstName);
        userModel.setLastName(lastName);
        userModel.setUsername(username);
        userModel.setPassword(password);
        usersService.addUser(userModel);
    }


    public UserModel login() {
        UserModel user = findUser();
        System.out.println("Enter password");
        String password = scanner.nextLine();
        if (user.getPassword().equals(password)) {
            loggedinUser = user;
            System.out.println("You ere loggedin in as " + loggedinUser.getUserName());
            return loggedinUser;
        } else {
            System.out.println("Wrong password");
        }
        return null;
    }

    public UserModel findUser() {
        UserModel userFound = null;
        while (userFound == null) {
            System.out.println("Enter User Name");
            String name = scanner.nextLine();
            try {
                userFound = usersService.findUserByUserName(name);
            } catch (WrongCredentialsException e) {
                System.out.println("Wrong username. Enter again!");
            }
        }
        return userFound;
    }

    public void changeUsername() {
        if (loggedinUser == null) {
            System.out.println("Please login");
            login();
        }
        System.out.println("You ere loggedin in as " + loggedinUser.getUserName());
        System.out.println("Enter new username");
        String newUsername = scanner.nextLine();
        loggedinUser.setUsername(newUsername);
        usersService.updateUsername(loggedinUser);

    }

    public void printUsers() {
        List<UserModel> allUsers = usersService.getUsers();
        allUsers.forEach(u -> {
            System.out.println("(Id) " + u.getId() + " (Name) " + u.getFirstName() + " " + u.getLastName()
                    + " (username) " + u.getUserName());
        });
    }

    public void removeUser() {
        printUsers();
        System.out.println("Select user id to remove");
        int id = scanner.nextInt();
        scanner.nextLine();
        UserModel userToRemove = usersService.findUserById(id);
        usersService.removeUser(userToRemove);
    }


}
