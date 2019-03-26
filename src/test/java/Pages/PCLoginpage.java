package Pages;

import Base.BaseUtil;
import org.openqa.selenium.support.ui.Select;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import javax.xml.ws.Service;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;


public class PCLoginpage extends BaseUtil {

    public PCLoginpage(BaseUtil base) {
        this.base = base;
    }

    private BaseUtil base;

    //Login Page
    @FindBy(how = How.ID, using = "email")
    public WebElement txtEmail;
    @FindBy(how = How.ID, using = "password")
    public WebElement txtPassword;
    @FindBy(how = How.ID, using = "submit")
    public WebElement btnSignIn;
    @FindBy(how = How.ID, using = "companyStartId")  //Select Company // //*[@id="companyStartId"]
    public WebElement selCompany;
    @FindBy(how = How.XPATH, using = "//*[@id=\"serviceStartId\"]")  //Select service //
    public WebElement selService;
    @FindBy(how = How.XPATH, using = "//*[@id='startPageContainer']/div[2]/a")  //selecting usi client//*[@id="startPageContainer"]/div[1]/a
    public WebElement clickClient;
    @FindBy(how = How.CSS, using = "#index > img")   //Patracorp logo
    public WebElement logo;
    @FindBy(how = How.ID, using = "changecompany")   //Change client dropdown
    public WebElement changeClient;
    @FindBy(how = How.CSS, using = "body > div.jconfirm.jconfirm-light.jconfirm-open > div.jconfirm-scrollpane > div > div > div > div > div > div > div > div.jconfirm-buttons > button:nth-child(1)")
    public WebElement changeClientConfirmBtn;

    public PCLoginpage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void Login(String Email, String Password) {
        txtEmail.sendKeys(Email);
        txtPassword.sendKeys(Password);
    }

    //CLick on Sign-in Button
    public void SignInButton() {
        btnSignIn.click();
    }

    @FindBy(how = How.XPATH, using = "/html/body/div[1]/div/div/div/div/a[2]/div/div[2]")
    public WebElement link;


    public void policyCheckingLink() {
        link.click();
    }

    public void pickClient(String Company) {
        /*selCompany.sendKeys(Company);*/
        Select se = new Select(selCompany);
        se.selectByVisibleText(Company);
        /*selService.sendKeys(Service);*/
    }

    public void changeComp(String Company) {
        changeClient.click();
        changeClient.sendKeys(Company);
        changeClient.click();
    }

    public void changecomppopup() {
        changeClientConfirmBtn.click();
    }

    public void gotoClient() {
        clickClient.click();
    }

    /*   ------Size of table and pagination*/
    @FindBy(how = How.XPATH, using = "//*[@id=\"dtopenpolicies\"]")
    public WebElement pagination;
    @FindBy(how = How.XPATH, using = "//*[@id=\"dtopenpolicies_length\"]/label/select")
    public WebElement pValue;


    public void pagin(String Pagevalue) {
        pValue.sendKeys(Pagevalue);
    }

    public void pagin1() {
        List<WebElement> TotalRowsList = pagination.findElements(By.tagName("tr"));
        System.out.println("Total no of rows in table:" + (TotalRowsList.size() - 1));
    }

    /*   ------Get Row colors text*/

    @FindBy(how = How.XPATH, using = "//*[@id=\"tabopenpolicies\"]/div/div[1]/div/span[2]/div")
    public WebElement rowWhite;
    @FindBy(how = How.XPATH, using = "//*[@id=\"tabopenpolicies\"]/div/div[1]/div/span[3]/div")
    public WebElement rowYellow;
    @FindBy(how = How.XPATH, using = "//*[@id=\"tabopenpolicies\"]/div/div[1]/div/span[4]/div")
    public WebElement rowGreen;
    @FindBy(how = How.XPATH, using = "//*[@id=\"tabopenpolicies\"]/div/div[1]/div/span[5]/div")
    public WebElement rowLightGreen;
    @FindBy(how = How.XPATH, using = "//*[@id=\"tabopenpolicies\"]/div/div[1]/div/span[6]/div")
    public WebElement rowPink;
    @FindBy(how = How.XPATH, using = "//*[@id=\"tabopenpolicies\"]/div/div[1]/div/span[7]/div")
    public WebElement rowRed;
    @FindBy(how = How.XPATH, using = "//*[@id=\"tabopenpolicies\"]/div/div[1]/div/span[8]/div")
    public WebElement rowBlue;

    public void rowColorsText() {

        String value1 = rowWhite.getAttribute("title");
        System.out.println("Row White Text is :" + value1);
        String value2 = rowYellow.getAttribute("title");
        System.out.println("Row Yellow Text is :" + value2);
        String value3 = rowGreen.getAttribute("title");
        System.out.println("Row Green Text is :" + value3);
        String value4 = rowLightGreen.getAttribute("title");
        System.out.println("Row Light Green Text is :" + value4);
        String value5 = rowPink.getAttribute("title");
        System.out.println("Row Pink Text is :" + value5);
        String value6 = rowRed.getAttribute("title");
        System.out.println("Row Red Text is :" + value6);
        String value7 = rowBlue.getAttribute("title");
        System.out.println("Row BlueText is :" + value7);
    }

    /*   ------Get Values for KPI*/
    @FindBy(how = How.XPATH, using = "//*[@id=\"kpi1Count\"]")
    public WebElement policiesToCheckKpiValue;
    @FindBy(how = How.XPATH, using = "//*[@id=\"kpi2Count\"]")
    public WebElement ChecklistProcessingKpiValue;
    @FindBy(how = How.XPATH, using = "//*[@id=\"kpi3\"]")
    public WebElement QAKpiValue;
    @FindBy(how = How.XPATH, using = "//*[@id=\"kpi4Count\"]")
    public WebElement DeliveryKpiValue;
    @FindBy(how = How.XPATH, using = "//*[@id=\"kpi5\"]/div[2]/div[1]")
    public WebElement PRKpiValue;
    @FindBy(how = How.XPATH, using = "//*[@id=\"kpi6\"]/div[2]/div[1]")
    public WebElement IRKpiValue;

