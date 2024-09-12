package com.paymedia.boc.integration;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@Data
@XmlAccessorType(XmlAccessType.FIELD)
public class MonSvcRq {
    @XmlElement(name = "RqUID")
    private String rqUID;

    @XmlElement(name = "SPName")
    private String spName;

    @XmlElement(name = "PSAppXferAddRq")
    private PSAppXferAddRq psAppXferAddRq;
}

