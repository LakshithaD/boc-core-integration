package com.paymedia.boc.integration;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@Data
@XmlAccessorType(XmlAccessType.FIELD)
public class SignonPswd {
    @XmlElement(name = "SignonRole")
    private String signonRole;

    @XmlElement(name = "CustId")
    private CustId custId;

    @XmlElement(name = "CustPswd")
    private CustPswd custPswd;

    @XmlElement(name = "GenSessKey")
    private int genSessKey;
}
