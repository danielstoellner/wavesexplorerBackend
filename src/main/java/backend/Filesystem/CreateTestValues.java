package backend.Filesystem;

import backend.entity.User;
import org.springframework.web.client.RestTemplate;

import java.util.LinkedHashMap;
import java.util.List;

public class CreateTestValues {

    public static final String REST_SERVICE_URI = "http://localhost:8080";
    public static Boolean isCreated = false;

    public CreateTestValues(){
        if (getUser(1)== null){
            this.isCreated = true;
            createUsers();
        } else {
            System.out.println("\nTemplate Data are available!!!\n");
            listAllUsers();
        }
    }

    /* GET */
    public static User getUser(long userId){
        RestTemplate restTemplate = new RestTemplate();
        User user = restTemplate.getForObject(REST_SERVICE_URI+"/users/"+userId, User.class);
        return user;
    }

    /* GET */
    @SuppressWarnings("unchecked")
    private void listAllUsers(){
        System.out.println("\nTesting listAllUsers API-----------\n");

        RestTemplate restTemplate = new RestTemplate();
        List<LinkedHashMap<String, Object>> usersMap = restTemplate.getForObject(REST_SERVICE_URI+"/users/", List.class);

        if(usersMap!=null){
            for(LinkedHashMap<String, Object> map : usersMap){
                System.out.println("User : id="+map.get("id")+", Name="+map.get("name")+", Username="+map.get("username")+", password="+map.get("password"));;
            }
        }else{
            System.out.println("No user exist----------");
        }
    }


    /* POST */
    public void createUsers() {
        User user;
        String result;

        System.out.println("Testing create User API----------");
        RestTemplate restTemplate = new RestTemplate();

        user = new User("Daniel", "Stoellner", "daniel", "3PEyJbYQHWXcfenvpqgRKQ9LFHbVSPier5x");
        result = restTemplate.postForObject(REST_SERVICE_URI+"/users/", user, String.class) ;
        System.out.println("\n User : "+result + "\n");

        user = new User("Stefan", "Rechberger", "stefan", "3PFLP8w1sPko1C4GbHdL1PZGRscCumgQ1QG");
        result = restTemplate.postForObject(REST_SERVICE_URI+"/users/", user, String.class) ;
        System.out.println("\n User : "+result + "\n");
    }
}
