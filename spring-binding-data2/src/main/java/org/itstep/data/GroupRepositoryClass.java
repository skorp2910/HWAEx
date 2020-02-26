package org.itstep.data;

import org.itstep.model.Group;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class GroupRepositoryClass implements org.itstep.data.GroupRepository<Group,Integer> {

    @Override
    public Integer save(Group data) {
        return null;
    }

    @Override
    public void update(Group data) {

    }

    @Override
    public void delete(Group data) {

    }

    @Override
    public List<Group> findAll() {
        return null;
    }

    @Override
    public Group find(Integer integer) {
        return null;
    }
}
