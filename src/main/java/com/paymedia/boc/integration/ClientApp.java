package com.paymedia.boc.integration;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@Data
@XmlAccessorType(XmlAccessType.FIELD)
public class ClientApp {
    @XmlElement(name = "Org")
    private String org;

    @XmlElement(name = "Name")
    private String name;

    @XmlElement(name = "Version")
    private String version;

    @XmlElement(name = "ClientAppKey")
    private String clientAppKey;
}

