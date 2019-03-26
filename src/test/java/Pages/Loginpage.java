package Pages;

import Base.BaseUtil;
import cucumber.api.Scenario;
import org.omg.PortableServer.THREAD_POLICY_ID;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class Loginpage extends BaseUtil{

    public Loginpage(BaseUtil base) {
        this.base = base;
    }
    private BaseUtil base;

    @FindBy(how = How.ID, using = "email")
    public WebElement txtemail;
    @FindBy(how = How.ID, using = "password")
    public WebElement txtpassword;
    @FindBy(how = How.ID, using = "submit")
    public WebElement btnSignIn;
    @FindBy(how = How.ID, using = "companyStartId")  //Select Company //
    public WebElement selcompany;
    @FindBy(how = How.ID, using = "companyStartId")  //Select service //
    public WebElement selservice;
    @FindBy(how = How.XPATH, using = "//*[@id='startPageContainer']/div[1]/a")  //selecting usi client
    public WebElement clickclient;
    @FindBy(how = How.CSS, using = "#index > img")   //Patracorp logo
    public WebElement logo;
    @FindBy(how = How.CSS, using = "body > div.container-fluid > div > div > div > div > a:nth-child(2)") //home page app selection
    public WebElement WOTracking;

    //Intitializing elements in Add WO
    @FindBy(how = How.ID, using = "cert_addWOrkOrder")   //Add WO
    public WebElement ClickAddworkorder;
    @FindBy(how = How.ID, using = "add_cert_Process")
    public WebElement Addwoprocess;
    @FindBy(how = How.CSS, using = "#liststyle > div.col-md-11.col-sm-12.col-xs-12 > div:nth-child(2) > label.btn.btn-primary.label1")
    public WebElement Addwoisassign;
    @FindBy(how = How.CSS, using = "#liststyle > div.col-md-11.col-sm-12.col-xs-12 > div:nth-child(3) > label.btn.btn-primary.label1")
    public WebElement Addwoishold;
    @FindBy(how = How.CSS, using = "#liststyle > div.col-md-11.col-sm-12.col-xs-12 > div:nth-child(4) > label.btn.btn-primary.label1")
    public WebElement Addwoisemail;
    @FindBy(how = How.CSS, using = "#liststyle > div.col-md-11.col-sm-12.col-xs-12 > div:nth-child(5) > label.btn.btn-primary.label1")
    public WebElement Addwoisdiscard;
    @FindBy(how = How.CSS, using = "#liststyle > div.col-md-11.col-sm-12.col-xs-12 > div:nth-child(6) > label.btn.btn-primary.label1")
    public WebElement Addwoisdelivered;
    @FindBy(how = How.CSS, using = "#liststyle > div.col-md-11.col-sm-12.col-xs-12 > div:nth-child(7) > label.btn.btn-primary.label1")
    public WebElement Addwoistaskcomplete;
    @FindBy(how = How.ID, using = "add_cert_HoldReason")
    public WebElement Addwoholdreason;
    @FindBy(how = How.CSS, using = "#liststyle > div.col-md-11.col-sm-12.col-xs-12 > div:nth-child(8) > label.btn.btn-primary.label1")
    public WebElement Addwoupdate;
    @FindBy(how = How.CSS, using = "#liststyle > div.col-md-11.col-sm-12.col-xs-12 > div:nth-child(9) > label.btn.btn-primary.label1 > span")
    public WebElement Addwofrompending;
    @FindBy(how = How.CSS, using = "#add_cert_isRush")
    public WebElement Addworush;
    @FindBy(how = How.CSS, using = "#home > div > div > div:nth-child(1) > div:nth-child(3) > label")
    public WebElement Addwobulk;
    @FindBy(how = How.ID, using = "add_cert_Assign_To")
    public WebElement Addwoassignto;
    @FindBy(how = How.ID, using = "add_cert_Status")
    public WebElement Addwostatus;
    @FindBy(how = How.ID, using = "add_cert_Folder")
    public WebElement Addwofolder;
    @FindBy(how = How.ID, using = "add_cert_SentTo")
    public WebElement Addwosentto;
    @FindBy(how = How.ID, using = "add_cert_Summary")
    public WebElement Addwosummary;
    @FindBy(how = How.ID, using = "add_cert_Requestor")
    public WebElement Addworequestor;
    @FindBy(how = How.ID, using = "add_cert_Assign_To")
    public WebElement Addwoassignedto;
    @FindBy(how = How.ID, using = "add_cert_AddDate")
    public WebElement Addwoadddate;
    @FindBy(how = How.ID, using = "add_cert_StrtDateOverride")
    public WebElement Addwostartdateoverrideselectdate;
    @FindBy(how = How.CSS, using = "body > div:nth-child(32) > div.datetimepicker-days > table > tfoot > tr:nth-child(1) > th")
    public WebElement Addwostartdateoverridedatepicker;
    @FindBy(how = How.ID, using = "add_cert_DueDateOverride")
    public WebElement Addwoduedateoverrideselectdate;
    @FindBy(how = How.CSS, using = "body > div:nth-child(32) > div.datetimepicker-days > table > tfoot > tr:nth-child(1) > th")
    public WebElement Addwoduedateoverridedatepicker;
    @FindBy(how = How.ID, using = "add_cert_DueDate")
    public WebElement Addwoduedate;
    @FindBy(how = How.ID, using = "workOrder_submit")
    public WebElement Addwosubmitbtn;
    @FindBy(how = How.ID, using = "workOrder_cancel")
    public WebElement Addwocancelbtn;
    @FindBy(how = How.CSS, using = "#startPageContainer > div:nth-child(1) > a")
    public WebElement Selectprtclient;
    @FindBy(how = How.CSS, using = "#dtprocessing > tbody > tr:nth-child(1) > td:nth-child(1) > a")
    public WebElement Editworec;
    @FindBy(how = How.CSS, using = "body > div.jconfirm.jconfirm-light.jconfirm-open > div.jconfirm-scrollpane > div > div > div > div > div > div > div > div.jconfirm-buttons > button")
    public WebElement Clickclosepopup;

  //Entering into WO detail section
    @FindBy(how = How.ID, using = "workOrderEntry_sect")
    public WebElement WOdetailsection;
    //Entering into Original email section
    @FindBy(how = How.ID, using = "OriginalEmail_sect")
    public WebElement Originalemail;
    //Clicking on Delivery instruction section
    @FindBy(how = How.ID, using  = "delivery_instr_sect")
    public WebElement Deliveryinstruction;
    //Clicking on Second QA
    @FindBy(how = How.ID, using  = "secondQa_sects")
    public WebElement Secondqa;

  //Entering into QA section
    @FindBy(how = How.ID, using = "QA_sect")
    public WebElement ClickQA;

  //Entering text in description part of Original Email
    @FindBy(how = How.ID, using = "add_original_email")
    public WebElement Descriptionoforiginalemail;

  //Entering details into Second QA section
    @FindBy(how = How.ID, using = "add_cert_second_qa_needed")
    public WebElement Secondqaneeded;
    @FindBy(how = How.ID, using = "add_cert_second_qa_done")
    public WebElement Secondqadone;
    @FindBy(how = How.ID, using = "add_cert_second_qadone_by")
    public WebElement Secondqadoneby;

  //select work order in folder
    @FindBy (how = How.ID, using = "cert_Folder")
    public WebElement Foldername;

 //Entering details into WO details section
    @FindBy(how = How.ID, using = "no_of_certs")
    public WebElement Noofcerts;
    @FindBy(how = How.ID, using = "client_code")
    public WebElement Clientcode;
    @FindBy(how = How.ID, using = "client_name")
    public WebElement Clientname;
    @FindBy(how = How.ID, using = "add_workorder_type")
    public WebElement Wotype;
    @FindBy(how = How.ID, using = "add_branch_office")
    public WebElement Branchoffice;
    @FindBy(how = How.ID, using = "add_cert_department")
    public WebElement Department;
    @FindBy(how = How.ID, using = "add_cert_division")
    public WebElement Division;
    @FindBy(how = How.ID, using = "add_profit_center")
    public WebElement Profitcenter;
    @FindBy(how = How.ID, using = "add_cert_master")
    public WebElement Certmaster;
    @FindBy(how = How.ID, using = "add_cert_issuance_system")
    public WebElement Certissuancesystem;
    @FindBy(how = How.ID, using = "holders_dated_count")
    public WebElement Noofholders;
    @FindBy(how = How.ID, using = "add_cert_issued_by")
    public WebElement Certissuedby;
    @FindBy(how = How.ID, using = "add_qa_by")
    public WebElement Qaby;
    @FindBy(how = How.ID, using = "add_delivery_by")
    public WebElement Deliveryby;
    @FindBy(how = How.ID, using = "complexity_type")  //Complexity
    public WebElement Complexity;


    //Intitializing elements in Processing tab
    @FindBy(how = How.CSS, using = "#dtprocessing_wrapper > div:nth-child(1) > div:nth-child(2) > div > div.btn.btn-sm.red.btn-outline.search-clear")
    public WebElement btnreset;
    @FindBy(how = How.ID, using = "WorkOrderNumberProcess")   //WO search box
    public WebElement wosearch;
    @FindBy(how = How.ID, using = "ClientCodeProcess")   //Client code search box
    public WebElement clientcodesearch;
    @FindBy(how = How.ID, using = "SummaryProcess")   //Summary search box
    public WebElement summarysearch;
    @FindBy(how = How.ID, using = "RequestorProcess")   //Requestor search box
    public WebElement requestorsearch;
    @FindBy(how = How.CSS, using = "#NumberofCertsProcess")   //# of certs search box
    public WebElement numcertssearch;
    @FindBy(how = How.ID, using = "RushBulkProcess")  // Rush/Bulk
    public WebElement txtrushbulk;
    @FindBy(how = How.ID, using = "IsUpdateProcess")  // Update
    public WebElement txtupdate;

    @FindBy(how = How.CSS, using = "#dtprocessing > tbody > tr > td:nth-child(1) > a")  //WO #862049
    public WebElement WONum;
    @FindBy(how = How.ID, using = "sw_start")   //Start timer button
    public WebElement WOstarttimer;
    @FindBy(how = How.ID, using = "timer_task")   //Select Task
    public WebElement seltask;
    @FindBy(how = How.ID, using = "timer-Details-Submit")   //Start timer in pop-up
    public WebElement hitstarttimer;
    @FindBy(how = How.ID, using = "sw_stop")   //Stop timer in header
    public WebElement hitstoptimer;
    @FindBy(how = How.XPATH, using = "/html/body/div[4]/div[1]/div/div/div/ul/li[3]/button")   //Print PDF button html/body/div[3]/div[1]/div/div/div/ul/li[3]/button
    public WebElement printpdf;
    @FindBy(how = How.XPATH, using = "//*[@id='btnRush']")  //Mark Rush button
    public WebElement btnmarkrush;
    @FindBy(how = How.XPATH, using = "//*[@id='btnBulk']")  //Mark Bulk button
    public WebElement btnmarkbulk;

//Intitializing elements in Processing work order form

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
    @FindBy(how = How.ID, using = "cert_Process")  //process dropdown
    public WebElement ProcProcess;
    @FindBy(how = How.CSS, using = "#liststyle > div.col-md-5.col-sm-12.col-xs-12 > div:nth-child(1) > label.btn.btn-primary.label1")  //Assign check box
    public WebElement ProcAssign;
    @FindBy(how = How.CSS, using = "#liststyle > div.col-md-5.col-sm-12.col-xs-12 > div:nth-child(3) > label.btn.btn-primary.label1")  //Email check box
    public WebElement ProcEmail;
    @FindBy(how = How.CSS, using = "#liststyle > div.col-md-5.col-sm-12.col-xs-12 > div:nth-child(2) > label.btn.btn-primary.label1")  //Hold check box
    public WebElement ProcHold;
  //  @FindBy(how = How.CSS, using = "#liststyle > div.col-md-5.col-sm-12.col-xs-12 > div:nth-child(4) > label.btn.btn-primary.label1")  //Discard check box
    @FindBy(how = How.XPATH, using = "//*[@id='liststyle']/div[2]/div[5]/label/span")
    public WebElement ProcDiscard;
    @FindBy(how = How.XPATH, using = "/html/body/div[12]/div[2]/div/div/div/div/div/div/div/div[4]/button") // /html/body/div[9]/div[2]/div/div/div/div/div/div/div/div[4]/button  //Discard check box
    public WebElement discardalert;
    @FindBy(how = How.CSS, using = "#liststyle > div.col-md-5.col-sm-12.col-xs-12 > div:nth-child(5) > label.btn.btn-primary.label1")  //Delivered check box
    public WebElement ProcDelivered;
  // @FindBy(how = How.CSS, using = "#liststyle > div.col-md-5.col-sm-12.col-xs-12 > div:nth-child(6) > label.btn.btn-primary.label1.taskcmp")  //Task completed check box
  // @FindBy(how = How.ID, using = "cert_Istaskcomplete")
    @FindBy(how = How.CSS, using = "#liststyle > div:nth-child(3) > div:nth-child(7) > label.btn.btn-primary.label1.taskcmp")
    public WebElement ProcTaskCompleted;
    @FindBy(how = How.ID, using = "cert_Status")  //Status combo box
    public WebElement ProcStatus;
    @FindBy(how = How.ID, using = "cert_Folder")  //Folder combo box
    public WebElement ProcFolder;
    @FindBy(how = How.ID, using = "cert_StrtDateOverride")  //Start Date Override
    public WebElement ProcStartDateverride;
    @FindBy(how = How.CSS, using = "body > div.jconfirm.jconfirm-light.jconfirm-open > div.jconfirm-scrollpane > div > div > div > div > div > div > div > div.jconfirm-buttons > button")  //Delievry Alert OK
    public WebElement btndeliveryalert;

   /* @FindBy(how = How.XPATH, using = "/html/body/div[6]/div[3]/table/tfoot/tr[1]/th") //Start Date Override calendar today
    public WebElement ProcStartDateverride;*/

    @FindBy(how = How.ID, using = "cert_DueDateOverride")  //Due Date Override
    public WebElement ProcDueDateverride;
    @FindBy(how = How.ID, using = "cert_HoldReason")  //Hold Reason
    public WebElement ProcHoldReason;
    @FindBy(how = How.ID, using = "cert_Assign_To")  //Assign To
    public WebElement ProcAssignTo;
    @FindBy(how = How.ID, using = "cert_Summary")  //Summary
    public WebElement ProcSummary;
    @FindBy(how = How.ID, using = "cert_Requestor")  //Requestor
    public WebElement ProcRequestor;
    @FindBy(how = How.ID, using = "cert_SentTo")  //Sent To
    public WebElement ProcSentto;
    @FindBy(how = How.ID, using = "work_entry_submit")  //Submit buttons
    public WebElement submit;
    @FindBy(how = How.ID, using = "work_entry_cancel")  //Cancel button
    public WebElement btncancelchanges;
    @FindBy(how = How.ID, using = "Original_Email_details")  //Original email
    public WebElement originalemail;
  //  @FindBy(how = How.XPATH, using = "//*[@id='work_entry_close']")  //Close button
    @FindBy(how = How.ID, using = "work_entry_close")
    public WebElement CloseWO;



    @FindBy(how = How.CSS, using = "#Attachment_event")  //Add Attachments button
    public WebElement Proaddattachments;
    @FindBy(how = How.ID, using = "UploadFile1")  //Add Attachments button
    public WebElement choosefile1;
    @FindBy(how = How.NAME, using = "btnSave")  //Save attachment button
    public WebElement Attsave;
    @FindBy(how = How.CLASS_NAME, using = "stdformbotbutton")  //Cancel attachment button
    public WebElement Attcancel;

//Intitializing elements in Processing work order form - Detail Tab

    @FindBy(how = How.ID, using = "no_of_certs")  // # of certs
    public WebElement Proccerts;
    @FindBy(how = How.ID, using = "client_code")  // Client code
    public WebElement ProcClientcode;
    @FindBy(how = How.ID, using = "client_name")  // Client name
    public WebElement ProcClientname;
    @FindBy(how = How.ID, using = "workorder_type")  // Work Order Type
    public WebElement ProcWorkOrderType;
    @FindBy(how = How.ID, using = "branch_office")  // Branch Office
    public WebElement ProcBranchOffice;
    @FindBy(how = How.ID, using = "cert_department")  // Department
    public WebElement ProcDepartment;
    @FindBy(how = How.ID, using = "cert_division")  // Division
    public WebElement ProcDivision;
    @FindBy(how = How.ID, using = "profit_center")  // Profit Center
    public WebElement ProcProfitCenter;
    @FindBy(how = How.ID, using = "cert_master")  // Cert master
    public WebElement ProcCertmaster;
    @FindBy(how = How.ID, using = "cert_issuance_system")  // Cert Issuance System
    public WebElement ProcCertIssuanceSystem;
    @FindBy(how = How.ID, using = "holders_dated_count")  // # of Holders Dated Off Count
    public WebElement ProcHoldersDatedOff;
    @FindBy(how = How.ID, using = "cert_issued_by")  // Cert Issued By
    public WebElement ProcCertIssuedBy;
    @FindBy(how = How.ID, using = "qa_by")  // QA By
    public WebElement ProcQABy;
    @FindBy(how = How.ID, using = "delivery_by ")  // Delivery By
    public WebElement ProcDeliveryBy;
    @FindBy(how = How.ID, using = "insured_delivery")  // Insured Delivery
    public WebElement ProcInsuredDelivery;
    @FindBy(how = How.ID, using = "cert_holder_delivery")  // Cert Holder Delivery
    public WebElement ProcCertHolderDelivery;
    @FindBy(how = How.ID, using = "carrier_delivery_fax")  // Carrier Delivery - Fax
    public WebElement ProcCarrierDeliveryFax;
    @FindBy(how = How.ID, using = "carrier_delivery_email")  // Carrier Delivery - Email
    public WebElement ProcCarrierDeliveryEmail;
    @FindBy(how = How.ID, using = "account_manager_delivery")  // Account Manager Delivery
    public WebElement ProcAccountManagerDelivery;
    @FindBy(how = How.ID, using = "twd_files")  //TWB eTFiled?  check box
    public WebElement ProcTWBeTFiled;
    @FindBy(how = How.ID, using = "insured_method")  // Insured Method
    public WebElement ProcInsuredMethod;
    @FindBy(how = How.ID, using = "cert_holder_method")  // Cert Holder Method
    public WebElement ProcCertHolderMethod;
    @FindBy(how = How.ID, using = "carrier_method")  // Carrier Method
    public WebElement ProcCarrierMethod;
    @FindBy(how = How.ID, using = "csr_contact")  // CSR Contact 1
    public WebElement ProcCSRContact1;
    @FindBy(how = How.ID, using = "csr_contact2")  // CSR Contact 2
    public WebElement ProcCSRContact2;
    @FindBy(how = How.ID, using = "no_pages_faxed")  // # of Pages
    public WebElement ProcPagesFaxed;
    @FindBy(how = How.ID, using = "delivery_comments")  // Additional Delivery Comments
    public WebElement ProcAdditionalDeliveryComments;
    @FindBy(how = How.ID, using = "comments")  // Comments
    public WebElement ProcComments;
    @FindBy(how = How.ID, using = "date_delivery")  // Date Delivery
    public WebElement ProcDateDelivery;
    @FindBy(how = How.ID, using = "date_completed")  // Date Completed
    public WebElement ProcDateCompleted;
    @FindBy(how = How.ID, using = "complexity_type")  //Complexity
    public WebElement ProcComplexity;
 /* @FindBy(how = How.ID, using = "cert_detail_submit")  // Submit button - Detail tab Removed
    public WebElement ProcDetailSubmit;
    @FindBy(how = How.ID, using = "cert_detail_cancel")  // Cancel button - Detail tab Removed
    public WebElement ProcDetailCancel;
*/
    @FindBy(how = How.ID, using = "attachments_sects")   //Attachments tab
    public WebElement attachments;
    @FindBy(how = How.ID, using = "Email_sects")        //Emails tab
    public WebElement emails;
    @FindBy(how = How.XPATH, using = "//*[@id='dtemails']/tbody/tr[1]/td[4]/center/span")  //Email Eye Icon
    public WebElement emailicon;
    @FindBy(how = How.XPATH, using = "//*[@id='myEmails']/div/div/div[3]/button")  //Email Eye Icon
    public WebElement close;

    @FindBy(how = How.ID, using = "QA_sects")       // QA tab
    public WebElement qa;
    @FindBy(how = How.ID, using = "cert_auditQA")       // Audit / QA
    public WebElement qaaudit;
    @FindBy(how = How.ID, using = "cert_No_Errors")       // # of errors
    public WebElement qaerrors;
    @FindBy(how = How.ID, using = "cert_error_made_by")       // Error Made By
    public WebElement qaerrormadeby;
    @FindBy(how = How.ID, using = "cert_error_type")       // Error Type
    public WebElement qaerrortype;
    @FindBy(how = How.ID, using = "cert_error_filed_by")       //Error Filed By
    public WebElement qaerrorfiled;
    @FindBy(how = How.ID, using = "cert_error_description")       //Error Description
    public WebElement qaerrordesc;
    @FindBy(how = How.ID, using = "QA_submit")       //Submit QA
    public WebElement qasubmit;
    @FindBy(how = How.ID, using = "QA_cancel")       //Cancel QA
    public WebElement qacancel;

    @FindBy(how = How.ID, using = "secondQa_sects")       // Second QA tab
    public WebElement secondqa;
    @FindBy(how = How.ID, using = "cert_second_qa_needed")       // Second QA Needed
    public WebElement secondqaneeded;
    @FindBy(how = How.ID, using = "cert_second_qa_done")       // Second QA Done
    public WebElement secondqadone;
    @FindBy(how = How.ID, using = "cert_second_qadone_by")       // Second QA Done By
    public WebElement secondqadoneby;
    @FindBy(how = How.ID, using = "SecondQa_submit")          //Second QA submit
    public WebElement secondqasubmit;
    @FindBy(how = How.ID, using = "history_sects")       // History tab
    public WebElement history;
    @FindBy(how = How.ID, using = "timerecords_sects")   //Time records tab
    public WebElement timerecords;

    @FindBy(how = How.ID, using = "index2")   //Time records page link on top bar grid
    public WebElement timerecordsgrid;
  //  @FindBy(how = How.ID, using = "index1")   //Work Orders page link on top bar grid
    @FindBy(how = How.XPATH, using = "//*[@id='index1']")
    public WebElement workorderssgrid;
    @FindBy(how = How.ID, using = "kpi3")   //KPI Delievry
    public WebElement selkpidelivery;
    @FindBy(how = How.ID, using = "WorkOrderNumberProcess")   //KPI Delievry WO search box
    public WebElement kpideliverywosearch;
    @FindBy(how = How.CSS, using = "#dtprocessing > tbody > tr:nth-child(1) > td:nth-child(1) > a")   //KPI Delievry wo#861326
    public WebElement kpiwonum;
    @FindBy(how = How.CSS, using = "#dt-incoming-responses > tbody > tr > td:nth-child(1) > a")   //clicking WO incoming resp
    public WebElement woclick;

 //Initializing for column sorting in Time records
    @FindBy(how = How.CSS, using = "#th-CompanyNameTR > ul > li > span")   //Company sorting
    public WebElement sortcompany;
    @FindBy(how = How.CSS, using = "#th-ServiceDescriptionTR > ul > li > span")   //Service sorting
    public WebElement sortservice;

  //  @FindBy(how = How.ID, using = "typeaheadValue")  // Global search text box
  //  @FindBy(how = How.CSS, using = "#typeaheadValue")
  //  @FindBy(how = How.NAME, using = "query")
    @FindBy(how = How.XPATH, using = "//*[@id='typeaheadValue']")
    public WebElement txtGlobalSearch;
  //  @FindBy(how = How.XPATH, using = "//*[@id='the-basics-new']/span/div/div/p/a") //Global Search link select
    @FindBy(how = How.CSS, using = "#the-basics-new > span > div > div > p > a > strong") //#1077636 - Global Search link select
    public WebElement linkGlobalSearchSelection;

    @FindBy (how = How.CSS, using = "body > header > nav > div > div > div.col-md-2 > div.topbar-actions > div > button > i")  //Logout
    public WebElement clickicon;
  //  @FindBy (how = How.CSS, using = "body > header > nav > div > div > div:nth-child(3) > div.topbar-actions > div > ul > li.btn.btn-block.userMenu > a > h4")
    @FindBy(how = How.XPATH, using = "//*[@id='logoutClick']")
    public WebElement btnlogout;

    @FindBy(how = How.ID, using = "changecompany")   //Change client dropdown
    public WebElement changeclient;
    @FindBy(how = How.CSS, using = "body > div.jconfirm.jconfirm-light.jconfirm-open > div.jconfirm-scrollpane > div > div > div > div > div > div > div > div.jconfirm-buttons > button:nth-child(1)")
    public WebElement changeclientconfirmbtn;

  //Clicking Certissuance KPI
    @FindBy(how = How.CSS, using = "#kpi1Count") //#kpi1Count
    public WebElement certissuanckpiclick;
  //Clicking on QA KPI
    @FindBy(how = How.CSS, using = "#kpi2Count")
    public WebElement qakpiclick;
  //Clicking on Reset button
    @FindBy (how = How.CSS, using = "#dtprocessing_wrapper > div:nth-child(1) > div:nth-child(2) > div > div.btn.btn-sm.red.btn-outline.search-clear")  //Reset btn
    public WebElement btnresetClick;
    //Clicking on Reset button on Completed tab
    @FindBy(how = How.CSS, using = "#dtcompleted_wrapper > div:nth-child(1) > div:nth-child(2) > div > div.btn.btn-sm.red.btn-outline.search-clear")
    public WebElement completedbtnreset;
  //Select workorder by work ordernumber
    @FindBy(how = How.CSS, using = "#dtprocessing > tbody > tr > td:nth-child(1) > a") //WO # from Certs KPI
    public WebElement selectworkorderclick;
    @FindBy(how = How.CSS, using = "#dtprocessing > tbody > tr.odd > td:nth-child(1) > a") //WO #2060 from QA KPI
    public WebElement selqawo;



    public Loginpage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void Login(String Email, String Password)
    {
        txtemail.sendKeys(Email);
        txtpassword.sendKeys(Password);
    }

    public void SignInButton() {
        btnSignIn.click();
    }

    public void WoTracklink() {
        WOTracking.click();
    }

    public void pickclient(String Company) {
          selcompany.sendKeys(Company);
     //   selcompany.sendKeys("USI");
     //   selservice.sendKeys("Certificate Issuance");
    }

    public void changecomp(String Company) {
        changeclient.click();
        changeclient.sendKeys(Company);
        changeclient.click();
        //changeclient.findElement(By.xpath("//*[@id='changecompany']/option[2]")).isSelected();
        // changeclient.findElement(By.linkText("Ahmann-Martin")).click();
    }
    public void changecomppopup() {
        changeclientconfirmbtn.click();
    }

    public void gotoclient() {
        clickclient.click();
    }

    public void clickaddworkorder() {
        ClickAddworkorder.click();
    }

    public void certsaddworkordersbutton(String addwoprocess, String addwoisassign, String addwoishold, String addwoisemail, String addwoisdiscard, String addwoisdelivered, String addwoistaskcompleted, String addwoholdreason, String addwoupdate, String addwofrompending, String addworush, String addwobulk, String addwoassignto, String addwostatus, String addwofolder, String addworequestor, String addwosentto, String addwosummary, String addwoassignedto) {
     /* Addwoprocess.sendKeys(addwoprocess);
        Addwoisassign.click();
        Addwoishold.click();
        Addwoisemail.click();
        Addwoisdiscard.click();
        Addwoisdelivered.click();
        Addwoistaskcomplete.click();
        Addwoupdate.click();
        Addwofrompending.click();
        Addworush.click(); */
        /*Addwostatus.sendKeys(addwostatus);
        Addwofolder.sendKeys(addwofolder);*/
      /*  Addwoholdreason.sendKeys(addwoholdreason);
        Addwoassignto.sendKeys(addwoassignto);*/
        Addwobulk.click();
        Addwosummary.sendKeys(addwosummary);
        Addworequestor.sendKeys(addworequestor);
        Addwosentto.sendKeys(addwosentto);
    }
    public void addduedates() {
       /* Addwostartdateoverrideselectdate.click();
        Addwostartdateoverridedatepicker.click();
        Addwoduedateoverrideselectdate.click();
        Addwoduedateoverridedatepicker.click();*/
    }

    public void wodetailsection() {
        WOdetailsection.click();
    }
    public void wodetailsectionentry(String noofcerts, String clientcode, String clientname, String wotype, String branchoffice, String department, String division, String profitcenter, String certmaster, String certissuancesystem, String noofholders, String certissuedby, String qaby, String deliveryby, String complexity) {
        Noofcerts.sendKeys(noofcerts);
        Clientcode.sendKeys(clientcode);
        Clientname.sendKeys(clientname);
        Wotype.sendKeys(wotype);
        Branchoffice.sendKeys(branchoffice);
        Department.sendKeys(department);
        Division.sendKeys(division);
        Profitcenter.sendKeys(profitcenter);
        Certmaster.sendKeys(certmaster);
        Certissuancesystem.sendKeys(certissuancesystem);
        Noofholders.sendKeys(noofholders);
        Certissuedby.sendKeys(certissuedby);
        Qaby.sendKeys(qaby);
        Deliveryby.sendKeys(deliveryby);
        Complexity.sendKeys(complexity);
    }
    public void originalemail() {
        Originalemail.click();
    }
    public void descriptionoforiginalemail(String originalemail) {
        Descriptionoforiginalemail.sendKeys(originalemail);
    }

    public void addwosubmitbtn() {
        Addwosubmitbtn.click();
        Addwocancelbtn.click();
    }
    public void clickclosepopup() {
        Clickclosepopup.click();
    }

    public void ProcReset(){
       btnreset.click();
    }

    public void SelWO(){
        WONum.click();
    }
    public void editingwofun() {
        ProcSummary.sendKeys("^^from pending^^");
        ProcUpdate.click();
        submit.click();
        CloseWO.click();
    }

    public void WorkOrderSearch(String wonumsearch, String clientcode, String summary){
        try {
            Thread.sleep(2000);
            wosearch.sendKeys(wonumsearch);
            Thread.sleep(3000);
            clientcodesearch.sendKeys(clientcode);
            summarysearch.sendKeys(summary);
        } catch(Exception e){ }
    }

    public void WOtimer(){
        WOstarttimer.click();
    }

    public void starttimer() {
        seltask.sendKeys("Certificate Issuance");
        hitstarttimer.click();
    }

    public void stoptimer() {
        hitstoptimer.click();
    }

    public void printpdf() {
        printpdf.click();
    }

    public void markrush() {
        btnmarkbulk.click();
        btnmarkrush.click();
        submit.click();
    }

    public void Assign() {
        ProcProcess.click();
        ProcProcess.sendKeys("Cert Prep");
        submit.click();
    }
    public void AssignQA() {
        ProcProcess.click();
        ProcProcess.sendKeys("QA");
        submit.click();
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

    public void Cancelchanges() {
        btncancelchanges.click();
    }

    public void EditWO() {
        try {
            ProcSummary.sendKeys("testing certs - anusha");
            ProcTaskCompleted.click();
            Thread.sleep(6000);
            submit.click();
        } catch (Exception e) {}
    }
    public void AssignDelivery() {
        ProcProcess.click();
        ProcProcess.sendKeys("Delivery");
        ProcProcess.click();
    }
    public void deliveryalert() {
        btndeliveryalert.click();
    }
    public void AssignEmail() {
        ProcProcess.click();
        ProcProcess.sendKeys("Email");
        ProcProcess.click();
    }
    public void AssignDelTwb() {
        ProcProcess.click();
        ProcProcess.sendKeys("DEL - TWB");
        ProcProcess.click();
    }

    public void SelectProcessingWOform(String WO, String AssignedTo, String Rush, String Bulk, String FromPending, String Update, String Process, String IsAssigned, String ishold,
                                 String IsEmail, String IsDiscard, String IsDelivered, String IsTaskCompleted, String Status, String Folder, String StartDateOverride, String DueDateOvrride,
                                 String Holdreason,String Assignto, String Summary, String Requestor, String Sentto)
    {
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

    public void Detail(String NumOfCerts, String ClientCode, String ClientName, String WorkOrderType, String BranchOffice, String Department, String Division, String Holders,
                       String Certmaster, String ProfitCenter, String CertIssuanceSystem, String CertIssuedby, String QaBy, String DeliveryBy, String InsuredDelivery, String CertHolderDelivery,
                       String CarrierFax, String AMdelievry, String TWBet, String InsuredMethod, String CertHoldermethod, String CarrierMethod, String CSRcontact1, String CSRcontact2,
                       String Pages, String AdditionalComments, String Comments, String Complexity)
    {
        Proccerts.sendKeys(NumOfCerts);
        ProcClientcode.sendKeys(ClientCode);
        ProcClientname.sendKeys(ClientName);
        ProcWorkOrderType.sendKeys(WorkOrderType);
        ProcBranchOffice.sendKeys(BranchOffice);
        ProcDepartment.sendKeys(Department);
        ProcDivision.sendKeys(Division);
        ProcProfitCenter.sendKeys(ProfitCenter);
        ProcCertmaster.sendKeys(Certmaster);
        ProcCertIssuanceSystem.sendKeys(CertIssuanceSystem);
        ProcHoldersDatedOff.sendKeys();
        ProcCertIssuedBy.sendKeys(CertIssuedby);
        ProcQABy.sendKeys(QaBy);
        ProcDeliveryBy.sendKeys(DeliveryBy);
        ProcInsuredDelivery.sendKeys(InsuredDelivery);
        ProcCertHolderDelivery.sendKeys(CertHolderDelivery);
        ProcCarrierDeliveryFax.sendKeys(CarrierFax);
        ProcAccountManagerDelivery.sendKeys(AMdelievry);
        ProcTWBeTFiled.click();
        ProcInsuredMethod.sendKeys(InsuredMethod);
        ProcCertHolderDelivery.sendKeys(CertHoldermethod);
        ProcCarrierMethod.sendKeys(CarrierMethod);
        ProcCSRContact1.sendKeys(CSRcontact1);
        ProcCSRContact2.sendKeys(CSRcontact2);
        ProcPagesFaxed.sendKeys(Pages);
        ProcAdditionalDeliveryComments.sendKeys(AdditionalComments);
        ProcComments.sendKeys(Comments);
        ProcDateDelivery.sendKeys();
        ProcDateCompleted.sendKeys();
        ProcComplexity.sendKeys(Complexity);
        submit.click();
        originalemail.click();
    }

    public void AddAttach() {
        Proaddattachments.click();   //Add Attachments
     //   choosefile1.click();
     //   Attsave.click();
      //  Attcancel.click();
    }

    public void Attachments() {
        attachments.click();
    }
    public void Emails() {
        emails.click();
     //   emailicon.click();
     //   close.click();
    }
    public void QA() {
        qa.click();
    }
    public void QAedit(String AuditQA, String Errors, String ErrorMadeBy, String ErrorType, String Filedby, String ErrDesc) {
        try {
            qaaudit.sendKeys(AuditQA);
            qaerrors.sendKeys(Errors);
            qaerrormadeby.sendKeys(ErrorMadeBy);
            qaerrortype.sendKeys(ErrorType);
            qaerrorfiled.sendKeys(Filedby);
            qaerrordesc.sendKeys(ErrDesc);
            Thread.sleep(5000);
        } catch(Exception e) {}
    }
    public void Submit() {
        try {
            Thread.sleep(15000);
            submit.click();
        } catch(Exception e) {}
    }
    public void SecondQa() {
        secondqa.click();
    }
    public void SecondQaedit(String Needed, String Done, String Doneby) {
        try {
            secondqaneeded.click();
            secondqadone.click();
            secondqadoneby.sendKeys(Doneby);
            Thread.sleep(5000);
        } catch(Exception e) {}
    }

    public void History() {
        history.click();
    }
    public void TimeRecords() {
        timerecords.click();
    }

    public void TimeRecordsGrid() {
        timerecordsgrid.click();
    }

    public void sortcompany(){
        sortcompany.click();
    }
    public void sortservice() {
        sortservice.click();
    }

    public void WOgrid() {
        workorderssgrid.click();
    }

    public void kpidelivery() {
        selkpidelivery.click();
    }

    public void kpiwosearch(String KPIdelWO)
    {
        kpideliverywosearch.sendKeys(KPIdelWO);
    }
    public void editkpidelrec() {
        kpiwonum.click();
    }

    public void CloseWO() {
        CloseWO.click();
    }

    public void GlobalSearch(String GlobalSearch)
    {
        txtGlobalSearch.sendKeys(GlobalSearch);
    }

    public void GlobalSearchLinkSelect()
    {
        linkGlobalSearchSelection.click();
    }

    public void logo() {
        logo.click();
    }

    public void clicklogouticon()
    {
        clickicon.click();
    }
    public void logout()
    {
        btnlogout.click();
    }

    public void certissuancekpi()
    { try {
        certissuanckpiclick.click();
        Thread.sleep(8000);
     } catch(Exception e) {}
    }
    public void ResetButtonClick()
    {
        btnresetClick.click();
    }
    public void ResetbtnCompletedtab() {
        completedbtnreset.click();
    }
    public void wonumbersearch (String wonumber)
    {
        wosearch.sendKeys(wonumber);
    }
    //Selecting Work order by Work order number
    public void selectworkorder()
    {
        selectworkorderclick.click();
    }
    //select work order in folder
    public void selectingfolder(String foldername)
    {
        Foldername.sendKeys(foldername);
    }
    public void clickcloseworkordertab()
    {
        CloseWO.click();
    }

    public void qakpi()
    { try {
        qakpiclick.click();
        Thread.sleep(5000);
    } catch(Exception e) {}
    }
    public void qawo() {
        selqawo.click();
    }

    @FindBy(how = How.ID, using = "kpi7Count")       // Email Needed KPI
    public WebElement emailkpi;
    public void EmailKPI() {
        emailkpi.click();
    }

    @FindBy(how = How.ID, using = "kpi8Count")      // pending responses KPI  kpi8Count
    public WebElement pendingrespkpi;
    public void PendingRespKPI() {
        pendingrespkpi.click();
    }
    @FindBy(how = How.ID, using = "kpi4")          //Incoming Responses KPI
    public WebElement incomingreskpi;
    public void IncomingRespKPI(){
        incomingreskpi.click();
    }

/* Important Instructions tab */

    @FindBy(how = How.ID, using = "tabbtn-important-instruction")  //Important Instr tab
    public WebElement impinstrtab;
    @FindBy(how = How.XPATH, using = "//*[@id='dt-important-instruction_wrapper']/div[1]/div[2]/div/div[2]")  //Reset btn
    public WebElement ImpInstrResetbtn;
    @FindBy(how = How.CSS, using = "#dt-important-instruction > tbody > tr:nth-child(1) > td:nth-child(1) > a") //Clicks WO
    public WebElement ImpInstrwo;

    public void ImportantInstrtab(){
        impinstrtab.click();
    }
    public void ImpReset() {
        ImpInstrResetbtn.click();
    }
    public void ImpInstrWOclick() {
        ImpInstrwo.click();
    }
    public void UpdateImpInstr(String summary) {
        ProcSummary.sendKeys(summary);
        submit.click();
    }

/* /To Be Discarded tab */
    @FindBy(how = How.ID, using = "tabbtn-tobeDiscarded")  //To Be Discarded tab
    public WebElement tobediscardedtab;
    @FindBy(how = How.XPATH, using = "//*[@id='dt-tobeDiscarded_wrapper']/div[1]/div[2]/div/div[2]")
    public WebElement tobediscardedResetbtn;

    public void ToBeDiscardtab(){
        tobediscardedtab.click();
    }
    public void ToBeDiscardReset() {
        tobediscardedResetbtn.click();
    }

    public void ToBeDiscard(String tobediscardwosearch){
        discardwosearch.sendKeys(tobediscardwosearch);
    }

  //Completed tab module
    @FindBy(how = How.CSS, using = "#tabbtncompleted > a")
    public WebElement tpmcompletedtab;
    @FindBy(how = How.ID, using = "WorkOrderNumberCompleted")
    public WebElement tpmsortingwo;
    @FindBy(how = How.CSS, using = "#dtcompleted > thead > tr > th:nth-child(2) > ul > li:nth-child(1) > span")
    public WebElement tpmsortingadddate;
    @FindBy(how = How.ID, using = "ClientCodeCompleted")
    public WebElement tpmsortingclientcode;
    @FindBy(how = How.ID, using = "SummaryCompleted")
    public WebElement tpmsortingsummary;
    @FindBy(how = How.CSS, using = "#th-WorkOrderStatusCompleted > ul > li:nth-child(1) > span")
    public WebElement tpmsortingstatus;
    @FindBy(how = How.CSS, using = "#dtcompleted > thead > tr > th:nth-child(6) > ul > li:nth-child(1) > span")
    public WebElement tpmsortingduedate;
    @FindBy(how = How.CSS, using = "#th-RequestorCompleted > ul > li:nth-child(1) > span")
    public WebElement tpmsortingrequestor;
    @FindBy(how = How.CSS, using = "#th-BranchCompleted > ul > li:nth-child(1) > span")
    public WebElement tpmsortingbranchoffice;
    @FindBy(how = How.CSS, using = "#th-NumberofCertsCompleted > ul > li:nth-child(1) > span")
    public WebElement tpmsortingnoofcerts;
    @FindBy(how = How.CSS, using = "#th-RushBulkCompleted > ul > li:nth-child(1) > span")
    public WebElement tpmsortingrushbulk;
    @FindBy(how = How.CSS, using = "#th-WorkOrderTypeCompleted > ul > li:nth-child(1) > span")
    public WebElement tpmsortingwotype;
    @FindBy(how = How.CSS, using = "#dtcompleted > thead > tr > th:nth-child(15) > ul > li:nth-child(1) > span")
    public WebElement tpmcompleteddate;


    public void completedtab() {
        try {
            tpmcompletedtab.click();
            Thread.sleep(5000);
        } catch (Exception e) { }
    }
    public void sortingwo() {
        tpmsortingwo.click();
    }
    public void sortingadddate() {
        tpmsortingadddate.click();
    }
    public void sortingclientcode() {
        tpmsortingclientcode.click();
    }
    public void sortingsummary() {
        tpmsortingsummary.click();
    }
    public void sortingstatus() {
        tpmsortingstatus.click();
    }
    public void sortingduedate() {
        tpmsortingduedate.click();
    }
    public void sortingrequestor() {
        tpmsortingrequestor.click();
    }
    public void sortingbranchoffice() {
        tpmsortingbranchoffice.click();
    }
    public void sortingnoofcerts() {
        tpmsortingnoofcerts.click();
    }
    public void sortingrushbulk() {
        tpmsortingrushbulk.click();
    }
    public void sortingwotype() {
        tpmsortingwotype.click();
    }
    public void sortingcompletedtype() {
        tpmcompleteddate.click();
    }

    @FindBy(how = How.CSS, using = "#th-WorkOrderStatusCompleted > ul > li:nth-child(2) > span > div > button > span")
    public WebElement tpmstatusclicking;
    @FindBy(how = How.CSS, using = "#th-WorkOrderStatusCompleted > ul > li:nth-child(2) > span > div > ul > li.multiselect-item.multiselect-filter > div > input")
    public WebElement enterstatus;
    @FindBy(how = How.CSS, using = "#th-WorkOrderStatusCompleted > ul > li:nth-child(2) > span > div > ul > li:nth-child(4) > a > label > input[type=\"checkbox\"]")
    public WebElement tpmselectingthestatus;
    @FindBy(how = How.CSS, using = "#th-BranchCompleted > ul > li:nth-child(2) > span > div > button > span")
    public WebElement tpmclickingbranchoffice;
    @FindBy(how = How.CSS, using = "#th-BranchCompleted > ul > li:nth-child(2) > span > div > ul > li.multiselect-item.multiselect-filter > div > input")
    public WebElement tpmenteringbranchoffice;
    @FindBy(how = How.CSS, using = "#th-BranchCompleted > ul > li:nth-child(2) > span > div > ul > li:nth-child(102) > a > label")
    public WebElement tpmselectingthebranchoffice;
    @FindBy(how = How.ID, using = "RushBulkCompleted")  //Rush/Bulk txt box
    public WebElement tpmRushbulk;
   /* @FindBy(how = How.CSS, using = "#th-RushBulkCompleted > ul > li:nth-child(2) > span > div > button")
    public WebElement tpmclickingrushbulk;
    @FindBy(how = How.CSS, using = "#th-RushBulkCompleted > ul > li:nth-child(2) > span > div > ul > li.multiselect-item.multiselect-filter > div > input")
    public WebElement tpmenteringrushbulk;
    @FindBy(how = How.CSS, using = "#th-RushBulkCompleted > ul > li:nth-child(2) > span > div > ul > li:nth-child(5) > a > label > input[type=\"checkbox\"]")
    public WebElement tpmselectingtherushbulk;
    @FindBy(how = How.CSS, using = "#th-RushBulkProcess > ul > li:nth-child(2) > span > div > ul > li:nth-child(5) > a > label > input[type=\"checkbox\"]")
    public WebElement selectingbulk;*/

    public void gridsearch(String colwonumber, String clientcode, String summary, String requestor, String Noofcerts, String Rushbulk, String status, String Branchoffice, String Pending, String Wotype, String Update) {
     /* wosearch.sendKeys(colwonumber);
        clientcodesearch.sendKeys(clientcode);
        summarysearch.sendKeys(summary);
        requestorsearch.sendKeys(requestor);
        numcertssearch.sendKeys(Noofcerts);
        tpmstatusclicking.click();
        enterstatus.sendKeys(status);
        tpmselectingthestatus.click();*/
    }
    public void Compltdwonum (String completedWO) {  //String clientcode, String noofcerts, String rushbulk
        tpmsortingwo.sendKeys(completedWO);
        tpmsortingclientcode.sendKeys("TEST code1");
        tpmsortingsummary.sendKeys("777");
      /*  tpmsortingclientcode.sendKeys(clientcode);
        tpmsortingnoofcerts.sendKeys(noofcerts);
        tpmsortingrushbulk.sendKeys(rushbulk);*/

      /*  try {
            tpmsortingwo.sendKeys(colwonumber);
            Thread.sleep(5000);
            tpmsortingwo.click();
            Thread.sleep(3000);
        } catch(Exception e) {}*/
    }
    public void enteringcolclientcode(String clientcode) {
        try {
            tpmsortingclientcode.sendKeys(clientcode);
            Thread.sleep(4000);
         //   tpmsortingclientcode.clear();
            Thread.sleep(4000);
        } catch (Exception e) {}
    }
    public void enteringcolsummary(String summary) {
        try {
            tpmsortingsummary.sendKeys(summary);
            Thread.sleep(4000);
         //   tpmsortingsummary.clear();
            Thread.sleep(4000);
        } catch (Exception e) {}
    }
    public void enteringcolrequestor(String requestor) {
        try {
            requestorsearch.sendKeys(requestor);
            Thread.sleep(4000);
            requestorsearch.clear();
            Thread.sleep(4000);
        } catch (Exception e) {

        }
    }
    public void enteringcolnoofcerts(String noofcerts) {
        try {
            numcertssearch.sendKeys(noofcerts);
            Thread.sleep(4000);
            numcertssearch.clear();
            Thread.sleep(4000);
        } catch (Exception e) {
        }
    }
    public void enteringthestatus(String status) {
        try {
            tpmstatusclicking.click();
            Thread.sleep(2000);
            enterstatus.sendKeys(status);
            Thread.sleep(2000);
            tpmselectingthestatus.click();
            Thread.sleep(2000);
        } catch (Exception e) {
        }
    }
    public void enteringthebranchoffice(String branchoffice) {
        try {
            tpmclickingbranchoffice.click();
            Thread.sleep(2000);
            tpmenteringbranchoffice.sendKeys(branchoffice);
            Thread.sleep(2000);
            tpmselectingthebranchoffice.click();
            Thread.sleep(2000);
        } catch (Exception e) {
        }
    }
    public void enteringcolrushbulk(String rushbulk) {
        tpmRushbulk.click();
        tpmRushbulk.sendKeys(rushbulk);
        /*try {
            tpmclickingrushbulk.click();
            Thread.sleep(3000);
            tpmenteringrushbulk.sendKeys(rushbulk);
            Thread.sleep(3000);
            selectingbulk.click();
            Thread.sleep(3000);
            tpmselectingtherushbulk.click();
            Thread.sleep(3000);
        } catch (Exception e) { }*/
    }

  // time record admin starts here
    @FindBy(how = How.CSS, using = "#index3")           // Time Record Admin page
    public WebElement tpmclickingtimerecordadmin;

    @FindBy(how = How.CSS, using = "body > div:nth-child(39) > div.datetimepicker-days > table > tbody > tr:nth-child(5) > td:nth-child(2)")   //From Date
    public WebElement starttimeFromdate;
    @FindBy(how = How.CSS, using = "body > div:nth-child(39) > div.datetimepicker-hours > table > tbody > tr > td > fieldset:nth-child(1) > span.hour.active.hour_am")  //From Hour
    public WebElement starttimeFromhour;
    @FindBy(how = How.CSS, using = "body > div:nth-child(39) > div.datetimepicker-minutes > table > tbody > tr > td > fieldset > span:nth-child(6)")  //From Minute
    public WebElement starttimeFromminute;

    @FindBy(how = How.CSS, using = "body > div:nth-child(40) > div.datetimepicker-days > table > tbody > tr:nth-child(5) > td.day.today.active")   //To Date
    public WebElement starttimeTodate;
    @FindBy(how = How.CSS, using = "body > div:nth-child(39) > div.datetimepicker-hours > table > tbody > tr > td > fieldset:nth-child(1) > span.hour.active.hour_am")  //To Hour
    public WebElement starttimeTohour;
    @FindBy(how = How.CSS, using = "body > div:nth-child(39) > div.datetimepicker-minutes > table > tbody > tr > td > fieldset > span:nth-child(6)")  //To Minute
    public WebElement starttimeTominute;


    @FindBy(how = How.CSS, using = "#th-CompanyNameTRA > ul > li:nth-child(1) > span")    // Company
    public WebElement tpmsortingtracompany;
    @FindBy(how = How.CSS, using = "#th-ServiceDescriptionTRA > ul > li:nth-child(1) > span")  //service
    public WebElement tpmsortingtraservice;
    @FindBy(how = How.CSS, using = "#th-TaskDescriptionTRA > ul > li:nth-child(1) > span")    //Task description
    public WebElement tpmsortingtrataskdescription;
    @FindBy(how = How.CSS, using = "#th-WorkOrderNumberTRA > ul > li:nth-child(1) > span")    //WO #
    public WebElement tpmsortingtrawonumber;
    @FindBy(how = How.CSS, using = "#th-EmployeeUserNameTRA > ul > li:nth-child(1) > span")   //enployee
    public WebElement tpmsortingtraemployee;
    @FindBy(how = How.ID, using = "startTimeFrom")   //Start Time From
    public WebElement StarttimeFrom;
    @FindBy(how = How.ID, using = "startTimeTo")   // Start Time To
    public WebElement StarttimeTo;
    @FindBy(how = How.ID, using = "btnRun")  //Run button
    public WebElement Runbtn;
    @FindBy(how = How.CSS, using = "#th-DurationHoursTRA > ul > li:nth-child(1) > span")     // Hours
    public WebElement tpmsortingtrahours;
    @FindBy(how = How.CSS, using = "#th-IsBillableTRA > ul > li > span")    //billable
    public WebElement tpmsortingtrabillable;
    @FindBy(how = How.CSS, using = "#th-IsWorkOrderRequiredTRA > ul > li > span")   //WO Required
    public WebElement tpmsortingtraworequired;

    public void clickingtimerecordadmin() {
        tpmclickingtimerecordadmin.click();
    }
    public void sortingtracompany() {
        tpmsortingtracompany.click();
    }
    public void sortingtraservice() {
        tpmsortingtraservice.click();
    }
    public void sortingtrataskdescription() {
        tpmsortingtrataskdescription.click();
    }
    public void sortingtrawonumber() {
        tpmsortingtrawonumber.click();
    }

    public void sortingtraemployee() {
        tpmsortingtraemployee.click();
    }

    public void sortingtrahours() {
        tpmsortingtrahours.click();
    }

    public void sortingtrabillable() {
        tpmsortingtrabillable.click();
    }

    public void sortingtraworequired() {
        tpmsortingtraworequired.click();  //#th-TaskDescriptionTRA > span > div > ul > li:nth-child(84) > a > label
    }

    @FindBy(how = How.CSS, using = "#th-CompanyNameTRA > span > div > button > span") //#th-CompanyNameTRA > ul > li:nth-child(2) > span > div > button > span
    public WebElement tpmtracompanysearchenteringusi;
    @FindBy(how = How.CSS, using = "#th-CompanyNameTRA > span > div > ul > li.multiselect-item.multiselect-filter > div > input") // #th-CompanyNameTRA > ul > li:nth-child(2) > span > div > ul > li.multiselect-item.multiselect-filter > div > input
    public WebElement tpmtraselectingtheusicompany;
    @FindBy(how = How.CSS, using = "#th-CompanyNameTRA > span > div > ul > li:nth-child(436) > a > label")  // #th-CompanyNameTRA > ul > li:nth-child(2) > span > div > ul > li:nth-child(436) > a > label > input[type="checkbox"]
    public WebElement tpmtraselectingusicompany;
    @FindBy(how = How.CSS, using = "#th-ServiceDescriptionTRA > span > div > button > span")  //#th-ServiceDescriptionTRA > ul > li:nth-child(2) > span > div > button
    public WebElement tpmtraserviceclicking;
    @FindBy(how = How.CSS, using = "#th-ServiceDescriptionTRA > span > div > ul > li.multiselect-item.multiselect-filter > div > input")  //#th-ServiceDescriptionTRA > ul > li:nth-child(2) > span > div > ul > li.multiselect-item.multiselect-filter > div > input
    public WebElement tpmtraservicecertissuance;
    @FindBy(how = How.CSS, using = "#th-ServiceDescriptionTRA > span > div > ul > li:nth-child(47) > a > label") //#th-ServiceDescriptionTRA > ul > li:nth-child(2) > span > div > ul > li:nth-child(47) > a > label > input[type="checkbox"]
    public WebElement tpmtraclickingtheserviceentered;
    @FindBy(how = How.CSS, using = "#th-TaskDescriptionTRA > span > div > button > span")  //#th-TaskDescriptionTRA > ul > li:nth-child(2) > span > div > button > span
    public WebElement tpmtrataskdescriptioncertissuance;
    @FindBy(how = How.CSS, using = "#th-TaskDescriptionTRA > span > div > ul > li.multiselect-item.multiselect-filter > div > input")  //#th-TaskDescriptionTRA > ul > li:nth-child(2) > span > div > ul > li.multiselect-item.multiselect-filter > div > input
    public WebElement tpmtrataskdescriptionentering;
    @FindBy(how = How.CSS, using = "#th-TaskDescriptionTRA > span > div > ul > li:nth-child(84) > a > label")  //#th-TaskDescriptionTRA > ul > li:nth-child(2) > span > div > ul > li:nth-child(84) > a > label > input[type="checkbox"]
    public WebElement tpmtraclickingthetaskdescriptionentered;
    @FindBy(how = How.CSS, using = "#dtTimeRecordAdmin_length > label > select")
    public WebElement tpmtraviewing;
    @FindBy(how = How.ID, using = "WorkOrderNumberTRA")  //WorkOrderNumberTRA
    public WebElement tpmtrworknumber;
    @FindBy(how = How.ID, using = "EmployeeUserNameTRA") //EmployeeUserNameTRA
    public WebElement tpmtremployee;
    @FindBy(how = How.ID, using = "DurationHoursTRA")
    public WebElement tpmtrhours;

    public void TRAStarttime(String From, String To) {
        StarttimeFrom.sendKeys(From);
        StarttimeTo.sendKeys(To);
        Runbtn.click();
    }

    public void traselectingthecompany() {
        tpmtracompanysearchenteringusi.click();
    }
    public void traselectingtheusicompany(String trcompany) {
        tpmtraselectingtheusicompany.sendKeys(trcompany);
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
    public void traselectingtheservice(String trservice) {
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

  //  Editing Time Record Admin record
    @FindBy(how = How.CSS, using = "#dtTimeRecordAdmin > tbody > tr > td:nth-child(1) > center > span")
    public WebElement editingthetimerecord;
    @FindBy(how = How.ID, using = "editTimerecord_task")
    public WebElement editingthetimerecordtask;
    @FindBy(how = How.ID, using = "editTimerecord_start_time")
    public WebElement editingthestarttime;
    @FindBy(how = How.ID, using = "editTimerecord_end_time")
    public WebElement editingtheendtime;
    @FindBy(how = How.ID, using = "editTimerecord_submit")
    public WebElement trasubmitbutton;

    public void editTRAicon() {
        editingthetimerecord.click();
    }
    public void editiingthetimerecordtask(String Trtask, String Trstarttime, String Trendtime) {
        editingthetimerecordtask.sendKeys(Trtask);
        editingthestarttime.clear();
        editingthestarttime.sendKeys(Trstarttime);
        editingtheendtime.clear();
        editingtheendtime.sendKeys(Trendtime);
        trasubmitbutton.click();
    }

 // Discarded tab module
    @FindBy(how = How.CSS, using = "#tabbtndiscarded > a")    //Discarded tab fields
    public WebElement tabDiscarded;
    @FindBy(how = How.ID, using = "WorkOrderNumberDiscarded")  //disacrd WO search
    public WebElement discardwosearch;
    @FindBy(how = How.CSS, using = "#dtdiscarded > tbody > tr > td:nth-child(1) > a")  //usi 11309
    public WebElement linkdiscardedtabwo;
    @FindBy(how = How.ID, using = "cert_Summary")   //Discarded work order fields Summary text box
    public WebElement txtDiscardedWOSummary;
    @FindBy(how = How.ID, using = "cert_Requestor")  // Requestor txtbox
    public WebElement txtDiscardedWORequestor;
    @FindBy(how = How.ID, using = "cert_SentTo")
    public WebElement txtDiscardedWOSentTo;
    @FindBy(how = How.CSS, using = "#container > div.std_title_bar > input:nth-child(2)")
    public WebElement btnDiscardedWOAddAttachmentCancel;
    @FindBy(how = How.ID, using = "index4")         // Reports tab
    public WebElement btnReports;

    public void SelectDiscardedTab()    //Selecting Discarded tab
    {
        tabDiscarded.click();
    }
    public void DiscardWOsearch(String DiscardWOSearch) {
        discardwosearch.sendKeys(DiscardWOSearch);
    }
    public void SelectDiscardedTabWO()   //Selecting work order from discarded tab
    {
        linkdiscardedtabwo.click();
    }
    public void UpdateDiscardedWODetails(String Summary, String Requestor, String SentTo)
    {
        txtDiscardedWOSummary.sendKeys(Summary);
        txtDiscardedWORequestor.clear();
        txtDiscardedWORequestor.sendKeys(Requestor);
        txtDiscardedWOSentTo.sendKeys(SentTo);
    }
    public void DiscardedWOSubmit()
    {
        submit.click();
    }

    public void SelectWOStartTimerTask(String task)
    {
        seltask.sendKeys(task);
    }
    public void ReportsButton()
    {
        btnReports.click();
    }

// Incoming Responses tab
    @FindBy(how = How.XPATH, using = "//*[@id='tabbtn-incoming-responses1']")
    public WebElement IncomingResponsetab;
    @FindBy(how = How.ID, using = "WorkOrderNumberIncoming")
    public WebElement IncomingResWOsearch;
    @FindBy(how = How.XPATH, using = "//*[@id='dt-incoming-responses_wrapper']/div[1]/div[2]/div/div[2]")
    public WebElement IncomingRespResetbtn;

    public void IncomingResp() {
        IncomingResponsetab.click();
    }
    public void IncReset(){
        IncomingRespResetbtn.click();
    }
    public void IncReswosearch(String IncResWO) {
        IncomingResWOsearch.sendKeys(IncResWO);
    }
    public void IncResWOclick() {
        woclick.click();
    }

 /*   ------Get Text for Submit WO pop-up---*/
    @FindBy(how = How.CSS, using = "body > div.jconfirm.jconfirm-light.jconfirm-open > div.jconfirm-scrollpane > div > div > div > div > div > div > div > div.jconfirm-content-pane.no-scroll")  //Pop-up submit text
    public WebElement sbt;

    public void submit1() {
        String innerText= sbt.getText();
        System.out.println("Inner text is :"+innerText); }

  //  @FindBy(how = How.XPATH, using = "//*[@id='jconfirm-box41969']/div/font/b")  //Wo# value
    @FindBy(how = How.CSS, using = "#jconfirm-box79225 > div > font > b")
    public WebElement popwonum;

    public void WOvalue() {
        String Tx = popwonum.getText();
        System.out.println("Inner text WO number is :" +wosearch);

        Clickclosepopup.click();
        try {
            Thread.sleep(10000);
            System.out.println("Enter value");
            wosearch.sendKeys(Tx);
        } catch(Exception e) { }
    }

    /*   ------Get Row colors text*/

    @FindBy(how = How.XPATH, using = "//*[@id=\"tabprocessing\"]/div/div[1]/div/span[2]/div")
    public WebElement rowWhite;
    @FindBy(how = How.XPATH, using = "//*[@id=\"tabprocessing\"]/div/div[1]/div/span[3]/div")
    public WebElement rowYellow;
    @FindBy(how = How.XPATH, using = "//*[@id=\"tabprocessing\"]/div/div[1]/div/span[4]/div")
    public WebElement rowGreen;
    @FindBy(how = How.XPATH, using = "//*[@id=\"tabprocessing\"]/div/div[1]/div/span[5]/div")
    public WebElement rowOrange;
    @FindBy(how = How.XPATH, using = "//*[@id=\"tabprocessing\"]/div/div[1]/div/span[6]/div")
    public WebElement rowLightPink;
    @FindBy(how = How.XPATH, using = "//*[@id=\"tabprocessing\"]/div/div[1]/div/span[7]/div")
    public WebElement rowPink;
    @FindBy(how = How.XPATH, using = "//*[@id=\"tabprocessing\"]/div/div[1]/div/span[8]/div")
    public WebElement rowDarkPink;
    @FindBy(how = How.XPATH, using = "//*[@id=\"tabprocessing\"]/div/div[1]/div/span[9]/div")
    public WebElement rowRed;
    @FindBy(how = How.XPATH, using = "//*[@id=\"tabprocessing\"]/div/div[1]/div/span[10]/div")
    public WebElement rowBlue;


    public void rowcolorstext() {

        String value1= rowWhite.getAttribute("title");
        System.out.println("Row White Text is :"+value1);
        String value2= rowYellow.getAttribute("title");
        System.out.println("Row Yellow Text is :"+value2);
        String value3= rowGreen.getAttribute("title");
        System.out.println("Row Green Text is :"+value3);
        String value4= rowOrange.getAttribute("title");
        System.out.println("Row Orange Text is :"+value4);
        String value5= rowLightPink.getAttribute("title");
        System.out.println("Row Light Pink Text is :"+value5);
        String value6= rowPink.getAttribute("title");
        System.out.println("Row Pink Text is :"+value6);
        String value7= rowDarkPink.getAttribute("title");
        System.out.println("Row Dark Pink Text is :"+value7);
        String value8= rowRed.getAttribute("title");
        System.out.println("Row Red Text is :"+value8);
        String value9= rowBlue.getAttribute("title");
        System.out.println("Row Blue Text is :"+value9);
    }

    /*   ------Size of table and pagination*/
    @FindBy(how = How.XPATH, using = "//*[@id=\"dtprocessing\"]")
    public WebElement pagination;
    @FindBy(how = How.XPATH, using = "//*[@id=\"dtprocessing_length\"]/label/select")
    public WebElement pvalue;


    public void pagin(String Pagevalue)
    {
        pvalue.sendKeys(Pagevalue);
    }

    public void pagin1()
    {
        List<WebElement> TotalRowsList = pagination.findElements(By.tagName("tr"));
        System.out.println("Total no of rows in table:"+(TotalRowsList.size()-1));
    }

    /*   ------Get Value for KPI*/
    @FindBy(how = How.XPATH, using = "//*[@id=\"kpi1Available_new\"]")
    public WebElement CIkpiValueAvailable;
    @FindBy(how = How.XPATH, using = "//*[@id=\"kpi1Count_new\"]")
    public WebElement CIkpiValueTotal;
    @FindBy(how = How.XPATH, using = "//*[@id=\"kpi2Available_new\"]")
    public WebElement QAkpiValueAvailable;
    @FindBy(how = How.XPATH, using = "//*[@id=\"kpi2Count_new\"]")
    public WebElement QAkpiValueTotal;
    @FindBy(how = How.XPATH, using = "//*[@id=\"kpi3Available_new\"]")
    public WebElement DeliverykpiValueAvailable;
    @FindBy(how = How.XPATH, using = "//*[@id=\"kpi3Count_new\"]")
    public WebElement DeliverykpiValueTotal;
    @FindBy(how = How.XPATH, using = "//*[@id=\"kpi4Count_new\"]")
    public WebElement IRkpiValueTotal;
    @FindBy(how = How.XPATH, using = "//*[@id=\"kpi5Count_new\"]")
    public WebElement EMkpiValueTotal;
    @FindBy(how = How.XPATH, using = "//*[@id=\"kpi6Count_new\"]")
    public WebElement PRkpiValueTotal;
    @FindBy(how = How.XPATH, using = "//*[@id=\"kpi7Count_new\"]")
    public WebElement DuekpiValueTotal;
    @FindBy(how = How.XPATH, using = "//*[@id=\"kpi8Count_new\"]")
    public WebElement PastDuekpiValueTotal;

    public void CIKPIvalue() {
        String CIKPIAvailableCount = CIkpiValueAvailable.getText();
        System.out.println("Certificate Issuance Available Count is :" + CIKPIAvailableCount);
        String CIKPITotalCount = CIkpiValueTotal.getText();
        System.out.println("Certificate Issuance Total Count is :" + CIKPITotalCount);
    }
    public void QAKPIvalue() {
        String QAKPIAvailableCount = QAkpiValueAvailable.getText();
        System.out.println("Quality Assurance Available Count is :" + QAKPIAvailableCount);
        String QAKPITotalCount = QAkpiValueTotal.getText();
        System.out.println("Quality Assurance Total Count is :" + QAKPITotalCount);
    }
    public void DelKPIvalue() {
        String DeliveryKPIAvailableCount = DeliverykpiValueAvailable.getText();
        System.out.println("Delivery Available Count is :" + DeliveryKPIAvailableCount);
        String DeliveryKPITotalCount = DeliverykpiValueTotal.getText();
        System.out.println("Delivery Total Count is :" + DeliveryKPITotalCount);
    }
    public void EmailKPIvalue() {
        String EMKPITotalCount = EMkpiValueTotal.getText();
        System.out.println("Email Needed Total Count is :" + EMKPITotalCount);
    }
    public void PendingKPIValue() {
        String PRKPITotalCount = PRkpiValueTotal.getText();
        System.out.println("Pending Responses Total Count is :" + PRKPITotalCount);
    }
    public void IncomingKPIValue() {
        String IRKPITotalCount = IRkpiValueTotal.getText();
        System.out.println("Incoming Response Total Count is :" + IRKPITotalCount);
    }
    public void Due30(){
        String DueKPITotalCount = DuekpiValueTotal.getText();
        System.out.println("Due in 30 Mins Total Count is :" + DueKPITotalCount);
    }
    public void PastDueKPIvalue() {
        String PastKPITotalCount = PastDuekpiValueTotal.getText();
        System.out.println("Past Due Total Count is :" + PastKPITotalCount);
    }

    /*  --- Using Robot class for Window Handling Pop -Up */

}


