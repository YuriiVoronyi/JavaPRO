package app.services;

import app.domain.User;
import app.repositories.UserRepository;

import java.util.List;
import java.util.NoSuchElementException;

public class UserService {
    private UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public void addUser(String email, String password) {
        // TODO проверка параметров на null и пустоту - домашнее задание
        if (email == null || email.isEmpty()) {
            throw new IllegalArgumentException("Email не может быть пустым");
        }

        if (password == null || password.isEmpty()) {
            throw new IllegalArgumentException("Пароль не может быть пустым");
        }

        if (!email.contains("@")) {
            throw new IllegalArgumentException("Email должен содержать @");
        }

        // TODO проверить, не существует ли уже в БД пользователь с таким email
        User existedUser = repository.findByEmail(email);
        if (existedUser != null) {
            throw new IllegalArgumentException("Email уже занят!");
        }

        repository.save(new User(email, password));

    }

    // TODO реализовать методы по получению одного и всех пользователей
    public User getById(int id) {
        User user = repository.findById(id);
        if (user == null) {
            throw new NoSuchElementException("Пользователь не существует!");
        }
        return user;
    }

    public List<User> getAll() {
        List<User> users = repository.findAll();
        if (users.isEmpty()) {
            throw new NoSuchElementException("Список пользователей пуст!");
        }
        return users;
    }
}
