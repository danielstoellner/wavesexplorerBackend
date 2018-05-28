package backend.controller;

import backend.entity.Squad;
import backend.entity.request.AddGroupRequest;
import backend.repository.GroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@Controller
@RequestMapping(path = "/groups")
public class GroupController {
    private final GroupRepository groupRepository;

    @Autowired
    public GroupController(GroupRepository groupRepository){
        this.groupRepository = groupRepository;
    }

    @PostMapping(path="")
    public @ResponseBody boolean addGroup(@RequestBody AddGroupRequest addGroupRequest){

        if(addGroupRequest.getName().isEmpty()){
            return false; //"Groupname Parameter is missing";
        }

        Squad group = new Squad();
        group.setName(addGroupRequest.getName());
        group.setCurrency(addGroupRequest.getCurrency());
        groupRepository.save(group);
        return true;
    }

    @DeleteMapping(path="/{id}")
    public @ResponseBody String deleteMessageById(@PathVariable(value="id") long id) {
        Squad user = new Squad();
        user = groupRepository.findOne(id);

        if(user != null){
            groupRepository.delete(user);
            return user.getName() + " is deleted";
        }

        return "Group cannot deleted!";
    }

    @PutMapping(path="/{id}")
    public @ResponseBody Squad updateUser (@PathVariable(value="id") long id, @RequestBody Squad updatedGroup, Long user){
        Squad savedGroup = groupRepository.findOne(id);

        if (savedGroup != null){
            savedGroup.setName(updatedGroup.getName());
            savedGroup.setCurrency(updatedGroup.getCurrency());
            groupRepository.save(savedGroup);
            return savedGroup;
        } else {
            return null;
        }
    }

    @GetMapping(path="")
    public @ResponseBody Iterable<Squad> getAllGroups() {
        // This returns a JSON or XML with the users
        return groupRepository.findAll();
    }

    @GetMapping(path="/{id}")
    public @ResponseBody
    Squad getParameterDetails (@PathVariable(value="id") long id) {
        return groupRepository.findOne(id);
    }
}
