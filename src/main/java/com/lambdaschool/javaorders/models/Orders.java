// ORDER

// ORDNUM primary key, not null Long
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
    private long ordnum;

    @Column(nullable = false)
    private double ordamount;
    private double advanceamount;
    private String orddescription;

    @ManyToOne
    @JoinColumn(name = "custcode", nullable = false)
    @JsonIgnore
    private Customers customerorders;

    @ManyToOne
    @JoinColumn(name = "agentcode", nullable = false)
    @JsonIgnore
    private Agents agentorders;

    public Orders() {
        // Default Constructor
    }

    public long getOrdnum() {
        return ordnum;
    }

    public double getOrdamount() {
        return ordamount;
    }

    public void setOrdamount(double ordamount) {
        this.ordamount = ordamount;
    }

    public double getAdvanceamount() {
        return advanceamount;
    }

    public void setAdvanceamount(double advanceamount) {
        this.advanceamount = advanceamount;
    }

    public String getOrddescription() {
        return orddescription;
    }

    public void setOrddescription(String orddescription) {
        this.orddescription = orddescription;
    }

    public Customers getCustomerorders() {
        return customerorders;
    }

    public void setCustomerorders(Customers customerorders) {
        this.customerorders = customerorders;
    }

    public Agents getAgentorders() {
        return agentorders;
    }

    public void setAgentorders(Agents agentorders) {
        this.agentorders = agentorders;
    }
}
