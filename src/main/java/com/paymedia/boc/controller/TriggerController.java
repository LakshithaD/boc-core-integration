package com.paymedia.boc.controller;

import com.paymedia.boc.integration.XmlLib;
import lombok.extern.slf4j.Slf4j;
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
public class TriggerController {

    @PostMapping("/account")
    public String triggerCoreBank(@RequestBody AccountRequest accountRequest) {

        log.info("request received {}", accountRequest);

        System.out.println("received ");
        //"http://127.0.0.1:8790/boc-api/boc/post"
        XmlLib xmlLib = new XmlLib();
        String bocCoreXml = xmlLib.buildBocCoreXmlString(accountRequest.getFromAcctDetails(),
                accountRequest.getToAcctDetails(),
                accountRequest.getAmount());
        //System.out.println(bocCoreXml);
        RestClient client = RestClient.builder().build();
         String response = client
                .post()
                .uri("http://127.0.0.1:8790/boc-api/boc/post")
                .contentType(MediaType.TEXT_PLAIN)
                 .body(bocCoreXml).retrieve().toEntity(String.class).getBody();
        System.out.println("handled ------  " + response);
        return "DONE -------------------";
    }
}
