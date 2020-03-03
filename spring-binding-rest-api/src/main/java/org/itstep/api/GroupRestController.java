package org.itstep.api;

import org.itstep.data.Repository;
import org.itstep.model.Group;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/groups")
public class GroupRestController {
    Repository<Group,Integer> groupRepository;

    @Autowired
    public GroupRestController(Repository<Group,Integer> groupRepository){
        this.groupRepository = groupRepository;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Group> getAllGroups() {
        return groupRepository.findAll();
    }

    @GetMapping(path = "/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public Group getOneGroup(@PathVariable int id){
        return groupRepository.find(id);
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE,
                 consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public Group createGroup(@RequestBody Group group) {
        Integer id = groupRepository.save(group);
        return groupRepository.find(id);
    }

    @DeleteMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public void deleteStudent(@PathVariable int id) {
        groupRepository.delete(groupRepository.find(id));
    }

    @PutMapping(path = "/{id}",produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public Group updateGroup(@PathVariable int id, @RequestBody Group group){
        group.setId(id);
        groupRepository.update(group);
        return groupRepository.find(id);
    }
}
