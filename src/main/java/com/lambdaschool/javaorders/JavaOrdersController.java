package com.lambdaschool.javaorders;

import com.lambdaschool.javaorders.models.Agents;
import com.lambdaschool.javaorders.models.Customers;
import com.lambdaschool.javaorders.repository.AgentRepository;
import com.lambdaschool.javaorders.repository.CustomerRepository;
import com.lambdaschool.javaorders.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

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

    // /customer/name/{custname} - Returns all orders based on a particular name

    @GetMapping("/customer/name/{custname}")
    public List<Object> getCustomerOrdersByName(@PathVariable String custname) {
        return ordrepos.findCustomerOrdersByName(custname);
    }

    // /customer/order/{custcode} - Returns all orders for a particular customer based on custcode

    @GetMapping("/customer/order/{custcode}")
    public List<Object> getCustomerOrdersByCustCode(@PathVariable long custcode) {
        return ordrepos.findCustomerOrdersByCustCode(custcode);
    }

    // /agents - Returns all agents with their customers

    @GetMapping("/agents")
    public List<Agents> getAllAgents() {
        return agentrepos.findAll().stream().collect(Collectors.toList());
    }

    // /agents/orders - Return a list with the agents name and associated order number and order description

    @GetMapping("/agents/orders")
    public List<Object> getAgentOrders() {
        return agentrepos.findAgentOrders();
    }

    // /customer/{custcode} - Deletes a customer based off of their custcode and deletes all their associated orders

    @DeleteMapping("/customer/{custcode}")
    public List<Customers> deleteCustomer(@PathVariable long custcode) {
        List<Customers> rmCustomer = custrepos
                .findById(custcode)
                .stream()
                .collect(Collectors.toList());
        custrepos.deleteById(custcode);
        return rmCustomer;
    }

    // /agents/{agentcode} - Deletes an agent if they are not assigned to a customer or order (Stretch Goal)

    @DeleteMapping("/agents/{agentcode}")
    public String deleteAgent(@PathVariable long agentcode) {
        Agents agent = agentrepos
                .findById(agentcode)
                .stream()
                .collect(Collectors.toList()).get(0);

        if (agent.getCustomers().size() == 0 || agent.getOrders().size() == 0) {
            return "Agent cannot be deleted if they are assigned to a customer or order.";
        } else {
            agentrepos.deleteById(agentcode);
            return "Agent was successfully deleted";
        }
    }
}
