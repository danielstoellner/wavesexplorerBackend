package backend.Filesystem;

import backend.entity.BlockTransaction;
import backend.entity.Squad;
import backend.entity.User;
import org.springframework.web.client.RestTemplate;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;

public class CreateTestValues {

//    public static final String REST_SERVICE_URI = "http://37.252.185.169:8080";
    public static final String REST_SERVICE_URI = SettingService.getServerPath();

    public static Boolean isCreated = false;

    public CreateTestValues(){
        if (getUser(1)== null){
            this.isCreated = true;
            createUsers();
            createTeam();
            createBlockTransaction();
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

        user = new User("Hannah", "Fehringer", "hannah", "3PHT9znPcDB9MQ9P4d4uVbkxfXfAggg1nVA");
        result = restTemplate.postForObject(REST_SERVICE_URI+"/users/", user, String.class) ;
        System.out.println("\n User : "+result + "\n");

        user = new User("Patrick", "Migsch", "patrick", "3PArJ42zLBjRnYUQmeiw7orjP3X7w8Xbr29");
        result = restTemplate.postForObject(REST_SERVICE_URI+"/users/", user, String.class) ;
        System.out.println("\n User : "+result + "\n");

        user = new User("Agnes", "Hinterplattner", "agnes", "3PJxUb9bUxfKRVbMvC1vr2P7qYEgvAzenAg");
        result = restTemplate.postForObject(REST_SERVICE_URI+"/users/", user, String.class) ;
        System.out.println("\n User : "+result + "\n");
    }

    /* POST */
    public void createTeam() {
        Squad team;
        String result;

        System.out.println("Testing create Team API----------");
        RestTemplate restTemplate = new RestTemplate();

        team = new Squad("Team 1", "Waves");
        result = restTemplate.postForObject(REST_SERVICE_URI+"/groups/", team, String.class) ;
        System.out.println("\n Group : "+result + "\n");
    }

    /* POST */
    public void createBlockTransaction() {
        BlockTransaction blockTransaction;
        String result;

        System.out.println("Testing create BlockTransaction API----------");
        RestTemplate restTemplate = new RestTemplate();

        blockTransaction = new BlockTransaction(new Date(), 333, 100,8000000, 1000,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15);
        result = restTemplate.postForObject(REST_SERVICE_URI+"/blocktransactions/", blockTransaction, String.class) ;
        System.out.println("\n BlockTransaction : "+result + "\n");
    }
}
