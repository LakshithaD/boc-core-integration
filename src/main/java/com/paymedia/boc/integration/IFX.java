package com.paymedia.boc.integration;


import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@Data
@XmlRootElement(name = "IFX")
@XmlAccessorType(XmlAccessType.FIELD)
public class IFX {
    @XmlElement(name = "SignonRq")
    private SignonRq signonRq;

    @XmlElement(name = "EnvironmentInfo")
    private EnvironmentInfo environmentInfo;

    @XmlElement(name = "MonSvcRq")
    private MonSvcRq monSvcRq;
}

