package entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

@Entity
@Table(name = "record")
public class Result implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Getter
    @Setter
    @Column(name = "x")
    private double x;

    @Getter
    @Setter
    @Column(name = "y")
    private double y;

    @Getter
    @Setter
    @Column(name = "r")
    private double r = 1.0;

    @Getter
    @Setter
    @Column(columnDefinition = "timestamp without time zone default now()", name = "record_time")
    private Timestamp currentTime;

    @Getter
    @Setter
    @Column(name = "execution_time")
    private double executionTime;

    @Getter
    @Setter
    @Column(name = "hit")
    private boolean hit;

    @Getter
    @Setter
    @Column(name = "type")
    private Type type;

    public Result() {}

    public Result(double x, double y, double r, Timestamp currentTime, double executionTime, boolean hit) {
        this.x = x;
        this.y = y;
        this.r = r;
        this.currentTime = currentTime;
        this.executionTime = executionTime;
        this.hit = hit;
    }

    @Override
    public String toString(){
        return "{id: " + id + ", " +
                "x: " + x + ", " +
                "y: " + y + ", " +
                "r: " + r + ", " +
                "time: " + currentTime + ", " +
                "ex_time: " + executionTime + ", " +
                "hit: " + hit + ", " +
                "type: " + type + "}";
    }
}
