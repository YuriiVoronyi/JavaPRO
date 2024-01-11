package app.controllers;

import app.services.UserService;

import java.util.Scanner;

public class UserController {

    private Scanner scanner;
    private UserService service;

    public UserController(Scanner scanner, UserService service) {
        this.scanner = scanner;
        this.service = service;
    }

    public void addUser() {

        System.out.println("Введите email");
        String email = scanner.nextLine();

        System.out.println("Введите пароль");
        String password = scanner.nextLine();

        try {
            service.addUser(email, password);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    // TODO реализовать метод получения одного пользователя и БД при этом идентификатор нужно запросить у клиента
    // TODO через консоль. Реализовать метод получения всех пользователей. Оба эти метода должны просто выводить
    // TODO результат в консоль.
    public void getUser() {
        try {
            System.out.println("Введите ID");
            int id = Integer.parseInt(scanner.nextLine());
            System.out.println(service.getById(id));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void getAllUsers() {
        try {
            service.getAll().forEach(x -> System.out.println(x));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
