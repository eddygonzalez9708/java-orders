// AGENT

// id primary key, not null Long
// AGENTNAME string
// WORKINGAREA string
// COMMISSION double
// PHONE string
// COUNTRY string

package com.lambdaschool.javaorders.models;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "Agent")
public class Agent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String agentName;
    private String workingArea;
    private double commission;
    private String phone;
    private String country;

    @OneToMany(cascade = CascadeType.REMOVE, mappedBy = "agentCustomers")
    private Set<Customer> customers;

    @OneToMany(cascade = CascadeType.REMOVE, mappedBy = "agentOrders")
    private Set<Order> orders;

    public Agent() {
        // Default Constructor
    }

    public long getId() {
        return id;
    }

    public String getAgentName() {
        return agentName;
    }

    public void setAgentName(String agentName) {
        this.agentName = agentName;
    }

    public String getWorkingArea() {
        return workingArea;
    }

    public void setWorkingArea(String workingArea) {
        this.workingArea = workingArea;
    }

    public double getCommission() {
        return commission;
    }

    public void setCommission(double commission) {
        this.commission = commission;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