    public void PoliciestocheckKPIvalue() {
        String PoliciesToCheckCount = policiesToCheckKpiValue.getText();
        System.out.println("Policies to check KPI Count is :" + PoliciesToCheckCount);
    }
    public void ChecklistKPIvalue() {
        String ChecklistProcessingCount = ChecklistProcessingKpiValue.getText();
        System.out.println("Checklist Processing KPI Count is :" + ChecklistProcessingCount);
    }
    public void QAKPIvalue() {
        String QAKPICount = QAKpiValue.getText();
        System.out.println("Quality Assurance KPI Count is :" + QAKPICount);
    }
    public void PolicyDeliveryKPIvalue() {
        String DeliveryKPICount = DeliveryKpiValue.getText();
        System.out.println("Policy Delivery KPI Count is :" + DeliveryKPICount);
    }
    public void PendingKPIvalue() {
        String PRKPICount = PRKpiValue.getText();
        System.out.println("Pending Response KPI Count is :" + PRKPICount);
    }
    public void IncRespKPIvalue() {
        String IRKPICount = IRKpiValue.getText();
        System.out.println("Incoming Responses KPI Total Count is :" + IRKPICount);
    }

    //Click on Add Policy Button---------------------
    @FindBy(how = How.ID, using = "cert_addWOrkOrder")   //Add WO
    public WebElement clickAddPolicy;

    public void clickAddPolicy() {
        clickAddPolicy.click();
    }

    //Initializing elements in Add Policy--------------------------------------------
    @FindBy(how = How.ID, using = "pc_SentTo")
    public WebElement addPolicySentTo;
    @FindBy(how = How.ID, using = "pc_Summary")
    public WebElement addPolicySummary;
    @FindBy(how = How.ID, using = "pc_Requestor")
    public WebElement addPolicyRequestor;
    @FindBy(how = How.ID, using = "pc_Folder")
    public WebElement addFolder;

    public void addPolicyButton(String folder,String addRequestor, String addSummary, String addSentTo) {
        addFolder.sendKeys(folder);
        addPolicyRequestor.sendKeys(addRequestor);
        addPolicySummary.sendKeys(addSummary);
        addPolicySentTo.sendKeys(addSentTo);
    }

    //Entering into WO Entry section
    @FindBy(how = How.ID, using = "workOrderEntry_sect")
    public WebElement clickWoEntrySection;

    public void woDetailSection() {
        clickWoEntrySection.click();
    }

    //Entering details into WO Entry section
    @FindBy(how = How.ID, using = "pc_ClientCode")
    public WebElement clientCode1;
    @FindBy(how = How.ID, using = "pc_ClientName")
    public WebElement clientName1;
    @FindBy(how = How.ID, using = "pc_PolicyType")
    public WebElement policyType1;
    @FindBy(how = How.ID, using = "pc_LinesOfCoverage")
    public WebElement linesOfCoverage1;
    @FindBy(how = How.ID, using = "pc_csr")
    public WebElement csr1;
    @FindBy(how = How.ID, using = "pc_PolicyStatus")
    public WebElement policyStatus1;
    @FindBy(how = How.ID, using = "pc_CarrierName")
    public WebElement carrierName1;
    @FindBy(how = How.ID, using = "pc_amid")
    public WebElement am1;
    @FindBy(how = How.ID, using = "pc_PolicyDetails")
    public WebElement policyDetails1;
    @FindBy(how = How.XPATH, using = "//*[contains(text(),'Full Forms Check')]")
    public WebElement fullForms1;
    @FindBy(how = How.XPATH, using = "//*[contains(text(),'Policy Forms')]")
    public WebElement policyForms1;
    @FindBy(how = How.XPATH, using = "//*[contains(text(),'Donut Account')]")
    public WebElement donutAccount1;
    /*@FindBy(how = How.XPATH, using = "//*[contains(text(),'Book')]")
    public WebElement bookMarked1;*/
    @FindBy(how = How.ID, using = "pc_NumberOf")
    public WebElement noOf1;
    @FindBy(how = How.XPATH, using = "//*[contains(text(),'Documents Retrieved')]")
    public WebElement documentsRetrieved1;
    @FindBy(how = How.ID, using = "pc_NumberOfDocumentsRetrieved")
    public WebElement noOfDocumentsRetrieved1;
    @FindBy(how = How.ID, using = "pc_PolicyNumber")
    public WebElement policyNumber1;
    @FindBy(how = How.ID, using = "pc_EffectiveDate")
    public WebElement effectiveDate1;
    @FindBy(how = How.ID, using = "pc_BranchID")
    public WebElement branchOffice1;
    @FindBy(how = How.ID, using = "pc_DepartmentID")
    public WebElement department1;
    @FindBy(how = How.ID, using = "pc_DivisionID")
    public WebElement division1;
    @FindBy(how = How.ID, using = "pc_ProfitCenterID")
    public WebElement profitCenter1;
    @FindBy(how = How.ID, using = "pc_PolicyCheckedBy")
    public WebElement policyCheckedBy1;
    @FindBy(how = How.ID, using = "PC_QADoneBy")
    public WebElement qaBy1;
    @FindBy(how = How.ID, using = "pc_DeliveryBy")
    public WebElement deliveryBy1;
    @FindBy(how = How.ID, using = "pc_SecondQaDoneBy")
    public WebElement secondQa1;
    @FindBy(how = How.ID, using = "pc_CheckDocument2")
    public WebElement secondCheckDocument1;
    @FindBy(how = How.ID, using = "pc_CheckDocument3")
    public WebElement thirdCheckDocument1;
    @FindBy(how = How.XPATH, using = "//*[contains(text(),'Discrepancies Updated')]")
    public WebElement discrepanciesUpdated1;
    @FindBy(how = How.XPATH, using = "//*[contains(text(),'Sagitta Updated')]")
    public WebElement sagittaUpdated1;
    @FindBy(how = How.XPATH, using = "//*[contains(text(),'EPIC Updated To Match Policy')]")
    public WebElement epicUpdated1;
    @FindBy(how = How.XPATH, using = "//*[contains(text(),'AMS 360 Updated to match Policy')]")
    public WebElement amsUpdated1;
    @FindBy(how = How.XPATH, using = "//*[contains(text(),'Automatic Download')]")
    public WebElement automaticDownload1;
    @FindBy(how = How.XPATH, using = "//*[contains(text(),'Sagitta Download')]")
    public WebElement sagittaDownload1;
    @FindBy(how = How.ID, using = "pc_PolicyCheckedAgainstID")
    public WebElement policyCheckedAgainst1;
    @FindBy(how = How.ID, using = "pc_NumberOfAISupplementalNames")
    public WebElement noOfAI1;
    @FindBy(how = How.ID, using = "pc_NumberOfCoverages")
    public WebElement noOfCoverages1;
    @FindBy(how = How.ID, using = "pc_NumberOfDocuments")
    public WebElement noOfDocuments1;
    @FindBy(how = How.ID, using = "pc_NumberOfEndorsements")
    public WebElement noOfEndorsements1;
    @FindBy(how = How.ID, using = "pc_NumberOfHazards")
    public WebElement noOfHazards1;
    @FindBy(how = How.ID, using = "pc_NumberOfIMItems")
    public WebElement noOfIMItems1;
    @FindBy(how = How.ID, using = "pc_NumberOfLocations")
    public WebElement noOfLocations1;
    @FindBy(how = How.ID, using = "pc_NumberOfVehicles")
    public WebElement noOfVehicles1;
    @FindBy(how = How.ID, using = "pc_RequestFor")
    public WebElement requestFor1;
    @FindBy(how = How.ID, using = "pc_BillingType")
    public WebElement billingType1;
    @FindBy(how = How.ID, using = "complexity_type")
    public WebElement complexityType1;
    @FindBy(how = How.XPATH, using = "//*[contains(text(),'Company Bill Premium Updated')]")
    public WebElement companyBillPremiumUpdated1;
    @FindBy(how = How.XPATH, using = "//*[contains(text(),'CA Express Policy')]")
    public WebElement cAExpressPolicy1;
    @FindBy(how = How.XPATH, using = "//*[contains(text(),'Special Accounts')]")
    public WebElement specialAccounts1;
    @FindBy(how = How.XPATH, using = "//*[contains(text(),'VIN Verification')]")
    public WebElement vINVerification1;
    @FindBy(how = How.XPATH, using = "//*[contains(text(),'USPS Verification')]")
    public WebElement uSPSVerification1;
    @FindBy(how = How.XPATH, using = "//*[contains(text(),'Other PKG')]")
    public WebElement otherPKG1;
    @FindBy(how = How.XPATH, using = "//*[contains(text(),'All Other')]")
    public WebElement allOther1;
    /*@FindBy(how = How.XPATH, using = "//*[contains(text(),'BOP's/PKG')]")
    public WebElement bop1;*/
    @FindBy(how = How.XPATH, using = "//*[contains(text(),'Billing Screen Updated')]")
    public WebElement billingScreenUpdated1;
   /* @FindBy(how = How.XPATH, using = "//*[contains(text(),'Management Coverages In PKG')]")
    public WebElement managementCoveragesInPKG1;*/
    @FindBy(how = How.XPATH, using = "//*[contains(text(),'AGCS Insurance Company')]")
    public WebElement aGCSInsuranceCompany1;
    @FindBy(how = How.XPATH, using = "//*[contains(text(),'Policy Filed')]")
    public WebElement policyFiled1;
    @FindBy(how = How.XPATH, using = "//*[contains(text(),'Email Sent To AM')]")
    public WebElement emailSentAM1;
    @FindBy(how = How.XPATH, using = "//*[contains(text(),'Email Attached')]")
    public WebElement emailAttached1;
    @FindBy(how = How.XPATH, using = "//*[contains(text(),'Checklist Attached')]")
    public WebElement checklistAttached1;
    @FindBy(how = How.XPATH, using = "//*[contains(text(),'Activity Created')]")
    public WebElement activityCreated1;
    @FindBy(how = How.XPATH, using = "//*[contains(text(),'Policy Delivered to the Insured?')]")
    public WebElement policyDelivered1;
    @FindBy(how = How.XPATH, using = "//*[contains(text(),'Policy Attached To Email')]")
    public WebElement policyAttachedToEmail1;
    @FindBy(how = How.XPATH, using = "//*[contains(text(),'Website Updated')]")
    public WebElement websiteUpdated1;
    @FindBy(how = How.XPATH, using = "//*[contains(text(),'Form Letter Attached')]")
    public WebElement letterAttached1;
    @FindBy(how = How.XPATH, using = "//*[contains(text(),'Rate Calculation Sheet Attached')]")
    public WebElement rateCalculationAttached1;
    @FindBy(how = How.ID, using = "pc_Comments")
    public WebElement comments1;

