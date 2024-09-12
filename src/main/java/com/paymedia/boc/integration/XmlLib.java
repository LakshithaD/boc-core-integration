package com.paymedia.boc.integration;

import com.paymedia.boc.controller.AccountDetail;
import com.paymedia.boc.controller.AccountType;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.StringWriter;
import java.math.BigDecimal;

@Component
public class XmlLib {

    @Value("${boc.login.id}")
    private String loginId;

    @Value("${boc.password}")
    private String password;

    public String buildBocCoreXmlString(AccountDetail fromAcct, AccountDetail toAcct, BigDecimal amount) {
        try {

            IFX ifx = buildBocCoreXmlObject(fromAcct, toAcct, amount);
            JAXBContext jaxbContext = JAXBContext.newInstance(IFX.class);
            Marshaller marshaller = jaxbContext.createMarshaller();

            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            marshaller.setProperty(Marshaller.JAXB_FRAGMENT, Boolean.TRUE);
            // Write the XML to a StringWriter
            StringWriter sw = new StringWriter();
            marshaller.marshal(ifx, sw);

            // Get the XML as a string
            String xmlString = sw.toString();
            return xmlString;
        } catch (JAXBException ex) {
            ex.printStackTrace();
            throw new RuntimeException("Error generating core bank xml");
        }
    }
    IFX buildBocCoreXmlObject(AccountDetail fromAcct, AccountDetail toAcct, BigDecimal amount) {

        // Create the Java object (IFX in this case)
        IFX ifx = new IFX();

        // Set up the data as needed...
            SignonRq signonRq = new SignonRq();
            signonRq.setComputerId("SGPVMAPRDEV03");
            // Set other fields...
            SignonPswd signonPswd = new SignonPswd();
            signonPswd.setSignonRole("CSR");

                CustId custId = new CustId();
                custId.setSpName("FiservICBS");
                custId.setCustLoginId(loginId);
                signonPswd.setCustId(custId);

                CustPswd custPswd = new CustPswd();
                custPswd.setCryptType("NONE");
                custPswd.setPswd(password);
                signonPswd.setCustPswd(custPswd);

            signonPswd.setGenSessKey(0);
            signonRq.setSignonPswd(signonPswd);

            ClientDt clientDt = new ClientDt();
            clientDt.setYear(2024);
            clientDt.setMonth(9);
            clientDt.setDay(6);
            signonRq.setClientDt(clientDt);

            ClientApp clientApp = new ClientApp();
            clientApp.setOrg("Fiserv");
            clientApp.setName("CEFT");
            clientApp.setVersion("0.1");
            clientApp.setClientAppKey("BOCSRVRHECGNSYSQCUWRJDHKRFDBNTGN");
            signonRq.setClientApp(clientApp);

            signonRq.setComputerId("SGPVMAPRDEV03");
            signonRq.setInstitutionCode("BOCSR");

            ifx.setSignonRq(signonRq);
            //---------------------------- signonRq ----------------------------
            //
            EnvironmentInfo environmentInfo = new EnvironmentInfo();
            environmentInfo.setEnvironmentName("default");
            ifx.setEnvironmentInfo(environmentInfo);

            //------------------------ MonSvcRq --------------------------------
            MonSvcRq monSvcRq = new MonSvcRq();
            monSvcRq.setRqUID("020842f8-ade0-4fd3-8b97-a806be2d3dec");
            monSvcRq.setSpName("FiservICBS");

            //---------------------- PSAppXferAddRq -----------------
                PSAppXferAddRq psAppXferAddRq = new PSAppXferAddRq();
                psAppXferAddRq.setRqUID("020842f8-ade0-4fd3-8b97-a806be2d3dec");

                    TrnCommon trnCommon = new TrnCommon();
                        EffectiveDate effectiveDate = new EffectiveDate();
                        effectiveDate.setYear(2024);
                        effectiveDate.setMonth(9);
                        effectiveDate.setDay(6);
                        trnCommon.setEffectiveDate(effectiveDate);
                    trnCommon.setSeqId("90918");
                    trnCommon.setBranchId("997");
                    trnCommon.setTellerId("6666");
                    trnCommon.setOverrideCode("T");
                    trnCommon.setTrnCode(buildTransactionCode(fromAcct.getAcctType(), toAcct.getAcctType()));
                psAppXferAddRq.setTrnCommon(trnCommon);

                XferInfo xferInfo = new XferInfo();
                    xferInfo.setGlAcctIdFrom(fromAcct.getAcctType() == AccountType.GL ? buildGlAcctDetail(fromAcct): null);
                    xferInfo.setCasaAcctIdFrom(fromAcct.getAcctType() != AccountType.GL ? buildCasaAcctDetail(fromAcct): null);
                    xferInfo.setGlAcctIdTo(fromAcct.getAcctType() == AccountType.GL ? buildGlAcctDetail(toAcct): null);
                    xferInfo.setCasaAcctIdTo(fromAcct.getAcctType() != AccountType.GL ? buildCasaAcctDetail(fromAcct): null);

                    CurAmt curAmt = new CurAmt();
                    curAmt.setAmt(amount.toString());
                    curAmt.setCurCode("LKR");
                    xferInfo.setCurAmt(curAmt);
                    xferInfo.setTranDesc1("FT-LFMLP23134500 ");
                    xferInfo.setTranDesc2("FT-7255885668410170760906073926");
                    xferInfo.setTranDesc3("FT5885473558689746_5431216");
                    xferInfo.setTranDesc4("FT-LFMLP23134500 ");
                    xferInfo.setTranDesc5("7255885668410170760906073926");
                    xferInfo.setTranDesc6("FT5885473558689746_5431216");

                    FeeAmt fee1Amt = new FeeAmt();
                    fee1Amt.setAmt(30.00);
                    xferInfo.setFee1Amt(fee1Amt);

                    ToAmt toAmt = new ToAmt();
                    toAmt.setAmt(14630.00);
                    curAmt.setCurCode("LKR");
                    xferInfo.setToAmt(toAmt);

                    ToTxnAmtLCE toTxnAmtLCE = new ToTxnAmtLCE();
                    toTxnAmtLCE.setAmt(14630.00);
                    xferInfo.setToTxnAmtLCE(toTxnAmtLCE);

                psAppXferAddRq.setXferInfo(xferInfo);
            monSvcRq.setPsAppXferAddRq(psAppXferAddRq);
            ifx.setMonSvcRq(monSvcRq);
            //
            // Create JAXB context and marshaller

            return ifx;
    }

