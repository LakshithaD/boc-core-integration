package com.paymedia.boc.integration;

import lombok.Getter;
import lombok.Setter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@Getter
@Setter
@XmlAccessorType(XmlAccessType.FIELD)
class CurAmt {

    @XmlElement(name = "Amt")
    private String amt;

    @XmlElement(name = "CurCode")
    private String curCode;
}