    /*Still need to insert few fields from WO details section*/

    public void woDetailSectionEntry(String clientCode, String clientName, String policyType, String linesOfCoverage, String csr,
                                     String policyStatus, String carrierName, String am, String policyDetails, String noOf,
                                     String noOfDocumentsRetrieved, String policyNumber, String effectiveDate, String branchOffice, String department,
                                     String division, String profitCenter, String policyCheckedBy, String qaBy, String deliveryBy,
                                     String secondQa, String secondCheckDocument, String thirdCheckDocument, String policyCheckedAgainst, String noOfAI, String noOfCoverages,
                                     String noOfDocuments, String noOfEndorsements, String noOfHazards, String noOfIMItems, String noOfLocations, String noOfVehicles,
                                     String requestFor, String billingType, String complexityType, String comments) {
        clientCode1.sendKeys(clientCode);
        clientName1.sendKeys(clientName);
        policyType1.sendKeys(policyType);
        linesOfCoverage1.sendKeys(linesOfCoverage);
        csr1.sendKeys(csr);
        policyStatus1.sendKeys(policyStatus);
        carrierName1.sendKeys(carrierName);
        am1.sendKeys(am);
        policyDetails1.sendKeys(policyDetails);
        fullForms1.click();
        policyForms1.click();
        donutAccount1.click();
        /*bookMarked1.click();*/
        noOf1.sendKeys(noOf);
        documentsRetrieved1.click();
        noOfDocumentsRetrieved1.sendKeys(noOfDocumentsRetrieved);
        policyNumber1.sendKeys(policyNumber);
        effectiveDate1.sendKeys(effectiveDate);
        branchOffice1.sendKeys(branchOffice);
        department1.sendKeys(department);
        division1.sendKeys(division);
        profitCenter1.sendKeys(profitCenter);
        policyCheckedBy1.sendKeys(policyCheckedBy);
        qaBy1.sendKeys(qaBy);
        deliveryBy1.sendKeys(deliveryBy);
        secondQa1.sendKeys(secondQa);
        secondCheckDocument1.sendKeys(secondCheckDocument);
        thirdCheckDocument1.sendKeys(thirdCheckDocument);
        discrepanciesUpdated1.click();
        sagittaUpdated1.click();
        epicUpdated1.click();
        amsUpdated1.click();
        automaticDownload1.click();
        sagittaDownload1.click();
        policyCheckedAgainst1.sendKeys(policyCheckedAgainst);
        noOfAI1.sendKeys(noOfAI);
        noOfCoverages1.sendKeys(noOfCoverages);
        noOfDocuments1.sendKeys(noOfDocuments);
        noOfEndorsements1.sendKeys(noOfEndorsements);
        noOfHazards1.sendKeys(noOfHazards);
        noOfIMItems1.sendKeys(noOfIMItems);
        noOfLocations1.sendKeys(noOfLocations);
        noOfVehicles1.sendKeys(noOfVehicles);
        requestFor1.sendKeys(requestFor);
        billingType1.sendKeys(billingType);
        complexityType1.sendKeys(complexityType);
        companyBillPremiumUpdated1.click();
        cAExpressPolicy1.click();
        specialAccounts1.click();
        vINVerification1.click();
        uSPSVerification1.click();
        otherPKG1.click();
        allOther1.click();
     /*   bop1.click();*/
        billingScreenUpdated1.click();
        /*managementCoveragesInPKG1.click();*/
        aGCSInsuranceCompany1.click();
        policyFiled1.click();
        emailSentAM1.click();
        emailAttached1.click();
        checklistAttached1.click();
        activityCreated1.click();
        policyDelivered1.click();
        policyAttachedToEmail1.click();
        websiteUpdated1.click();
        letterAttached1.click();
        rateCalculationAttached1.click();
        comments1.sendKeys(comments);
    }

