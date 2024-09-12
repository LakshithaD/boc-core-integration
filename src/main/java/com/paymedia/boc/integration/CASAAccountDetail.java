package com.paymedia.boc.integration;

import lombok.Getter;
import lombok.Setter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@Getter
@Setter
@XmlAccessorType(XmlAccessType.FIELD)
public class CASAAccountDetail implements ComAccountDetail{

    @XmlElement(name = "AcctId")
    private String acctId;

    @XmlElement(name = "AcctType")
    private String acctType;
}
