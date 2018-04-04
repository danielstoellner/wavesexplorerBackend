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

    @RequestMapping(method = RequestMethod.POST)
    public void addGroup(@RequestBody AddGroupRequest addGroupRequest){
        Squad group = new Squad();
        group.setName(addGroupRequest.getName());
        group.setCurrency(addGroupRequest.getCurrency());
        groupRepository.save(group);
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
