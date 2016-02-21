package ru.odnolap.JRTestTask.domain;

import javax.persistence.*;

@Entity
@Table(name = "todo")
public class Todo {

    @Id
    @Column(name = "id")
    @GeneratedValue
    private Integer id;

    @Column(name = "descr")
    private String descr;

    @Column(name = "stat")
    private String stat = "Uncompleted";

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescr() {
        return descr;
    }

    public void setDescr(String descr) {
        this.descr = descr;
    }

    public String getStat() {
        return stat;
    }

    public void setStat(String stat) {
        this.stat = stat;
    }
}
