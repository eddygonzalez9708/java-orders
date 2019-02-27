//CUSTOMER

// id primary key, not null Long
// CUSTNAME String, not null
// CUSTCITY String
// WORKINGAREA String
// CUSTCOUNTRY String
// GRADE String
// OPENINGAMT double
// RECEIVEAMT double
// PAYMENTAMT double
// OUTSTANDINGAMT double
// PHONE String
// AGENTCODE Long foreign key (one agent to many customers) not null


package com.lambdaschool.javaorders.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "Customers")
public class Customers {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String custName;
    private String custCity;
    private String workArea;
    private String custCountry;
    private String grade;
    private double openingAmt;
    private double receiveAmt;
    private double outstandingAmt;
    private String phone;

    @OneToMany(cascade = CascadeType.REMOVE, mappedBy = "customerOrders")
    private Set<Orders> orders;

    @ManyToOne
    @JoinColumn(name = "agentcode", nullable = false)
    @JsonIgnore
    private Agents agentCustomers;

    public Customers() {
        // Default Constructor
    }

    public long getId() {
        return id;
    }

    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }

    public String getCustCity() {
        return custCity;
    }

    public void setCustCity(String custCity) {
        this.custCity = custCity;
    }

    public String getWorkArea() {
        return workArea;
    }

    public void setWorkArea(String workArea) {
        this.workArea = workArea;
    }

    public String getCustCountry() {
        return custCountry;
    }

    public void setCustCountry(String custCountry) {
        this.custCountry = custCountry;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public double getOpeningAmt() {
        return openingAmt;
    }

    public void setOpeningAmt(double openingAmt) {
        this.openingAmt = openingAmt;
    }

    public double getReceiveAmt() {
        return receiveAmt;
    }

    public void setReceiveAmt(double receiveAmt) {
        this.receiveAmt = receiveAmt;
    }

    public double getOutstandingAmt() {
        return outstandingAmt;
    }

    public void setOutstandingAmt(double outstandingAmt) {
        this.outstandingAmt = outstandingAmt;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Agents getAgentCustomers() {
        return agentCustomers;
    }

    public void setAgentCustomers(Agents agentCustomers) {
        this.agentCustomers = agentCustomers;
    }
}