    /**
     * Description                Trancode
     *
     * Current to GL              55CG
     * Savings to GL              55SG
     * GL to GL                   55GG
     * GL to Savings              55GS
     * GL to Current              55GC
     * @return
     */
    String buildTransactionCode(AccountType fromAcctType, AccountType toAcctType) {

        StringBuilder tranCodeBuilder = new StringBuilder("55");
        switch (fromAcctType) {
            case CURRENT -> tranCodeBuilder.append("C");
            case SAVING -> tranCodeBuilder.append("S");
            case GL -> tranCodeBuilder.append("G");
        }
        switch (toAcctType) {
            case CURRENT -> tranCodeBuilder.append("C");
            case SAVING -> tranCodeBuilder.append("S");
            case GL -> tranCodeBuilder.append("G");
        }
        return tranCodeBuilder.toString();
    }

    GlAcctDetail buildGlAcctDetail(AccountDetail accountDetail) {

        GlAcctDetail glAcctDetail = new GlAcctDetail();
        glAcctDetail.setAcctType("GL");
        glAcctDetail.setAcctId(accountDetail.getAcctId());
        glAcctDetail.setCostCenter(accountDetail.getCostCenter());
        return glAcctDetail;
    }

    CASAAccountDetail buildCasaAcctDetail(AccountDetail accountDetail) {

        CASAAccountDetail casaAccountDetail = new CASAAccountDetail();
        casaAccountDetail.setAcctId(accountDetail.getAcctId());
        casaAccountDetail.setAcctType("SV");
        return casaAccountDetail;
    }
}