    @FindBy(how = How.ID, using = "OriginalEmail_sect")      //Entering into Original email section
    public WebElement originalEmail;

    public void originalEmail() {
        originalEmail.click();
    }

    //Entering text in description part of Original Email
    @FindBy(how = How.ID, using = "pc_Description")
    public WebElement descriptionOfOriginalEmail;

    public void descriptionOfOriginalEmail(String originalEmail)

    {
        descriptionOfOriginalEmail.sendKeys(originalEmail);
    }

    //Entering into QA section
    @FindBy(how = How.ID, using = "QA_sect")
    public WebElement clickQA;

    //Clicking on Second QA
    @FindBy(how = How.ID, using = "pc_auditQA")
    public WebElement qa1;
    //Entering details into QA section
    @FindBy(how = How.ID, using = "pc_No_Errors")
    public WebElement noOfErrors1;
    @FindBy(how = How.ID, using = "pc_error_made_by")
    public WebElement errorMadeBy1;
    @FindBy(how = How.ID, using = "pc_error_type")
    public WebElement errorType1;
    @FindBy(how = How.ID, using = "pc_error_filed_by")
    public WebElement errorFiledBy1;
    @FindBy(how = How.ID, using = "pc_error_description")
    public WebElement errorDescription1;

    public void qaDetailSectionEntry(String qa, String noOfErrors, String errorMadeBy, String errorType, String errorFiledBy, String errorDescription) {
        try {
            clickQA.click();
            Thread.sleep(10000);
        } catch (Exception e) {

        }
        qa1.sendKeys(qa);
        noOfErrors1.sendKeys(noOfErrors);
        errorMadeBy1.sendKeys(errorMadeBy);
        errorType1.sendKeys(errorType);
        errorFiledBy1.sendKeys(errorFiledBy);
        errorDescription1.sendKeys(errorDescription);
    }

    @FindBy(how = How.ID, using = "workOrder_submit")    //Clicking on Submit Button
    public WebElement addPolicySubmitBtn;

    public void addPolicySubmitButton() {
        addPolicySubmitBtn.click();
        //  addPolicyCancelBtn.click();
    }
    //Getting WO value from pop-up
    @FindBy(how = How.ID, using = "WorkOrder_Dynamic")
    public WebElement wo;
    @FindBy(how = How.ID, using = "WorkOrderPolicyCheckingNumberProcess")
    public WebElement woNumTxtBox;

    public void woValue()
    {
        String Tx = wo.getText();
        System.out.println("WO number is :" +Tx);
        /*clickClosePopup.click();*/
        try
        {
            Thread.sleep(10000);
            System.out.println("Enter value");
            woNumTxtBox.sendKeys(Tx);
        }
        catch (Exception e)  { }
    }

    //Clicking on Close Button for pop-up
    @FindBy(how = How.CSS, using = "body > div.jconfirm.jconfirm-light.jconfirm-open > div.jconfirm-scrollpane > div > div > div > div > div > div > div > div.jconfirm-buttons > button")
    public WebElement clickClosePopup;

    public void clickClosePopup() {
        clickClosePopup.click();
    }

    //Intitializing elements in Processing tab
    @FindBy(how = How.ID, using = "WorkOrderNumberProcess")   //WO search box
    public WebElement woSearch;
    @FindBy(how = How.ID, using = "ClientCodeProcess")   //Client code search box
    public WebElement clientCodeSearch;
    @FindBy(how = How.ID, using = "SummaryProcess")   //Summary search box
    public WebElement summarySearch;

 /*   public void WorkOrderSearch(String wonumsearch, String clientcode, String summary) {
        try {
            Thread.sleep(2000);
            woSearch.sendKeys(wonumsearch);
            Thread.sleep(3000);
            clientCodeSearch.sendKeys(clientcode);
            summarySearch.sendKeys(summary);
        } catch (Exception e) {
        }
    }*/

    @FindBy(how = How.CSS, using = "#dtopenpolicies > tbody > tr > td:nth-child(1) > a")
    public WebElement WONum;

    public void SelWO() {
        WONum.click();
    }

    //Clicking on Mark Rush/Mark Bulk Button
    @FindBy(how = How.XPATH, using = "//*[@id=\"liststyle\"]/div[2]/div[9]")  //Mark Rush button
    public WebElement btnMarkRush;

    public void markRush() {
        btnMarkRush.click();
    }

