package com.paymedia.boc.integration;

import lombok.Getter;
import lombok.Setter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@Getter
@Setter
@XmlAccessorType(XmlAccessType.FIELD)
class XferInfo {

    @XmlElement(name = "GlAcctIdFrom")
    private GlAcctDetail glAcctIdFrom;

    @XmlElement(name = "GlAcctIdTo")
    private GlAcctDetail glAcctIdTo;

    @XmlElement(name = "DepAcctIdFrom")
    private CASAAccountDetail casaAcctIdFrom;

    @XmlElement(name = "DepAcctIdTo")
    private CASAAccountDetail casaAcctIdTo;

    @XmlElement(name = "CurAmt")
    private CurAmt curAmt;

    @XmlElement(name = "TranDesc1")
    private String tranDesc1;

    @XmlElement(name = "TranDesc2")
    private String tranDesc2;
    @XmlElement(name = "TranDesc3")
    private String tranDesc3;
    @XmlElement(name = "TranDesc4")
    private String tranDesc4;
    @XmlElement(name = "TranDesc5")
    private String tranDesc5;

    @XmlElement(name = "TranDesc6")
    private String tranDesc6;
    @XmlElement(name = "Fee1Amt")
    private FeeAmt fee1Amt;
    @XmlElement(name = "ToAmt")
    private ToAmt toAmt;

    @XmlElement(name = "ToTxnAmtLCE")
    private ToTxnAmtLCE toTxnAmtLCE;
}
