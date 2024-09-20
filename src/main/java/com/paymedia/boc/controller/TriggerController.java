package com.paymedia.boc.controller;

import com.paymedia.boc.integration.XmlLib;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClient;


@RestController
@RequestMapping("/boc")
@Slf4j
@RequiredArgsConstructor
public class TriggerController {

    @Value("${boc.core.url}")
    private String bocCoreUrl;

    private final XmlLib xmlLib;

    @PostMapping("/account")
    public String triggerCoreBank(@RequestBody AccountRequest accountRequest) {

        log.info("request received {}", accountRequest);

       log.info("Core bank URL -- {}", bocCoreUrl);
        String bocCoreXml = xmlLib.buildBocCoreXmlString(accountRequest.getFromAcctDetails(),
                accountRequest.getToAcctDetails(),
                accountRequest.getAmount());

        log.info("XML sent ->  \n {} ", bocCoreXml);
        RestClient client = RestClient.builder().build();
         String response = client
                .post()
                .uri(bocCoreUrl)
                .contentType(MediaType.TEXT_PLAIN)
                 .body(bocCoreXml).retrieve().toEntity(String.class).getBody();
        System.out.println("handled ------  " + response);
        return "------------------ DONE -------------------";
    }
}
