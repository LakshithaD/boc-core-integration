package com.paymedia.boc.integration;

import lombok.Getter;
import lombok.Setter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@Getter
@Setter
@XmlAccessorType(XmlAccessType.FIELD)
class TrnCommon {

    @XmlElement(name = "EffectiveDate")
    private EffectiveDate effectiveDate;

    @XmlElement(name = "SeqId")
    private String seqId;

    @XmlElement(name = "BranchId")
    private String branchId;

    @XmlElement(name = "TellerId")
    private String tellerId;

    @XmlElement(name = "OverrideCode")
    private String overrideCode;

    @XmlElement(name = "TrnCode")
    private String trnCode;
}
