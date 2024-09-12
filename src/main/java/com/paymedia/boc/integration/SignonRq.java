package com.paymedia.boc.integration;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@Data
@XmlAccessorType(XmlAccessType.FIELD)
public class SignonRq {
    @XmlElement(name = "SignonPswd")
    private SignonPswd signonPswd;

    @XmlElement(name = "ClientDt")
    private ClientDt clientDt;

    @XmlElement(name = "ClientApp")
    private ClientApp clientApp;

    @XmlElement(name = "ComputerId")
    private String computerId;

    @XmlElement(name = "InstitutionCode")
    private String institutionCode;
}

