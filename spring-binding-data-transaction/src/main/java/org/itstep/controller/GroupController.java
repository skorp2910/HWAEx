package org.itstep.controller;

import org.itstep.data.GroupRepository;
import org.itstep.model.Group;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@RequestMapping("/groups")
@Controller
public class GroupController  {
    GroupRepository groupRepository;

    @Autowired
    public GroupController(GroupRepository groupRepository){
        this.groupRepository = groupRepository;
    }

    @GetMapping
    public String index(Model model){
        model.addAttribute("groups",groupRepository.findAll());
        return "groups/index";
    }

    @GetMapping("/new")
    public String createGroup(){
        return "groups/create";
    }

    @PostMapping("/new")
    public String createGroup(Group group, RedirectAttributes redirectAttributes){
        String message = "";
        int id = 0;
        try{
            id = groupRepository.save(group);
            message = "successfully saved";
        }catch (Exception ex){
            System.out.println(ex.getLocalizedMessage());
            message = "some error";
        }
        redirectAttributes.addFlashAttribute("error",message);
        System.out.println(group);
        return "redirect:/groups/info/" + id;
    }

    @GetMapping("/info/{id}")
    public String info(@PathVariable int id, Model model){
        model.addAttribute("group",groupRepository.find(id));
        return "groups/info";
    }

    @GetMapping("/delete/{id}")
    public String deleteGroup(@PathVariable int id){
        groupRepository.delete((groupRepository.find(id)));
        return "redirect:/groups";
    }

    @GetMapping("/update/{id}")
    public String updateGroup(@PathVariable int id, Model model)
    {
        model.addAttribute("group",groupRepository.find(id));
        return "groups/update";
    }

    @PostMapping("/update/{id}")
    public String updateGroup(Group group){
        groupRepository.update(group);
        return "redirect:/groups";
    }

}
