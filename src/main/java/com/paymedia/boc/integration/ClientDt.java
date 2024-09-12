package com.paymedia.boc.integration;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@Data
@XmlAccessorType(XmlAccessType.FIELD)
public class ClientDt {
    @XmlElement(name = "Year")
    private int year;

    @XmlElement(name = "Month")
    private int month;

    @XmlElement(name = "Day")
    private int day;
}

