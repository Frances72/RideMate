package RideMate.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by User on 2015/05/10.
 */
@Entity
public class Reader implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Double distance;

    public Reader(){

    }

    public Reader(Builder builder){
        distance = builder.distance;
    }

    public Double getDistance(){return distance;}

    public Long getReaderId(){return id;}

    public static class Builder{
        private Double distance;

        public Builder(Double value){
            this.distance = value;
        }

        public Builder copy (Reader value){
            this.distance = value.distance;
            return this;
        }
        public Reader build(){
            return new Reader(this);
        }
    }
}
