package com.lambdaschool.javaorders;

import com.lambdaschool.javaorders.repository.AgentRepository;
import com.lambdaschool.javaorders.repository.CustomerRepository;
import com.lambdaschool.javaorders.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path = {}, produces = MediaType.APPLICATION_JSON_VALUE)
public class JavaOrdersController {
    @Autowired
    AgentRepository agentrepos;

    @Autowired
    CustomerRepository custrepos;

    @Autowired
    OrderRepository ordrepos;

    // /customer/order - Returns all customers with their orders

    @GetMapping("/customer/order")
    public List<Object> getCustomerOrders() {
        return custrepos.findCustomerOrders().stream().collect(Collectors.toList());
    }

    // /customer/name/{custname} - Returns all orders for a particular based on name

    @GetMapping("/customer/name/{custname}")
    public List<Object> getCustomerOrdersByName(@PathVariable String custname) {
        return ordrepos.findCustomerOrdersByName(custname);
    }

    // /customer/order/{custcode} - Returns all orders for a particular customer based on custcode

    // /agents - Returns all agents with their customers

    // /agents/orders - Return a list with the agents name and associated order number and order description

    // /customer/{custcode} - Deletes a customer based off of their custcode and deletes all their associated orders

    // /agents/{agentcode} - Deletes an agent if they are not assigned to a customer or order (Stretch Goal)
}
