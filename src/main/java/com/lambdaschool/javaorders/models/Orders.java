// ORDER

// id primary key, not null Long
// ORDAMOUNT double
// ADVANCEAMOUNT double
// CUSTCODE Long foreign key (one customer to many orders) not null
// AGENTCODE Long foreign key (one agent to many orders) not null
// ORDDESCRIPTION

package com.lambdaschool.javaorders.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "Orders")
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private double ordAmount;
    private double advanceAmount;
    private String ordDescription;

    @ManyToOne
    @JoinColumn(name = "custcode", nullable = false)
    @JsonIgnore
    private Customers customerOrders;

    @ManyToOne
    @JoinColumn(name = "agentcode", nullable = false)
    @JsonIgnore
    private Agents agentOrders;

    public Orders() {
        // Default Constructor
    }

    public long getId() {
        return id;
    }

    public double getOrdAmount() {
        return ordAmount;
    }

    public void setOrdAmount(double ordAmount) {
        this.ordAmount = ordAmount;
    }

    public double getAdvanceAmount() {
        return advanceAmount;
    }

    public void setAdvanceAmount(double advanceAmount) {
        this.advanceAmount = advanceAmount;
    }

    public Customers getCustomerOrders() {
        return customerOrders;
    }

    public void setCustomerOrders(Customers customerOrders) {
        this.customerOrders = customerOrders;
    }

    public Agents getAgentOrders() {
        return agentOrders;
    }

    public void setAgentOrders(Agents agentOrders) {
        this.agentOrders = agentOrders;
    }

    public String getOrdDescription() {
        return ordDescription;
    }

    public void setOrdDescription(String ordDescription) {
        this.ordDescription = ordDescription;
    }
}