    //Assign
    @FindBy(how = How.ID, using = "pc_ProcessID")  //process dropdown
    public WebElement ProcProcess;
    @FindBy(how = How.ID, using = "work_entry_submit")  //Submit buttons
    public WebElement submit;
    @FindBy(how = How.ID, using = "cert_AssgnTo")  //Assigned To text box
    public WebElement ProcAssignedto;
    @FindBy(how = How.ID, using = "cert_isRush")  //Rush check box
    public WebElement ProcRush;
    @FindBy(how = How.ID, using = "cert_isBulk")  //Bulk check box
    public WebElement ProcBulk;
    @FindBy(how = How.ID, using = "cert_FromPending")  //From Pending check box
    public WebElement ProcFrompending;
    @FindBy(how = How.ID, using = "cert_IsUpdate")  //Update check box
    public WebElement ProcUpdate;
    @FindBy(how = How.CSS, using = "#liststyle > div.col-md-5.col-sm-12.col-xs-12 > div:nth-child(1) > label.btn.btn-primary.label1")
    //Assign check box
    public WebElement ProcAssign;
    @FindBy(how = How.CSS, using = "#liststyle > div.col-md-5.col-sm-12.col-xs-12 > div:nth-child(3) > label.btn.btn-primary.label1")
    //Email check box
    public WebElement ProcEmail;
    @FindBy(how = How.CSS, using = "#liststyle > div.col-md-5.col-sm-12.col-xs-12 > div:nth-child(2) > label.btn.btn-primary.label1")
    //Hold check box
    public WebElement ProcHold;
    //  @FindBy(how = How.CSS, using = "#liststyle > div.col-md-5.col-sm-12.col-xs-12 > div:nth-child(4) > label.btn.btn-primary.label1")  //Discard check box
    @FindBy(how = How.XPATH, using = "//*[@id='liststyle']/div[2]/div[5]/label/span")
    public WebElement ProcDiscard;
    //  @FindBy(how = How.CSS, using = "body > div.jconfirm.jconfirm-light.jconfirm-open > div.jconfirm-scrollpane > div > div > div > div > div > div > div > div.jconfirm-buttons > button")  //Discard check box
    @FindBy(how = How.XPATH, using = "/html/body/div[9]/div[2]/div/div/div/div/div/div/div/div[4]/button")
    public WebElement discardalert;
    @FindBy(how = How.XPATH, using = "/html/body/div[13]/div[2]/div/div/div/div/div/div/div/div[4]/button")
    public WebElement discardalert1;
    @FindBy(how = How.CSS, using = "#liststyle > div.col-md-5.col-sm-12.col-xs-12 > div:nth-child(5) > label.btn.btn-primary.label1")
    //Delivered check box
    public WebElement ProcDelivered;
    @FindBy(how = How.CSS, using = "#liststyle > div:nth-child(3) > div:nth-child(8) > label")
    public WebElement ProcTaskCompleted;
    @FindBy(how = How.ID, using = "pc_Status")  //Status combo box
    public WebElement ProcStatus;
    @FindBy(how = How.ID, using = "pc_Folder")  //Folder combo box
    public WebElement ProcFolder;
    @FindBy(how = How.ID, using = "pc_StartDateOverride")  //Start Date Override
    public WebElement ProcStartDateverride;
    @FindBy(how = How.CSS, using = "body > div.jconfirm.jconfirm-light.jconfirm-open > div.jconfirm-scrollpane > div > div > div > div > div > div > div > div.jconfirm-buttons > button")
    //Delievry Alert OK
    public WebElement btndeliveryalert;

   /* @FindBy(how = How.XPATH, using = "/html/body/div[6]/div[3]/table/tfoot/tr[1]/th") //Start Date Override calendar today
    public WebElement ProcStartDateverride;*/

    @FindBy(how = How.ID, using = "pc_DueDateOverride")  //Due Date Override
    public WebElement ProcDueDateverride;
    @FindBy(how = How.ID, using = "pc_HoldReason")  //Hold Reason
    public WebElement ProcHoldReason;
    @FindBy(how = How.ID, using = "pc_Assign_To")  //Assign To
    public WebElement ProcAssignTo;
    @FindBy(how = How.ID, using = "pc_Summary")  //Summary
    public WebElement ProcSummary;
    @FindBy(how = How.ID, using = "cert_Requestor")  //Requestor
    public WebElement ProcRequestor;
    @FindBy(how = How.ID, using = "pc_SentTo")  //Sent To
    public WebElement ProcSentto;
    @FindBy(how = How.ID, using = "work_entry_cancel")  //Cancel button
    public WebElement cancel;
    @FindBy(how = How.ID, using = "Original_Email_details")  //Original email
    public WebElement originalemail;
    //  @FindBy(how = How.XPATH, using = "//*[@id='work_entry_close']")  //Close button


    @FindBy(how = How.ID, using = "UploadFile1")  //Add Attachments button
    public WebElement choosefile1;
    @FindBy(how = How.NAME, using = "btnSave")  //Save attachment button
    public WebElement Attsave;
    @FindBy(how = How.CLASS_NAME, using = "stdformbotbutton")  //Cancel attachment button
    public WebElement Attcancel;

    public void Assign() {
        ProcProcess.click();
        ProcProcess.sendKeys("Policies to Check");
        submit.click();
    }

    @FindBy(how = How.ID, using = "sw_start")   //Start timer button
    public WebElement woStartTimer;
    @FindBy(how = How.ID, using = "sw_stop")   //Stop timer in header
    public WebElement hitstoptimer;

    public void woTimer() {
        woStartTimer.click();
    }

    public void stoptimer() { hitstoptimer.click(); }

    @FindBy(how = How.ID, using = "timer_task")   //Select Task
    public WebElement selTask;
    @FindBy(how = How.ID, using = "timer-Details-Submit")   //Start timer in pop-up
    public WebElement hitStartTimer;

    public void startTimer() {
        selTask.sendKeys("Certificate Issuance");
        hitStartTimer.click();
    }

    public void SelectProcessingWOform(String WO, String AssignedTo, String Rush, String FromPending, String Update, String Process, String IsAssigned, String ishold,
                                       String IsEmail, String IsDiscard, String IsDelivered, String IsTaskCompleted, String Status, String Folder, String StartDateOverride, String DueDateOvrride,
                                       String Holdreason, String Assignto, String Summary, String Requestor, String Sentto) {
        ProcProcess.sendKeys(Process);
        ProcStatus.sendKeys(Status);
        ProcFolder.sendKeys(Folder);
        ProcStartDateverride.sendKeys(StartDateOverride);
        ProcDueDateverride.sendKeys(DueDateOvrride);
        ProcSummary.sendKeys(Summary);
        submit.click();
        originalemail.click();
        //  ProcTaskCompleted.click();
         /*WONum.sendKeys(WO);
         ProcAssignedto.sendKeys(AssignedTo);
         ProcRush.sendKeys(Rush);
         ProcBulk.sendKeys(Bulk);
         ProcFrompending.sendKeys(FromPending);
         ProcUpdate.sendKeys(Update);
         ProcAssignTo.sendKeys(Assignto);
         ProcDelivered.click();
         ProcDelivered.sendKeys(IsDelivered);
         ProcTaskCompleted.sendKeys(IsTaskCompleted);
         ProcStatus.sendKeys(Status);
         ProcFolder.sendKeys(Folder);
         ProcStartDateverride.sendKeys(StartDateOverride);
         ProcDueDateverride.sendKeys(DueDateOvrride);
         ProcHoldReason.sendKeys(Holdreason);
         ProcAssignTo.sendKeys(Assignto);
         ProcRequestor.sendKeys(Requestor);
         ProcSentto.sendKeys(Sentto);
         submit.click();*/
    }

