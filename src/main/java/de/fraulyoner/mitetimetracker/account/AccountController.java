package de.fraulyoner.mitetimetracker.account;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

@Controller
public class AccountController {

    private static final Logger LOG = LoggerFactory.getLogger(AccountController.class);

    @Value("${mite.api.apiKey}")
    private String apiKey;

    @Value("${mite.api.baseUrl}")
    private String baseUrl;

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/")
    public String index(Model model) {

        String url = baseUrl + "account.json?api_key=" + apiKey;

        AccountWrapper accountWrapper = restTemplate.getForObject(url, AccountWrapper.class);

        model.addAttribute("account", accountWrapper.getAccount());

        return "index";
    }

}