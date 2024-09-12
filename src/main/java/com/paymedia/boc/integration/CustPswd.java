package com.paymedia.boc.integration;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@Data
@XmlAccessorType(XmlAccessType.FIELD)
public class CustPswd {
    @XmlElement(name = "CryptType")
    private String cryptType;

    @XmlElement(name = "Pswd")
    private String pswd;
}

