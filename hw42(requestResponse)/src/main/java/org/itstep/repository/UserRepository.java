package org.itstep.repository;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

import org.itstep.domain.User;

public class UserRepository implements CrudRepository<User, Integer> {

    final static String DBNAME = "users.db";
    final Path fullPath; // путь к папке с базой данных

    public UserRepository(String baseDir) throws FileNotFoundException {
        if (!Files.isDirectory(Paths.get(baseDir))) {
            throw new FileNotFoundException("Can't find database");
        }
        fullPath = Paths.get(baseDir, DBNAME);
    }

    @Override
    public Integer save(User user) throws IOException {
        Files.writeString(fullPath, User.toText(user));
        return null;
    }

    @Override
    public User update(final User domain) throws IOException {
        throw new IOException("Not implemented yet");
    }

    @Override
    public User findById(Integer id) throws IOException {
        throw new IOException("Not implemented yet");
    }

    @Override
    public List<User> findAll() throws IOException {
        return Files.lines(fullPath).map(User::parese).collect(Collectors.toList());
    }
}