    @FindBy(how = How.ID, using = "attachments_sects")     //Attachments tab
    public WebElement attachments;
    public void Attachments() {
        attachments.click();
    }

    @FindBy(how = How.ID, using = "Email_sects")        //Emails tab
    public WebElement emails;
    public void Emails()
    {
        emails.click();
    }

    @FindBy(how = How.XPATH, using = "//*[@id='QA_sects']")       // QA tab
    public WebElement qa;
    public void QA() {
        qa.click();
    }

    @FindBy(how = How.XPATH, using = "//*[@id='history_sects']")       // History tab
    public WebElement history;
    public void History() {
        history.click();
    }

    @FindBy(how = How.XPATH, using = "//*[@id='timerecords_sects']")   //Time records tab
    public WebElement timerecords;
    public void TimeRecords() {
        timerecords.click();
    }

    @FindBy(how = How.CSS, using = "#Attachment_event")  //Add Attachments button
    public WebElement Proaddattachments;
    public void AddAttach() {
        Proaddattachments.click();   //Add Attachments
    }



    @FindBy(how = How.XPATH, using = "/html/body/div[4]/div/div/div/div/div[2]/ul/li[2]/button")   //Print PDF button
    public WebElement printpdf;

    public void printpdf() {

        printpdf.click();

    }
    @FindBy(how = How.ID, using = "work_entry_close")
    public WebElement CloseWO;

    public void clickcloseworkordertab()
    {
        CloseWO.click();
    }
    @FindBy(how = How.ID, using = "index2")
    public WebElement timerecordsgrid;
    public void TimeRecordsGrid() {
        timerecordsgrid.click();
    }
    @FindBy(how = How.CSS, using = "#index1")
    public WebElement workorderssgrid;
    public void WOgrid() {
        workorderssgrid.click();
    }

    @FindBy(how = How.CSS, using = "#kpi1Count")    //Clicking Policies to Check KPI
    public WebElement policiestocheckkpiclick;

    public void PoliciesToCheckKpi()  {
        try
        {
            policiestocheckkpiclick.click();
            Thread.sleep(8000);
            /* woNumTxtBox.sendKeys(Tx);*/
        }  catch(Exception e) {}
    }

    @FindBy(how = How.ID, using = "WorkOrderPolicyCheckingNumberProcess")   //WO search box
    public WebElement wosearch;
    @FindBy(how = How.ID, using = "ClientCodeProcess")   //Client code search box
    public WebElement clientcodesearch;
    @FindBy(how = How.ID, using = "SummaryProcess")   //Summary search box
    public WebElement summarysearch;

    public void WorkOrderSearch(String wonumsearch, String clientcode, String summary){
        try {
            Thread.sleep(2000);
            wosearch.sendKeys(wonumsearch);
            Thread.sleep(3000);
            clientcodesearch.sendKeys(clientcode);
            summarysearch.sendKeys(summary);
        } catch(Exception e){ }
    }
    public void wonumbersearch (String wonumber)
    {
        wosearch.sendKeys(wonumber);
    }

    @FindBy(how = How.CSS, using = "#dtopenpolicies > tbody > tr > td:nth-child(1) > a") //WO # from Certs KPI
    public WebElement selectworkorderclick;
    public void selectworkorder()
    {
        selectworkorderclick.click();
    }

    
    @FindBy(how = How.XPATH, using = "//*[@id=\"liststyle\"]/div[2]/div[4]/label")
    public WebElement clickEmail;

    @FindBy(how = How.XPATH, using = "//*[@id=\"liststyle\"]/div[2]/div[8]/label")
    public WebElement clickTaskCompleted;

    public void clickEmailTaskComp()
    {
        clickEmail.click();
        clickTaskCompleted.click();
    }
    public void EditWO() {
        try {
            ProcTaskCompleted.click();
            Thread.sleep(10000);
            submit.click();
        } catch (Exception e) {}
    }

    @FindBy(how = How.CSS, using = "kpi2")    //Clicking on checklist processing KPI
    public WebElement checklistprocessingkpiclick;

    public void checklistProcessingKpi() {
      try {
          checklistprocessingkpiclick.click();
          Thread.sleep(5000);
          } catch(Exception e) {}
    }
    public void AssignQA() {
        ProcProcess.click();
        ProcProcess.sendKeys("QA");
        submit.click();
    }

    @FindBy(how = How.ID, using = "kpi3")    //Clicking on QA KPI
    public WebElement qakpiclick;

    public void qakpi() {
      try {
            qakpiclick.click();
            Thread.sleep(5000);
        } catch(Exception e) {}
    }

    @FindBy(how = How.CSS, using = "#dtopenpolicies_wrapper > div:nth-child(1) > div:nth-child(2) > div > div.btn.btn-sm.red.btn-outline.search-clear")    //Clicking on Reset button
    public WebElement btnreset;
    public void ProcReset(){
        btnreset.click();
    }

    public void folderIR()  {
        ProcFolder.sendKeys("Incoming Responses");
    }

    public void folderPR()  {
        ProcFolder.sendKeys("Pending Responses");
    }

    @FindBy(how = How.CSS, using = "#dtopenpolicies > tbody > tr.odd > td:nth-child(1) > a") //WO #2060 from QA KPI
    public WebElement selQaWo;

    public void qaWo()    {
        selQaWo.click();
    }

    public void Submit() {
        try {
            Thread.sleep(15000);
            submit.click();
        } catch(Exception e) {}
    }
    @FindBy(how = How.ID, using = "kpi4")   //KPI Policy Delievry
    public WebElement PolicyDeliveryKPI;

