package backend.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Height {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;
    private long height;

    public long getHeight(){
        return this.height;
    }

    public void setHeight(long height){
        this.height = height;
    }
}
