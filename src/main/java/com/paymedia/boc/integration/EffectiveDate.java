package com.paymedia.boc.integration;

import lombok.Getter;
import lombok.Setter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@Getter
@Setter
@XmlAccessorType(XmlAccessType.FIELD)
class EffectiveDate {

    @XmlElement(name = "Year")
    private int year;

    @XmlElement(name = "Month")
    private int month;

    @XmlElement(name = "Day")
    private int day;
}
