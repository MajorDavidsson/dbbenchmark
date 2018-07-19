package cz.davidsochor.mrmibenchdb.services;

import cz.davidsochor.mrmibenchdb.annotations.StopWatch;
import cz.davidsochor.mrmibenchdb.entities.UserEntity;
import cz.davidsochor.mrmibenchdb.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Repository
public class UserService {

    private static  final int MAX_ENTITIES = 100000;

    @Autowired
    private UserRepository repository;

    @Transactional
    @StopWatch
    public void createNewUsers() {
        for (int i = 0;i < MAX_ENTITIES; i++) {
            repository.save(new UserEntity("Alfons", "Zlaticko", "zeli", "zeli@exaple.com", "Na Zatlánce 9, 11150 Praha - Komárov"));
        }
    }

    @Transactional
    @StopWatch
    public void createUsersAsBatch() {
        List<UserEntity> users = new ArrayList<>();

        for (int i = 0;i < MAX_ENTITIES; i++) {
            users.add(new UserEntity("Alfons", "Zlaticko", "zeli", "zeli@exaple.com", "Na Zatlánce 9, 11150 Praha - Komárov"));
        }

        repository.saveAll(users);
    }

    @Transactional
    public List<UserEntity> getAll() {
        return repository.findAll();
    }
}
