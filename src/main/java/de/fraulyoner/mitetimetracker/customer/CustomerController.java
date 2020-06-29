package de.fraulyoner.mitetimetracker.customer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Controller
public class CustomerController {

    private static final Logger LOG = LoggerFactory.getLogger(CustomerController.class);

    @Value("${mite.api.apiKey}")
    private String apiKey;

    @Value("${mite.api.baseUrl}")
    private String baseUrl;

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/customers")
    public String customers(Model model) {

        String url = baseUrl + "customers.json?api_key=" + apiKey;

        ResponseEntity<CustomerWrapper[]> response =
                restTemplate.getForEntity(
                        url,
                        CustomerWrapper[].class);
        CustomerWrapper[] customers = response.getBody();
        List<Customer> customersList = new ArrayList<>();

        if (customers != null) {
            LOG.info("Found " + customers.length + " customers.");

            for (CustomerWrapper w : customers) {
                Customer customer = w.getCustomer();
                customersList.add(customer);
                LOG.info("Kunde: " + customer.getName());
            }
        }

        model.addAttribute("customers", customersList);
        return "customers";
    }


}