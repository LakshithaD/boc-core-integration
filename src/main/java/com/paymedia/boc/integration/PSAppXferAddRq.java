package com.paymedia.boc.integration;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@Data
@XmlAccessorType(XmlAccessType.FIELD)
public class PSAppXferAddRq {
    @XmlElement(name = "RqUID")
    private String rqUID;

    @XmlElement(name = "TrnCommon")
    private TrnCommon trnCommon;

    @XmlElement(name = "XferInfo")
    private XferInfo xferInfo;
}

