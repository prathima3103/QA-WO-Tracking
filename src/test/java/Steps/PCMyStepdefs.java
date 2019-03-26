package Steps;

import Base.BaseUtil;
import Pages.PCLoginpage;
import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.ro.Si;
import gherkin.formatter.model.DataTableRow;
import gherkin.lexer.De;
import gherkin.lexer.Th;
import javafx.scene.control.Tab;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import javax.xml.soap.Detail;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class PCMyStepdefs extends BaseUtil {

    public PCMyStepdefs(BaseUtil base) {
        this.base = base;
    }

    private BaseUtil base;

    @Given("^I navigate to login page of policy checking app$")
    public void iNavigateToLoginPageOfPolicyCheckingAppForPC() {
        System.out.println("Navigates to Login page");
        base.driver.get("https://dev.patracorp.net");
        base.driver.manage().window().maximize();
    }

    @And("^I enter login credentials for PC$")
    public void iEnterLoginCredentialsForPC(DataTable table) {
        System.out.println("Entering email address and password");
        //create arraylst
        List<SignIn> users = new ArrayList<SignIn>();
        users = table.asList(SignIn.class);
        PCLoginpage page = new PCLoginpage(base.driver);
        for (SignIn user : users) {
            page.Login(user.email, user.password);
        }
    }

    public class SignIn {
        public String email, password;

        public SignIn(String Email, String Password) {
            email = Email;
            password = Password;
        }
    }

    @And("^I click on Sign In button for PC$")
    public void iClickOnSignInButtonForPC() throws Throwable {
        System.out.println("Clicks Sign In button");
        PCLoginpage page = new PCLoginpage(base.driver);
        page.SignInButton();
        Thread.sleep(10000);
        page.policyCheckingLink();
        Thread.sleep(10000);
    /*    String currentWindow = base.driver.getWindowHandle();
        base.driver.switchTo().window(currentWindow);*/
        String parentWindow = base.driver.getWindowHandle();
        Set<String> handles = base.driver.getWindowHandles();
        for (String windowHandle : handles) {
            if (!windowHandle.equals(parentWindow)) {
                base.driver.switchTo().window(windowHandle);
            }
        }
    }

    @And("^I select a client for PC$")
    public void iSelectAClientForPC(DataTable table) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("Selecting a client / service");
        List<pickclient> clients = new ArrayList<pickclient>();
        clients = table.asList(pickclient.class);
        PCLoginpage page = new PCLoginpage(base.driver);
        Thread.sleep(5000);
        for (pickclient client : clients) {
            page.pickClient(client.company);
            Thread.sleep(5000);
        }
    }

    public class pickclient {
        public String company, service;

        public pickclient(String Company, String Service) {
            company = Company;
            service = Service;
        }
    }

    @And("^I change client from dropdown list for PC$")
    public void iChangeClientFromDropdownListForPC(DataTable table) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("Changes company");
        List<pickclient> clients = new ArrayList<pickclient>();
        clients = table.asList(pickclient.class);
        PCLoginpage page = new PCLoginpage(base.driver);
        Thread.sleep(2000);
        for (pickclient client : clients) {
            page.changeComp(client.company);
        }
    }

    @And("^I click on the selected client to open app for PC$")
    public void iClickOnTheSelectedClientToOpenAppForPC() throws Throwable {
        System.out.println("Clicks client to open app");
        PCLoginpage page = new PCLoginpage(base.driver);
        Thread.sleep(10000);
        page.gotoClient();
        Thread.sleep(50000);
    }

    @And("^Pagination value for PC")
    public void paginationValueForPC(DataTable table) throws Throwable {
        List<pagin> pages = new ArrayList<pagin>();
        pages = table.asList(pagin.class);
        PCLoginpage page = new PCLoginpage(base.driver);
        for (pagin page1 : pages) {
            page.pagin(page1.pagevalue);
        }
        Thread.sleep(5000);
        page.pagin1();
    }

    public class pagin {
        public String pagevalue;

        public pagin(String Pagevalue) {
            pagevalue = Pagevalue;
        }
    }

    @And("^Row text for PC")
    public void rowTextForPC() throws Throwable {
        Thread.sleep(5000);
        PCLoginpage page = new PCLoginpage(base.driver);
        page.rowColorsText();
    }

    @Then("^I Click on Add Policy for PC$")
    public void iClickOnAddWorkOrderForPC() throws Throwable {
        System.out.println("clicks ADD Policy");
        PCLoginpage page = new PCLoginpage(base.driver);
        Thread.sleep(10000);
        page.clickAddPolicy();
        Thread.sleep(10000);
    }

    @Then("^I Enter Add WorkOrder Details for PC$")
    public void iEnterAddWorkOrderDetailsForPC(DataTable table) throws Throwable {
        System.out.println("Entering ADD WO details");
        List<policyAddWorkOrder> users = new ArrayList<policyAddWorkOrder>();
        users = table.asList(policyAddWorkOrder.class);
        PCLoginpage page = new PCLoginpage(base.driver);
        Thread.sleep(12000);
        for (policyAddWorkOrder user : users) {
            page.addPolicyButton(user.folder,user.addRequestor,user.addSummary,user.addSentTo);
        }
        Thread.sleep(5000);
    }

    public class policyAddWorkOrder {
        public String folder, addRequestor, addSummary, addSentTo;

        public policyAddWorkOrder(String Folder,String AddRequestor, String AddSentTo, String AddSummary) {
          /*this.addwoprocess = addwoprocess;
            this.addwoisassign = addwoisassign;
            this.addwoishold = addwoishold;
            this.addwoisemail = addwoisemail;
            this.addwoisdiscard = addwoisdiscard;
            this.addwoisdelivered = addwoisdelivered;
            this.addwoistaskcompleted = addwoistaskcompleted;
            this.addwoholdreason = addwoholdreason;
            this.addwoupdate = addwoupdate;
            this.addwofrompending = addwofrompending;
            this.addworush = addworush;
            this.addwobulk = addwobulk;
            this.addwoassignto = addwoassignto;
            this.addwostatus = addwostatus;
            this.addwofolder = addwofolder;*/
            this.addRequestor = AddRequestor;
            this.addRequestor = AddSentTo;
            this.addRequestor = AddSummary;
            this.folder = Folder;
         /*this.addwoassignedto = addwoassignedto;
            this.addwoadddate = addwoadddate;
            this.addwostartdateoverride = addwostartdateoverride;
            this.addwoduedateoverride = addwoduedateoverride;
            this.addwoduedate = addwoduedate;*/
        }
    }

    @Then("^I go to Work Order Details section for PC$")
    public void iGoToWorkOrderDetailsSectionForPC() throws Throwable {
        PCLoginpage page = new PCLoginpage(base.driver);
        page.woDetailSection();
        Thread.sleep(5000);
    }

    @Then("^I Enter details in WO detail section for PC$")
    public void iEnterDetailsInWODetailSectionForPC(DataTable table) throws Throwable {
        List<woDetailSection> users = new ArrayList<woDetailSection>();
        users = table.asList(woDetailSection.class);
        Thread.sleep(4000);
        PCLoginpage page = new PCLoginpage(base.driver);
        for (woDetailSection user : users) {
            page.woDetailSectionEntry(user.clientCode, user.clientName, user.policyType, user.linesOfCoverage, user.csr, user.policyStatus,
                    user.carrierName, user.am, user.policyDetails, user.noOf, user.noOfDocumentsRetrieved, user.policyNumber, user.effectiveDate,
                    user.branchOffice, user.department, user.division, user.profitCenter, user.policyCheckedBy, user.qaBy, user.deliveryBy,
                    user.secondQa, user.secondCheckDocument, user.thirdCheckDocument, user.policyCheckedAgainst, user.noOfAI, user.noOfCoverages, user.noOfDocuments, user.noOfEndorsements,
                    user.noOfHazards,user.noOfIMItems,user.noOfLocations,user.noOfVehicles,user.requestFor,
                    user.billingType, user.complexityType, user.comments);
        }
    }

    public class woDetailSection {
        public String clientCode, clientName, policyType, linesOfCoverage, csr, policyStatus, carrierName, am, policyDetails, fullForms, noOf, noOfDocumentsRetrieved, policyNumber, effectiveDate,
                branchOffice, department, division, profitCenter, policyCheckedBy, qaBy, deliveryBy, secondQa, secondCheckDocument, thirdCheckDocument, policyCheckedAgainst, noOfAI, noOfCoverages,
                noOfDocuments, noOfEndorsements, noOfHazards, noOfIMItems, noOfLocations, noOfVehicles, requestFor, billingType, complexityType, comments ;

        public woDetailSection(String ClientCode, String ClientName, String PolicyType, String LinesOfCoverage, String Csr,
                               String PolicyStatus, String CarrierName, String Am, String PolicyDetails, String FullForms,
                               String NoOf,String NoOfDocumentsRetrieved, String PolicyNumber, String EffectiveDate, String BranchOffice,
                               String Department,String Division, String ProfitCenter, String PolicyCheckedBy, String QaBy, String DeliveryBy,
                               String SecondQa, String SecondCheckDocument, String ThirdCheckDocument,String PolicyCheckedAgainst,String NoOfAI, String NoOfCoverages,
                               String NoOfDocuments, String NoOfEndorsements,String NoOfHazards, String NoOfIMItems, String NoOfLocations, String NoOfVehicles,
                               String RequestFor,String BillingType, String ComplexityType,String Comments)
        {
            this.clientCode = ClientCode;
            this.clientName = ClientName;
            this.policyType = PolicyType;
            this.linesOfCoverage = LinesOfCoverage;
            this.csr = Csr;
            this.policyStatus =PolicyStatus;
            this.carrierName =CarrierName;
            this.am =Am;
            this.policyDetails =PolicyDetails;
            this.fullForms =FullForms;
            this.noOf =NoOf;
            this.noOfDocumentsRetrieved =NoOfDocumentsRetrieved;
            this.policyNumber =PolicyNumber;
            this.effectiveDate =EffectiveDate;
            this.branchOffice =BranchOffice;
            this.department =Department;
            this.division =Division;
            this.profitCenter =ProfitCenter;
            this.policyCheckedBy =PolicyCheckedBy;
            this.qaBy =QaBy;
            this.deliveryBy =DeliveryBy;
            this.secondQa =SecondQa;
            this.secondCheckDocument =SecondCheckDocument;
            this.thirdCheckDocument =ThirdCheckDocument;
            this.policyCheckedAgainst = PolicyCheckedAgainst;
            this.noOfAI =NoOfAI;
            this.noOfCoverages =NoOfCoverages;
            this.noOfDocuments =NoOfDocuments;
            this.noOfEndorsements = NoOfEndorsements;
            this.noOfHazards=NoOfHazards;
            this.noOfIMItems=NoOfIMItems;
            this.noOfLocations=NoOfLocations;
            this.noOfVehicles=NoOfVehicles;
            this.requestFor=RequestFor;
            this.billingType =BillingType;
            this.complexityType =ComplexityType;
            this.comments = Comments;
    }
}
    @Then("^I Click on Original Email for PC$")
    public void iClickOnOriginalEmailForPC() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        PCLoginpage page = new PCLoginpage(base.driver);
        Thread.sleep(3000);
        page.originalEmail();
    }

    @Then("^I Write data in Original Email section for PC$")
    public void iWriteDataInOriginalEmailSectionForPC(DataTable table) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        List<descriptionOfOriginalEmail> users = new ArrayList<descriptionOfOriginalEmail>();
        users = table.asList(descriptionOfOriginalEmail.class);
        Thread.sleep(4000);
        PCLoginpage page = new PCLoginpage(base.driver);
        for (descriptionOfOriginalEmail user : users) {
            page.descriptionOfOriginalEmail(user.originalEmail);
        }
    }

    public class descriptionOfOriginalEmail
    {
        public String originalEmail;

        public descriptionOfOriginalEmail(String originalEmail)
        {
            this.originalEmail = originalEmail;
        }
    }
    @Then("^I Enter details in QA section for PC$")
    public void iEnterDetailsInQASectionForPC(DataTable table) throws Throwable
    {
        // Write code here that turns the phrase above into concrete actions
        List<qaDetailSection> users = new ArrayList<qaDetailSection>();
        users = table.asList(qaDetailSection.class);
        Thread.sleep(4000);
        PCLoginpage page = new PCLoginpage(base.driver);
        for (qaDetailSection user : users) {
            page.qaDetailSectionEntry(user.qa, user.noOfErrors, user.errorMadeBy, user.errorType, user.errorFiledBy,user.errorDescription);
        }
    }
        public class qaDetailSection {
            public String qa, noOfErrors, errorMadeBy, errorType, errorFiledBy, errorDescription;

            public qaDetailSection(String Qa, String NoOfErrors, String ErrorMadeBy, String ErrorType, String ErrorFiledBy, String ErrorDescription) {
                this.qa = Qa;
                this.noOfErrors = NoOfErrors;
                this.errorMadeBy = ErrorMadeBy;
                this.errorType = ErrorType;
                this.errorFiledBy = ErrorFiledBy;
                this.errorDescription=ErrorDescription;
            }
        }

        @Then("^I click on Submit button for PC$")
        public void iClickOnSubmitButtonForPC() throws Throwable {
            // Write code here that turns the phrase above into concrete actions
            PCLoginpage page = new PCLoginpage(base.driver);
            Thread.sleep(8000);
            page.addPolicySubmitButton();
            Thread.sleep(8000);
        }

         @Then("^I Get WO number for PC$")
         public void iGetWONumberForPC() throws Throwable {
            System.out.println("WO number");
             PCLoginpage page = new PCLoginpage(base.driver);
            Thread.sleep(2000);
            page.woValue();
    }

         @Then("^I Click on Close on Popup for PC$")
         public void iClickOnCloseOnPopupForPC() throws Throwable {
           // Write code here that turns the phrase above into concrete actions
             PCLoginpage page = new PCLoginpage(base.driver);
            page.clickClosePopup();
            Thread.sleep(4000);
       }
         @And("^I search a record with the wo number for PC$")
         public void iSearchARecordWithTheWoNumberForPC(DataTable table) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
            System.out.println("Searches KPI record");
            List<WorkOrderSearch> workOrderSearches = new ArrayList<WorkOrderSearch>();
            workOrderSearches = table.asList(WorkOrderSearch.class);
             PCLoginpage page = new PCLoginpage(base.driver);
            Thread.sleep(20000);
            for (WorkOrderSearch workOrderSearch : workOrderSearches) {
            page.WorkOrderSearch(workOrderSearch.wo, workOrderSearch.clientcode, workOrderSearch.summary);
            }
            Thread.sleep(10000);
        }
        public class wonumbersearch {
        public String wonumber;

        public wonumbersearch(String wonumber) {
            this.wonumber = wonumber;
        }
        }

        public class WorkOrderSearch {
        public String wo, clientcode, summary;

        public WorkOrderSearch(String WorkOrder, String ClientCode, String Summary) {
            wo = WorkOrder;
            clientcode = ClientCode;
            summary = Summary;
        }
        }
    @And("^I search with the following WO number for PC$")
    public void iSearchWithTheFollowingWONumberForPC(DataTable table) throws Throwable {
        List<wonumbersearch> users = new ArrayList<wonumbersearch>();
        users = table.asList(wonumbersearch.class);
        Thread.sleep(8000);
        PCLoginpage page = new PCLoginpage(base.driver);
        for (wonumbersearch user : users) {
            page.wonumbersearch(user.wonumber);
        }
        Thread.sleep(3000);
    }

        @And("^I select a WO under Processing tab for PC$")
        public void iSelectAWOUnderProcessingTabForPC() throws Throwable {
            System.out.println("Clicks WO In Process");
            PCLoginpage page = new PCLoginpage(base.driver);
            page.SelWO();
            Thread.sleep(8000);
    }

        @And("^I assign that WO for PC$")
        public void iAssignThatWOForPC() throws Throwable {
            System.out.println("Assigning WO on my name");
            PCLoginpage page = new PCLoginpage(base.driver);
            page.Assign();
            Thread.sleep(6000);
    }

        @And("^I click Mark Rush button for PC$")
        public void iClickMarkRushButtonForPC() throws Throwable {
            System.out.println(" Clicks Mark Rush button");
            PCLoginpage page = new PCLoginpage(base.driver);
            Thread.sleep(3000);
            page.markRush();
    }

         @And("^i click start timer button in the WO form for PC$")
        public void iClickStartTimerButtonInTheWOFormForPC() throws Throwable {
            System.out.println("clicks start timer button");
            PCLoginpage page = new PCLoginpage(base.driver);
            Thread.sleep(2000);
            page.woTimer();
    }

        @And("^I clicks start timer in timer pop-up section for PC$")
        public void IclicksStartTimerInTimerPopUpSectionForPC() throws Throwable {
            System.out.println("Hit start timer counts");
            PCLoginpage page = new PCLoginpage(base.driver);
            Thread.sleep(5000);
            page.startTimer();
    }

        @And("^I enter details in the WO form for PC$")
         public void iEnterDetailsInTheWOFormForPC(DataTable table) throws Throwable {
            List<SelectProcessingWOform> actionbar = new ArrayList<SelectProcessingWOform>();
        //Stores data
            actionbar = table.asList(SelectProcessingWOform.class);
            PCLoginpage page = new PCLoginpage  (base.driver);
            Thread.sleep(5000);
            System.out.println("Enter details in WO form");
            for (SelectProcessingWOform woactionbar : actionbar) {
            page.SelectProcessingWOform(woactionbar.wo, woactionbar.assignedto, woactionbar.rush, woactionbar.frompending, woactionbar.update, woactionbar.process, woactionbar.isassigned, woactionbar.ishold,
                    woactionbar.isemail, woactionbar.isdiscard, woactionbar.isdelivered, woactionbar.istaskcompleted, woactionbar.status, woactionbar.folder, woactionbar.startdateoverride,
                    woactionbar.duedateovrride, woactionbar.holdreason, woactionbar.assignto, woactionbar.summary, woactionbar.requestor, woactionbar.sentto);
        }
    }
    public class SelectProcessingWOform {
        public String wo, adddate, duedate, assignedto, rush, frompending, update, process, isassigned, ishold, isemail, isdiscard, isdelivered, istaskcompleted, status, folder, startdateoverride,
                duedateovrride, holdreason, assignto, summary, requestor, sentto ;

        public SelectProcessingWOform(String WO, String AddDate, String DueDate, String AssignedTo, String IsHold, String Rush, String FromPending, String Update, String Process, String IsAssigned, String IsEmail,
                                      String IsDiscard, String IsDelivered, String IsTaskCompleted, String Status, String Folder, String StartDateOverride, String DueDateOvrride, String Holdreason, String Assignto,
                                      String Summary, String Requestor, String Sentto) {
            wo = WO;
            adddate = AddDate;
            duedate = DueDate;
            assignedto = AssignedTo;
            ishold = IsHold;
            rush = Rush;
            frompending = FromPending;
            update = Update;
            process = Process;
            isassigned = IsAssigned;
            isemail = IsEmail;
            isdiscard = IsDiscard;
            isdelivered = IsDelivered;
            istaskcompleted = IsTaskCompleted;
            status = Status;
            folder = Folder;
            startdateoverride = StartDateOverride;
            duedateovrride = DueDateOvrride;
            holdreason = Holdreason;
            assignto = Assignto;
            summary = Summary;
            requestor = Requestor;
            sentto = Sentto;
        }
    }

    @And("^I click Attachments tab for PC$")
    public void iClickAttachmentsTabForPC() throws Throwable {
        System.out.println("Attachments tab");
        PCLoginpage page = new PCLoginpage(base.driver);
        page.Attachments();
        Thread.sleep(5000);
    }

    @And("^I click Emails tab for PC$")
    public void iClickEmailsTabForPC() throws Throwable {
        System.out.println("Emails tab");
        PCLoginpage page = new PCLoginpage(base.driver);
        page.Emails();
        Thread.sleep(5000);
    }

    @And("^I click QA tab for PC$")
    public void iClickQATabForPC() throws Throwable {
        System.out.println("QA tab");
        PCLoginpage page = new PCLoginpage(base.driver);
        Thread.sleep(4000);
        page.QA();
        Thread.sleep(4000);
    }

    @And("^I click History tab for PC$")
    public void iClickHistoryTabForPC() throws Throwable {
        System.out.println("History tab");
        PCLoginpage page = new PCLoginpage(base.driver);
        page.History();
        Thread.sleep(5000);
    }

    @And("^I click Time Records tab for PC$")
    public void iClickTimeRecordsTabForPC() throws Throwable{
        System.out.println("Time Records tab");
        PCLoginpage page = new PCLoginpage(base.driver);
        page.TimeRecords();
        Thread.sleep(5000);
    }
    @And("^I click Add Attachments button for PC$")
    public void iClickAddAttachmentsButtonForPC() throws Throwable {
        System.out.println("Add Attachments");
        PCLoginpage page = new PCLoginpage(base.driver);
        Thread.sleep(2000);
        page.AddAttach();
        String currentWindow = base.driver.getWindowHandle();
        base.driver.switchTo().window(currentWindow);
    }

    @And("^I clicks stop timer button for PC$")
    public void IclicksStopTimerButtonForPC() throws Throwable {
        System.out.println("Hit stop timer ends");
        PCLoginpage page = new PCLoginpage(base.driver);
        Thread.sleep(5000);
        page.stoptimer();
    }

    @And("^I click on Print PDF button for PC$")
    public void iClickOnPrintPDFButtonForPC() throws Throwable {
        System.out.println("Clicks print pdf");
        PCLoginpage page = new PCLoginpage(base.driver);
        page.printpdf();
        Thread.sleep(10000);
        String currentWindow = base.driver.getWindowHandle();
        base.driver.switchTo().window(currentWindow);
    }

    @And("^I click Time Records page link for PC$")
    public void iClickTimeRecordsPageLinkForPC() throws Throwable {
        System.out.println("Clicks Time Records page");
        PCLoginpage page = new PCLoginpage(base.driver);
        Thread.sleep(10000);
        page.TimeRecordsGrid();
    }

    @Then("^I Close the work order for PC$")
    public void iCloseTheWorkOrderForPC() throws Throwable {
        PCLoginpage page = new PCLoginpage(base.driver);
        Thread.sleep(8000);
        page.clickcloseworkordertab();
        Thread.sleep(4000);
    }

    @And("^I click on WorkOrders page link for PC$")
    public void iClickOnWorkOrdersPageLinkForPC() {
        System.out.println("Clicks Work Orders");
        PCLoginpage page = new PCLoginpage(base.driver);
        page.WOgrid();
    }

    @Then("^I Click on Policies to Check KPI for PC$")
    public void iClickOnPoliciesToCheckKPIForPC() throws Throwable {
        System.out.println("Clicks KPI - Policies to Check");
        PCLoginpage page = new PCLoginpage(base.driver);
        page.PoliciesToCheckKpi();
        Thread.sleep(10000);
    }

    @And("^I Selects Workorder for PC$")
    public void iSelectsWorkorderForPC() throws Throwable {
        PCLoginpage page = new PCLoginpage(base.driver);
        page.selectworkorder();
        Thread.sleep(11000);
    }

    @And("^I edit WO fields for PC$")
    public void iEditWOFieldsForPC() throws Throwable {
        System.out.println("edits WO");
        PCLoginpage page = new PCLoginpage(base.driver);
        Thread.sleep(5000);
        page.EditWO();
    }

    @And("^I assign that WO with process qa for PC$")
    public void iAssignThatWOWithProcessQaForPC() throws Throwable {
        System.out.println("Set process to QA");
        PCLoginpage page = new PCLoginpage(base.driver);
        page.AssignQA();
        Thread.sleep(6000);
    }

    @And("I assign that WO with folder Incoming Responses for PC$")
    public void iAssignThatWOWithFolderIncomingResponsesForPC() throws Throwable {
        System.out.println("Moving folder to Incoming Responses");
        PCLoginpage page = new PCLoginpage(base.driver);
        Thread.sleep(2000);
        page.folderIR();
    }

    @And("I assign that WO with folder Pending Responses for PC$")
    public void iAssignThatWOWithFolderPendingResponsesForPC() throws Throwable {
        System.out.println("Moving folder to Incoming Responses");
        PCLoginpage page = new PCLoginpage(base.driver);
        Thread.sleep(2000);
        page.folderPR();
    }

    @And("^I clicks Reset button for Processing for PC$")
    public void iClicksResetButtonForProcessingForPC() throws Throwable {
        System.out.println("Click On Reset button");
        PCLoginpage page = new PCLoginpage(base.driver);
        Thread.sleep(2000);
        page.ProcReset();
    }

    @Then("^I Click on Checklist Processing KPI for PC$")
    public void iClickOnChecklistProcessingKPIForPC() throws Throwable {
        System.out.println("Clicks KPI - Checklist Processing");
        PCLoginpage page = new PCLoginpage(base.driver);
        page.checklistProcessingKpi();
        Thread.sleep(6000);
    }

    @Then("^I Click on Quality Assurance KPI for PC$")
    public void iClickOnQualityAssuranceKPIForPC() throws Throwable {
        System.out.println("Clicks KPI - QA");
        PCLoginpage page = new PCLoginpage(base.driver);
        page.qakpi();
        Thread.sleep(6000);
    }

    @And("^I click selected QA WO for PC$")
    public void iClickSelectedQAWOForPC() throws Throwable {
        System.out.println("clicks QA WO");
        PCLoginpage page = new PCLoginpage(base.driver);
        page.qaWo();
        Thread.sleep(10000);
    }

    @And("^I click KPI Delivery for PC$")
    public void iClickKPIDeliveryForPC() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("KPI Delivery");
        PCLoginpage page = new PCLoginpage(base.driver);
        Thread.sleep(4000);
        page.kpidelivery();
    }

    @And("^Get the KPI Value for Policies to Check$")
    public void getTheKPIValueForPoliciesToCheck() throws Throwable {
        System.out.println("Policies to check KPI Count is : + PoliciesToCheckCount");
        Thread.sleep(5000);
        PCLoginpage page = new PCLoginpage(base.driver);
        page.PoliciestocheckKPIvalue();
    }

    @And("^Get the KPI Value for Checklist Processing$")
    public void getTheKPIValueForChecklistProcessing() throws Throwable {
        System.out.println("Checklist Processing KPI Count is : + ChecklistProcessingCount");
        Thread.sleep(5000);
        PCLoginpage page = new PCLoginpage(base.driver);
        page.ChecklistKPIvalue();
    }

    @And("^Get the KPI Value for Quality Assurance$")
    public void getTheKPIValueForQualityAssurance() throws Throwable {
        System.out.println("Quality Assurance KPI Count is : + QAKPICount");
        Thread.sleep(5000);
        PCLoginpage page = new PCLoginpage(base.driver);
        page.QAKPIvalue();
    }

    @And("^Get the KPI Value for Policy Delivery$")
    public void getTheKPIValueForPolicyDelivery() throws Throwable {
        System.out.println("Policy Delivery KPI Count is : + DeliveryKPICount");
        Thread.sleep(5000);
        PCLoginpage page = new PCLoginpage(base.driver);
        page.PolicyDeliveryKPIvalue();
    }

    @And("^Get the KPI Value for Pending Responses$")
    public void getTheKPIValueForPendingResponses() throws Throwable {
        System.out.println("Pending Response KPI Count is : + PRKPICount");
        Thread.sleep(5000);
        PCLoginpage page = new PCLoginpage(base.driver);
        page.PendingKPIvalue();
    }

    @And("^Get the KPI Value for Incoming Responses$")
    public void getTheKPIValueForIncomingResponses() throws Throwable {
        System.out.println("Incoming Responses KPI Total Count is : + IRKPICount");
        Thread.sleep(5000);
        PCLoginpage page = new PCLoginpage(base.driver);
        page.IncRespKPIvalue();
    }

    @And("^I click the wo and edit for PC$")
    public void iClickTheWoAndEditForPC() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("clicks WO and edit");
        PCLoginpage page = new PCLoginpage(base.driver);
        page.editkpidelrec();
        Thread.sleep(12000);
    }

    @And("^I assign that WO with process Delivery for PC$")
    public void iAssignThatWOWithProcessDeliveryForPC() throws Throwable {
        System.out.println("Set process to Delivery");
        PCLoginpage page = new PCLoginpage(base.driver);
        page.AssignDelivery();
        Thread.sleep(6000);
    }

    @And("^I confirm delivery alert ok for PC$")
    public void iConfirmDeliveryAlertOkForPC() throws Throwable {
        System.out.println("Confirm Delivery alert");
        PCLoginpage page = new PCLoginpage(base.driver);
        Thread.sleep(4000);
        page.deliveryalert();
    }

    @And("^I click on Pending responses KPI for PC$")
    public void iClickOnPendingResponsesKPIForPC() throws Throwable {
        System.out.println("Clicks Pending Response KPI");
        PCLoginpage page = new PCLoginpage(base.driver);
        Thread.sleep(6000);
        page.PendingRespKPI();
    }
    @And("^I click on Incoming Responses tab for PC$")
    public void iClickOnIncomingResponsesTabForPC() throws Throwable {
        System.out.println(" Clicks incoming Responses tab");
        PCLoginpage page = new PCLoginpage(base.driver);
        Thread.sleep(3000);
        page.IncomingResp();
        Thread.sleep(5000);
    }

    @And("^I search a record with the wo number under Incoming Responses tab for PC$")
    public void iSearchARecordWithTheWoNumberUnderIncomingResponsesTabForPC(DataTable table) throws Throwable {
        System.out.println(" Search WO# in incoming Responses tab");
        List<IncResWosearch> Incomingsearches = new ArrayList<IncResWosearch>();
        Incomingsearches = table.asList(IncResWosearch.class);
        PCLoginpage page = new PCLoginpage(base.driver);
        Thread.sleep(7000);
        for (IncResWosearch IncResWosearch : Incomingsearches) {
            page.IncReswosearch(IncResWosearch.increswo);
        }
        Thread.sleep(7000);
    }
    //Incoming Response tab
    public class IncResWosearch {
        public String increswo;

        public IncResWosearch(String IncResWO)
        {
            increswo = IncResWO;
        }
    }

     @And("^I click on Email and Task completed radio buttons$")
    public void iClickOnEMailAndTaskCompletedRadioButtons() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("edits WO");
        Loginpage page = new Loginpage(base.driver);
        Thread.sleep(5000);
        page.clickEmailTaskComp();
    }

    @And("^I click the incomng res wo and edit for PC$")
    public void iClickTheIncomngResWoAndEditForPC() throws Throwable {
        System.out.println("Clicking WO - Incoming Respose");
        PCLoginpage page = new PCLoginpage(base.driver);
        Thread.sleep(3000);
        page.IncResWOclick();
    }

    @And("^user updates the following details under discarded work order for PC$")
    public void userUpdatesTheFollowingDetailsUnderDiscardedWorkOrderForPC(DataTable table) throws Throwable {
        List<UpdateDiscardedWO> updatediscardedwos = new ArrayList<UpdateDiscardedWO>();
        updatediscardedwos = table.asList(UpdateDiscardedWO.class);
        PCLoginpage page = new PCLoginpage(base.driver);
        Thread.sleep(2000);
        for (UpdateDiscardedWO updatediscardedwo : updatediscardedwos) {
            page.UpdateDiscardedWODetails(updatediscardedwo.summary, updatediscardedwo.requestor, updatediscardedwo.sentto);
        }
    }

    public class UpdateDiscardedWO {
        public String summary, requestor, sentto;

        public UpdateDiscardedWO(String Summary, String Requestor, String SentTo) {
            summary = Summary;
            requestor = Requestor;
            sentto = SentTo;
        }
    }

    @And("^I  click on discard button to discard workorder for PC$")
    public void iClickOnDiscardButtonToDiscardWorkorderForPC() {
        System.out.print("Clicks discard checkbox");
        PCLoginpage page = new PCLoginpage(base.driver);
        page.Discard();
    }

    @And("^I click Ok button on discard alert pop-up for PC$")
    public void iClickOkButtonOnDiscardAlertPopUpForPC() {
        System.out.print("confirm ok button on discard alert");
        PCLoginpage page = new PCLoginpage(base.driver);
        page.discardalert();
    }

    @And("^I click Ok button on discard alert pop-up1 for PC$")
    public void iClickOkButtonOnDiscardAlertPopUp1ForPC() {
        System.out.print("confirm ok button on discard alert");
        PCLoginpage page = new PCLoginpage(base.driver);
        page.discardalert1();
    }
    @And("^user clicks discarded work order submit button for PC$")
    public void userClicksDiscardedWorkOrderSubmitButtonForPC() throws Throwable {
        PCLoginpage page = new PCLoginpage(base.driver);
        Thread.sleep(2000);
        page.DiscardedWOSubmit();
    }

    @And("^I click on completed tab for PC$")
    public void iClickOnCompletedTabForPC() throws Throwable {
        System.out.println("Click on Completed tab");
        PCLoginpage page = new PCLoginpage(base.driver);
        Thread.sleep(4000);
        page.completedtab();
    }

    @And("^user clicks on discarded tab for PC$")
    public void userClicksOnDiscardedTabForPC() throws Throwable {
        System.out.print("Clicks discarded tab");
        PCLoginpage page = new PCLoginpage(base.driver);
        Thread.sleep(1000);
        page.SelectDiscardedTab();
        Thread.sleep(1000);
    }

    @And("^I search record with WO number under discarded tab for PC$")
    public void iSearchRecordWithWONumberUnderDiscardedTabForPC(DataTable table) throws Throwable {
        System.out.println(" Search WO# in Discrded tab");
        List<DiscardWOsearch> diswosearches = new ArrayList<DiscardWOsearch>();
        diswosearches = table.asList(DiscardWOsearch.class);
        PCLoginpage page = new PCLoginpage(base.driver);
        Thread.sleep(3000);
        for (DiscardWOsearch DiscardWOsearch : diswosearches) {
            page.DiscardWOsearch(DiscardWOsearch.discardwosearch);
            Thread.sleep(3000);
        }
    }
    // Discarded Module
    public class DiscardWOsearch {
        public String discardwosearch;

        public DiscardWOsearch(String DiscardWOSearch) {
            discardwosearch = DiscardWOSearch;
        }
    }

    @And("^user selects particular work order on discarded tab for PC$")
    public void userSelectsParticularWorkOrderOnDiscardedTabForPC() throws Throwable {
        PCLoginpage page = new PCLoginpage(base.driver);
        Thread.sleep(2000);
        page.SelectDiscardedTabWO();
        Thread.sleep(2000);
    }

    @And("^I click Submit button in WO page for PC$")
    public void iClickSubmitButtonInWOPageForPC() {
        System.out.println("Clicks Submit btn in Wo detail page");
        PCLoginpage page = new PCLoginpage(base.driver);
        page.Submit();
    }

    @And("^user searches with the following global value for PC$")
    public void userSearchesWithTheFollowingGlobalValueForPC(DataTable Table) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("Global Search: record id");
        List<GlobalSearch> keywords = new ArrayList<GlobalSearch>();
        keywords = Table.asList(GlobalSearch.class);
        PCLoginpage page = new PCLoginpage(base.driver);
        for (GlobalSearch keyword : keywords) {
            page.GlobalSearch(keyword.globalsearch);
        }  Thread.sleep(4000);
    }

    public class GlobalSearch {
        public String globalsearch;

        public GlobalSearch(String Globalsearch) {
            globalsearch = Globalsearch;
        }
    }

    @And("^user clicks the first link for PC$")
    public void userClicksTheFirstLinkForPC() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("Clicking on Global Search value record id");
        PCLoginpage page = new PCLoginpage(base.driver);
        page.GlobalSearchLinkSelect();
        Thread.sleep(10000);
    }

    @And("^user clicks on reports button for PC$")
    public void userClicksOnReportsButtonForPC() throws Throwable {
        PCLoginpage page = new PCLoginpage(base.driver);
        Thread.sleep(3000);
        page.ReportsButton();
        Thread.sleep(3000);
        String currentWindow = base.driver.getWindowHandle();
        base.driver.switchTo().window(currentWindow);
    }

    @And("^I work on time record admin for PC$")
    public void iWorkOnTimeRecordAdminForPC() throws Throwable {
        System.out.print("Working on sorting mechanism of time record admin");
        PCLoginpage page = new PCLoginpage(base.driver);
        Thread.sleep(10000);
        page.clickingtimerecordadmin();
        Thread.sleep(10000);
    }

    @And("^I select Start Time From and To dates for PC$")
    public void iSelectStartTimeFromAndToDatesForPC(DataTable table) throws Throwable {
        System.out.println("Selecting Start Time dates in TRA");
        List<StartTime> TRA = new ArrayList<StartTime>();
        TRA = table.asList(StartTime.class);
        PCLoginpage page = new PCLoginpage(base.driver);
        Thread.sleep(10000);
        for (StartTime StartTime : TRA) {
            page.TRAStarttime(StartTime.from, StartTime.to);
            Thread.sleep(10000);
        }
    }

    // Time Rec Admin Start Timer
    public class StartTime {
        public String from, to;

        public StartTime(String From, String To) {
            from = From;
            to = To;
        }
    }

    @And("^I select service in service column from time record admin for PC$")
    public void iSelectServiceInServiceColumnFromTimeRecordAdminForPC(DataTable table) throws Throwable {
        System.out.print("Selecting the service in TRA");
        List<TraSe> services = new ArrayList<TraSe>();
        services = table.asList(TraSe.class);
        PCLoginpage page = new PCLoginpage(base.driver);
        for (TraSe service : services) {
            page.traselectingthecompany();
            Thread.sleep(4000);
            page.traselectingtheusicompany(service.trcompany);
            Thread.sleep(4000);
            page.traselectingusicompany();
            Thread.sleep(4000);
            page.traclickingservicesearch();
            Thread.sleep(4000);
            page.traselectingtheservice(service.trservice);
            Thread.sleep(4000);
            page.traclickingtheenteredservice();
            Thread.sleep(4000);
            page.traclickingtaskdescriptionsearch();
            Thread.sleep(3000);
            page.traselectingthetaskdescription(service.trtaskdescription);
            Thread.sleep(3000);
            page.traclickingtheenteredtaskdescription();
            Thread.sleep(3000);
            /*page.traviewing();
            Thread.sleep(3000);*/
            page.traenteringtheworkordernumber(service.trworkordernumber);
            Thread.sleep(3000);
            page.traenteringemployeename(service.tremployee);
            Thread.sleep(3000);
           /* page.trenteringhours(service.trhours);
            Thread.sleep(10000);*/
        }
    }
    public class TraSe {
        public String trcompany, trservice, trtaskdescription, trworkordernumber, tremployee, trhours;

        public TraSe(String Trcompany, String Trservice, String Trtaskdescription, String Trworkordernumber, String Tremployee, String Trhours) {
            trcompany = Trcompany;
            trservice = Trservice;
            trtaskdescription = Trtaskdescription;
            trworkordernumber = Trworkordernumber;
            tremployee = Tremployee;
            trhours = Trhours;
        }
    }

    @And("^I Edit the selected time record for PC$")
    public void iEditTheSelectedTimeRecordForPC(DataTable table) throws Throwable {
        System.out.print("Editing the selected time record");
        List<TraDm> records = new ArrayList<TraDm>();
        records = table.asList(TraDm.class);
        PCLoginpage page = new PCLoginpage(base.driver);
        for (TraDm record : records) {
            page.editTRAicon();
            Thread.sleep(10000);
            page.editiingthetimerecordtask(record.trtask, record.trstarttime, record.trendtime);
        }
        Thread.sleep(5000);
    }
    public class TraDm{
        public String trtask, trstarttime, trendtime;

        public TraDm(String Trtask, String Trstarttime, String Trendtime){
            trtask = Trtask;
            trstarttime = Trstarttime;
            trendtime = Trendtime;
        }
    }

    @And("^I click on Time Rec Open tab for PC$")
    public void iClickOnTimeRecOpenTabForPC() throws Throwable {
        System.out.println("Clicking on Time Rec Open");
        PCLoginpage page = new PCLoginpage(base.driver);
        page.timeRecOpen();
        Thread.sleep(10000);
    }

    @And("^I click on patra corp link for PC$")
    public void iClickOnPatraCorpLinkForPC() throws Throwable {
        System.out.println("Clicks Patracorp logo");
        PCLoginpage page = new PCLoginpage(base.driver);
        Thread.sleep(4000);
        page.logo();
    }

    @Then("^I Click on Logout icon for PC$")
    public void iClickOnLogoutIconForPC() {
        System.out.println("Clicks Logout icon");
        PCLoginpage page = new PCLoginpage(base.driver);
        page.clicklogouticon();
    }

    @Then("^I click Logout button for PC$")
    public void iClickLogoutButtonForPC() throws Throwable {
        System.out.println("Clicks Logout button");
        PCLoginpage page = new PCLoginpage(base.driver);
        Thread.sleep(2000);
        page.Logout();
    }
}