    public void kpidelivery() {
        PolicyDeliveryKPI.click();
    }
    @FindBy(how = How.CSS, using = "#dtopenpolicies > tbody > tr:nth-child(1) > td:nth-child(1) > a")   //KPI Delievry wo#861326
    public WebElement kpiwonum;
    public void editkpidelrec() {
        kpiwonum.click();
    }
    public void AssignDelivery() {
        ProcProcess.click();
        ProcProcess.sendKeys("Delivery");
        ProcProcess.click();
    }
    public void deliveryalert() {
        btndeliveryalert.click();
    }
    @FindBy(how = How.ID, using = "kpi5") // pending responses KPI
    public WebElement pendingrespkpi;

    public void PendingRespKPI() {
        pendingrespkpi.click();
    }

    // Incoming Responses tab
    @FindBy(how = How.XPATH, using = "//*[@id=\"kpi6\"]/div[2]/div[2]")
    public WebElement IncomingResponsetab;
    @FindBy(how = How.ID, using = "WorkOrderPolicyCheckingNumberProcess")     //@FindBy(how = How.ID, using = "WorkOrderNumberIncoming")
    public WebElement IncomingResWOsearch;
    @FindBy(how = How.CSS, using = "#dtopenpolicies > tbody > tr > td:nth-child(1) > a")   //clicking WO incoming resp
    public WebElement woclick;

    public void IncomingResp() {
        IncomingResponsetab.click();
    }
    public void IncReswosearch(String IncResWO)   {
        IncomingResWOsearch.sendKeys(IncResWO);
    }
    public void IncResWOclick() {
        woclick.click();
    }

    @FindBy(how = How.ID, using = "pc_Summary")  // Requestor txtbox
    public WebElement txtDiscardedWOSummary;
    @FindBy(how = How.ID, using = "pc_Requestor")  // Requestor txtbox
    public WebElement txtDiscardedWORequestor;
    @FindBy(how = How.ID, using = "pc_SentTo")
    public WebElement txtDiscardedWOSentTo;
    public void UpdateDiscardedWODetails(String Summary, String Requestor, String SentTo) {
        txtDiscardedWOSummary.sendKeys(Summary);
        txtDiscardedWORequestor.clear();
        txtDiscardedWORequestor.sendKeys(Requestor);
        txtDiscardedWOSentTo.sendKeys(SentTo);
    }

    public void Discard() {
        ProcDiscard.click();
    }
    public void discardalert() {
        try {
            Thread.sleep(3000);
            discardalert.click();
            Thread.sleep(3000);
            submit.click();
        }catch (Exception e){}
    }

    public void discardalert1() {
        try {
            Thread.sleep(3000);
            discardalert1.click();
            Thread.sleep(3000);
            submit.click();
        }catch (Exception e){}
    }
    public void DiscardedWOSubmit()
    {
        submit.click();
    }

    //Completed tab module
    @FindBy(how = How.CSS, using = "#tabbtncompleted > a")
    public WebElement tpmcompletedtab;
    public void completedtab() {
        try {
            tpmcompletedtab.click();
            Thread.sleep(3000);
        } catch (Exception e) { }
    }

    @FindBy(how = How.XPATH, using = "//*[@id='typeaheadValue']") //Gloabl Search
    public WebElement txtGlobalSearch;
    public void GlobalSearch(String GlobalSearch)
    {
        txtGlobalSearch.sendKeys(GlobalSearch);
    }

    @FindBy(how = How.CSS, using = "#the-basics-new > span > div > div > p > a > strong") //Gloabl search link
    public WebElement linkGlobalSearchSelection;
    public void GlobalSearchLinkSelect()
    {
        linkGlobalSearchSelection.click();
    }
    // Discarded tab module
    @FindBy(how = How.CSS, using = "#tabbtndiscardedpolicies > a")    //Discarded tab fields #tabbtndiscardedpolicies > a
    public WebElement tabDiscarded;
    @FindBy(how = How.ID, using = "WorkOrderPolicyCheckingNumberDiscarded")  //disacrd WO search
    public WebElement discardwosearch;
    @FindBy(how = How.CSS, using = "#dtdiscardedpolicies > tbody > tr > td:nth-child(1) > a")  //usi 11309
    public WebElement linkdiscardedtabwo;
    public void SelectDiscardedTab()    //Selecting Discarded tab
    {
        tabDiscarded.click();
    }
    public void DiscardWOsearch(String DiscardWOSearch)
    {
        discardwosearch.sendKeys(DiscardWOSearch);
    }
    public void SelectDiscardedTabWO()   //Selecting work order from discarded tab
    {
        linkdiscardedtabwo.click();
    }
    @FindBy(how = How.ID, using = "index4")         // Reports tab
    public WebElement btnReports;

    public void ReportsButton()
    {
        btnReports.click();
    }
    // time record admin starts here
    @FindBy(how = How.CSS, using = "#index3")           // Time Record Admin page
    public WebElement tpmclickingtimerecordadmin;
    public void clickingtimerecordadmin() {
        tpmclickingtimerecordadmin.click();
    }
    @FindBy(how = How.ID, using = "startTimeFrom")   //Start Time From
    public WebElement StarttimeFrom;
    @FindBy(how = How.ID, using = "startTimeTo")   // Start Time To
    public WebElement StarttimeTo;
    @FindBy(how = How.ID, using = "btnRun")  //Run button
    public WebElement Runbtn;
    public void TRAStarttime(String From, String To) {
        StarttimeFrom.sendKeys(From);
        StarttimeTo.sendKeys(To);
        Runbtn.click();
    }
    @FindBy(how = How.CSS, using = "#th-CompanyNameTRA > span > div > button > span") //#th-CompanyNameTRA > ul > li:nth-child(2) > span > div > button > span
    public WebElement tpmtracompanysearchenteringusi;
    @FindBy(how = How.CSS, using = "#th-CompanyNameTRA > span > div > ul > li.multiselect-item.multiselect-filter > div > input") // #th-CompanyNameTRA > ul > li:nth-child(2) > span > div > ul > li.multiselect-item.multiselect-filter > div > input
    public WebElement tpmtraselectingtheusicompany;
    @FindBy(how = How.CSS, using = "#th-CompanyNameTRA > span > div > ul > li:nth-child(493) > a > label")  // #th-CompanyNameTRA > ul > li:nth-child(2) > span > div > ul > li:nth-child(436) > a > label > input[type="checkbox"]
    public WebElement tpmtraselectingusicompany;
    @FindBy(how = How.CSS, using = "#th-ServiceDescriptionTRA > span > div > button > span")  //#th-ServiceDescriptionTRA > ul > li:nth-child(2) > span > div > button
    public WebElement tpmtraserviceclicking;
    @FindBy(how = How.CSS, using = "#th-ServiceDescriptionTRA > span > div > ul > li.multiselect-item.multiselect-filter > div > input")  //#th-ServiceDescriptionTRA > ul > li:nth-child(2) > span > div > ul > li.multiselect-item.multiselect-filter > div > input
    public WebElement tpmtraservicecertissuance;
    @FindBy(how = How.CSS, using = "#th-ServiceDescriptionTRA > span > div > ul > li:nth-child(48) > a > label") //#th-ServiceDescriptionTRA > ul > li:nth-child(2) > span > div > ul > li:nth-child(47) > a > label > input[type="checkbox"]
    public WebElement tpmtraclickingtheserviceentered;
    @FindBy(how = How.CSS, using = "#th-TaskDescriptionTRA > span > div > button > span")  //#th-TaskDescriptionTRA > ul > li:nth-child(2) > span > div > button > span
    public WebElement tpmtrataskdescriptioncertissuance;
    @FindBy(how = How.CSS, using = "#th-TaskDescriptionTRA > span > div > ul > li.multiselect-item.multiselect-filter > div > input")  //#th-TaskDescriptionTRA > ul > li:nth-child(2) > span > div > ul > li.multiselect-item.multiselect-filter > div > input
    public WebElement tpmtrataskdescriptionentering;
    @FindBy(how = How.CSS, using = "#th-TaskDescriptionTRA > span > div > ul > li:nth-child(82) > a > label")  //#th-TaskDescriptionTRA > ul > li:nth-child(2) > span > div > ul > li:nth-child(84) > a > label > input[type="checkbox"]
    public WebElement tpmtraclickingthetaskdescriptionentered;
    @FindBy(how = How.CSS, using = "#dtTimeRecordAdmin_length > label > select")
    public WebElement tpmtraviewing;
    @FindBy(how = How.ID, using = "WorkOrderNumberTRA")  //WorkOrderNumberTRA
    public WebElement tpmtrworknumber;
    @FindBy(how = How.ID, using = "EmployeeUserNameTRA") //EmployeeUserNameTRA
    public WebElement tpmtremployee;
    @FindBy(how = How.ID, using = "from-DurationHoursTRA")
    public WebElement tpmtrhours;

    public void traselectingthecompany() {
        tpmtracompanysearchenteringusi.click();
    }
    public void traselectingtheusicompany(String trcompany)
    {
        tpmtraselectingtheusicompany.sendKeys(trcompany);
        tpmtraselectingtheusicompany.click();
    }
    public void traselectingusicompany() {
        try {
            tpmtraselectingusicompany.click();
            Thread.sleep(3000);
        } catch (Exception e) { }

    }
    public void traclickingservicesearch() {
        tpmtraserviceclicking.click();
    }
    public void traselectingtheservice(String trservice)
    {
        tpmtraservicecertissuance.sendKeys(trservice);

    }
    public void traclickingtheenteredservice() {
        try {
            tpmtraclickingtheserviceentered.click();
            Thread.sleep(3000);
        } catch (Exception e) { }
    }
    public void traclickingtaskdescriptionsearch() {
        tpmtrataskdescriptioncertissuance.click();
    }
    public void traselectingthetaskdescription(String trtaskdescription) {
        tpmtrataskdescriptionentering.sendKeys(trtaskdescription);
    }
    public void traclickingtheenteredtaskdescription() {
        tpmtraclickingthetaskdescriptionentered.click();
    }
    /* public void traviewing() {
         tpmtraviewing.sendKeys("100");
     }*/
    public void traenteringtheworkordernumber(String trworkordernumber) {
        tpmtrworknumber.sendKeys(trworkordernumber);
    }
    public void traenteringemployeename(String tremployee) {
        tpmtremployee.sendKeys(tremployee);
    }
    public void trenteringhours(String trhours) {
        tpmtrhours.sendKeys(trhours);
    }
    @FindBy(how = How.ID, using = "editTimerecord_task")
    public WebElement editingthetimerecordtask;
    @FindBy(how = How.ID, using = "editTimerecord_start_time")
    public WebElement editingthestarttime;
    @FindBy(how = How.ID, using = "editTimerecord_end_time")
    public WebElement editingtheendtime;
    @FindBy(how = How.ID, using = "editTimerecord_submit")
    public WebElement trasubmitbutton;
    public void editiingthetimerecordtask(String Trtask, String Trstarttime, String Trendtime) {
        editingthetimerecordtask.sendKeys(Trtask);
        editingthestarttime.clear();
        editingthestarttime.sendKeys(Trstarttime);
        editingtheendtime.clear();
        editingtheendtime.sendKeys(Trendtime);
        trasubmitbutton.click();
    }

    @FindBy(how = How.CSS, using = "#dtTimeRecordAdmin > tbody > tr > td:nth-child(1) > center > span")    //  Editing Time Record Admin record
    public WebElement editingthetimerecord;
    public void editTRAicon() {
        editingthetimerecord.click();
    }

    @FindBy(how = How.ID, using = "index9")   // Clicking on Time Record Open
    public WebElement timeRecOpen;

    public void timeRecOpen()     {
        timeRecOpen.click();
    }

    public void logo() {
        logo.click();
    }

    @FindBy(how = How.CSS, using = "body > header > nav > div > div > div:nth-child(3) > div.topbar-actions > div > button > i")   // Logout icon
    public WebElement btnLogoutIcon;

    @FindBy (how = How.CSS, using = "body > header > nav > div > div > div.col-md-3.col-sm-3.col-xs-12.patraheaderp3 > div.topbar-actions > div > button > i")  //Logout
    public WebElement clickicon;
    public void clicklogouticon()     {
        clickicon.click();
    }

    // Clicking on Logout
    @FindBy(how = How.CSS, using = "body > header > nav > div > div > div.col-md-3.col-sm-3.col-xs-12.patraheaderp3 > div.topbar-actions > div > ul > li.btn.btn-block.userMenu > a > h4")  // logout button
    public WebElement btnLogout;

    public void Logout()     {
        btnLogout.click();
    }
}
