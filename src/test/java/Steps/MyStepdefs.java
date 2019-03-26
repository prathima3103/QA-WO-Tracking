package Steps;

import Base.BaseUtil;
import Pages.Loginpage;
import com.sun.org.apache.xerces.internal.util.SynchronizedSymbolTable;
import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.java.ro.Si;
import gherkin.lexer.De;
import gherkin.lexer.Th;
import javafx.scene.control.Tab;
import javafx.scene.control.TableCell;
import javafx.scene.effect.SepiaTone;
import org.openqa.selenium.*;

import javax.xml.soap.Detail;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class MyStepdefs extends BaseUtil {

    public MyStepdefs(BaseUtil base) {
        this.base = base;
    }

    private BaseUtil base;

    @Given("^I navigate to login page of certs app TS_Login_Usr01$")
    public void iNavigateToLoginPageOfCertsAppTS_Login_Usr01() throws Throwable {
        System.out.println("Navigates to Login page - TS_Login_Usr01");
        base.driver.navigate().to("https://dev.patracorp.net/home");
     //   base.driver.get("https://wot.patracorp.net/auth");
        base.driver.manage().window().maximize();
    }

    @And("^I enter login credentials$")
    public void iEnterLoginCredentials(DataTable table) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("Entering email address and password");
        //create arraylst
        List<SignIn> users = new ArrayList<SignIn>();
        users = table.asList(SignIn.class);
        Loginpage page = new Loginpage(base.driver);
        for (SignIn user : users) {
            page.Login(user.email, user.password);
        }
    }

    @And("^I click on Sign In button$")
    public void iClickOnSignInButton() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("Clicks Sign In button");
        Loginpage page = new Loginpage(base.driver);
        page.SignInButton();
    }

    @When("^I select WO Tracking application box$")
    public void iSelectWOTrackingApplicationBox() throws Throwable {
        System.out.println("Clicks Work Order Tracking KPI box");
        Loginpage page = new Loginpage(base.driver);
        page.WoTracklink();
        Thread.sleep(5000);
        System.out.println("Before switching tab title is :" + base.driver.getTitle());
        String ParentWindow=base.driver.getWindowHandle();
        System.out.println("After switching tab title is " + base.driver.getTitle());
        Set<String> allwindows=base.driver.getWindowHandles();
        for(String window : allwindows) {
            if (!allwindows.equals(ParentWindow)){
                base.driver.switchTo().window(window);
            }
        }

    /*  Set<String> allwindows=driver.getWindowHandles();
        Iterator<String> i1=allwindows.iterator();
        String main_window = i1.next();
        String child_window = i1.next();
        driver.switchTo().window(child_window);
        System.out.println("After switching title is :" + driver.getTitle());
        String ParentWindow=driver.getWindowHandle();
        System.out.println("Before switching title is " + driver.getTitle());
        Set<String> allwindows=driver.getWindowHandles();
        Iterator<String> i1=allwindows.iterator();
        while (i1.hasNext()){
            String child_window=i1.next();

         if(!ParentWindow.equalsIgnoreCase(child_window)) {
             driver.switchTo().window(child_window);
             Thread.sleep(5000);
             System.out.println("After switching" + driver.getTitle());
         }
        }
        driver.switchTo().window(ParentWindow);
        System.out.println("Back to parent window" + driver.getTitle());*/
    }

    @And("^I select a client TS_Company Selection_08$")
    public void iSelectAClientTS_CompanySelection_08(DataTable table) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("Selecting a client / service");
        List<pickclient> clients = new ArrayList<pickclient>();
        clients = table.asList(pickclient.class);
        Loginpage page = new Loginpage(base.driver);
        Thread.sleep(4000);
        for (pickclient client : clients) {
            page.pickclient(client.company);
            Thread.sleep(5000);
        }
    }

    @And("^I change client from dropdown list TS_Change Company_13$")
    public void iChangeClientFromDropdownListTS_ChangeCompany_13(DataTable table) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("Changes company - TS_Change Company_13");
        List<pickclient> clients = new ArrayList<pickclient>();
        clients = table.asList(pickclient.class);
        Loginpage page = new Loginpage(base.driver);
        Thread.sleep(2000);
        for (pickclient client : clients) {
            page.changecomp(client.company);
        }
    }

    @And("^I clicks Reset button for Processing$")
    public void iClicksResetButtonForProcessing() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("Click On Reset button");
        Loginpage page = new Loginpage(base.driver);
        Thread.sleep(2000);
        page.ProcReset();
    }

    @And("^I search a record with the wo number$")
    public void iSearchARecordWithTheWoNumber(DataTable table) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("Searches KPI record");
        List<WorkOrderSearch> workOrderSearches = new ArrayList<WorkOrderSearch>();
        workOrderSearches = table.asList(WorkOrderSearch.class);
        Loginpage page = new Loginpage(base.driver);
        Thread.sleep(8000);
        for (WorkOrderSearch workOrderSearch : workOrderSearches) {
            page.WorkOrderSearch(workOrderSearch.wo, workOrderSearch.clientcode, workOrderSearch.summary);
        }
        Thread.sleep(10000);
    }

    @And("^I select a WO under Processing tab TS_Edit WO_10$")
    public void iSelectAWOUnderProcessingTabTS_EditWO_10() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("Clicks WO In Process - TS_Edit WO_10");
        Loginpage page = new Loginpage(base.driver);
        page.SelWO();
        Thread.sleep(8000);
    }

    @And("^I select discard checkbox to discard the work order$")
    public void ISelectDiscardCheckboxToDiscardTheWorkOrder() throws Throwable {
        System.out.println("Discard checkbox");
        Loginpage page = new Loginpage(base.driver);
        page.Discard();
        Thread.sleep(5000);
    }

    @And("^I assign that WO$")
    public void iAssignThatWO() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("Assigning WO on my name");
        Loginpage page = new Loginpage(base.driver);
        page.Assign();
        Thread.sleep(6000);
    }

    @And("^I assign that WO with process qa$")
    public void iAssignThatWOWithProcessQa() throws Throwable {
        System.out.println("Set process to QA");
        Loginpage page = new Loginpage(base.driver);
        page.AssignQA();
        Thread.sleep(6000);
    }

    @And("^I assign that WO with process Delivery$")
    public void iAssignThatWOWithProcessDelivery() throws Throwable {
        System.out.println("Set process to Delivery");
        Loginpage page = new Loginpage(base.driver);
        page.AssignDelivery();
        Thread.sleep(6000);
    }

    @And("^I confirm delivery alert ok$")
    public void iConfirmDeliveryAlertOk() throws Throwable {
        System.out.println("Confirm Delivery alert");
        Loginpage page = new Loginpage(base.driver);
        Thread.sleep(4000);
        page.deliveryalert();
    }

    @And("^I assign that WO with process Email$")
    public void iAssignThatWOWithProcessEmail() throws Throwable {
        System.out.println("Set process to Email");
        Loginpage page = new Loginpage(base.driver);
        Thread.sleep(4000);
        page.AssignEmail();
    }

    @And("^I assign that WO with process DEL - TWB$")
    public void iAssignThatWOWithProcessDELTWB() throws Throwable {
        System.out.println("Set process to DEL-TWB");
        Loginpage page = new Loginpage(base.driver);
        Thread.sleep(4000);
        page.AssignDelTwb();
    }

    @And("^i click start timer button in the WO form$")
    public void iClickStartTimerButtonInTheWOForm() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("clicks start timer button");
        Loginpage page = new Loginpage(base.driver);
        Thread.sleep(2000);
        page.WOtimer();
    }

    @And("^I clicks start timer in timer pop-up section$")
    public void IclicksStartTimerInTimerPopUpSection() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("Hit start timer counts");
        Loginpage page = new Loginpage(base.driver);
        Thread.sleep(5000);
        page.starttimer();
    }

    @And("^I enter details in the WO form TS_Edit WO_11$")
    public void iEnterDetailsInTheWOFormTS_EditWO_11(DataTable table) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        List<SelectProcessingWOform> actionbar = new ArrayList<SelectProcessingWOform>();
        //Stores data
        actionbar = table.asList(SelectProcessingWOform.class);
        Loginpage page = new Loginpage(base.driver);
        Thread.sleep(5000);
        System.out.println("Enter details in WO form - TS_Edit WO_11");
        for (SelectProcessingWOform woactionbar : actionbar) {
            page.SelectProcessingWOform(woactionbar.wo, woactionbar.assignedto, woactionbar.rush, woactionbar.bulk, woactionbar.frompending, woactionbar.update, woactionbar.process, woactionbar.isassigned, woactionbar.ishold,
                    woactionbar.isemail, woactionbar.isdiscard, woactionbar.isdelivered, woactionbar.istaskcompleted, woactionbar.status, woactionbar.folder, woactionbar.startdateoverride,
                    woactionbar.duedateovrride, woactionbar.holdreason, woactionbar.assignto, woactionbar.summary, woactionbar.requestor, woactionbar.sentto);
        }
    }


    @And("^I insert values in Detail tab$")
    public void iInsertValuesInDetailTab(DataTable table) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("Entering Detail tab fields");
        List<Detail> form = new ArrayList<Detail>();
        form = table.asList(Detail.class);
        Loginpage page = new Loginpage(base.driver);
        Thread.sleep(2000);
        for (Detail woform : form) {
            page.Detail(woform.numofcerts, woform.clientcode, woform.clientname, woform.workordertype, woform.branchoffice, woform.department, woform.division, woform.holders,
                    woform.certmaster, woform.profitcenter, woform.certissuancesystem, woform.certissuedby, woform.qaby, woform.deliveryby, woform.insureddelivery, woform.certholderdelivery,
                    woform.carrierfax, woform.amdelievry, woform.twbet, woform.insuredmethod, woform.certholdermethod, woform.carriermethod, woform.csrcontact1,
                    woform.csrcontact2, woform.pages, woform.additionalcomments, woform.comments, woform.complexity);
        } Thread.sleep(6000);
    }

    @And("^I click Attachments tab$")
    public void iClickAttachmentsTab() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        Loginpage page = new Loginpage(base.driver);
        page.Attachments();
        System.out.println("Attachments tab");
        Thread.sleep(5000);
    }

    @And("^I click Emails tab$")
    public void iClickEmailsTab() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        Loginpage page = new Loginpage(base.driver);
        page.Emails();
        System.out.println("Emails tab");
        Thread.sleep(5000);
    }

    @And("^I click QA tab$")
    public void iClickQATab() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        Loginpage page = new Loginpage(base.driver);
        Thread.sleep(4000);
        page.QA();
        System.out.println("QA tab");
        Thread.sleep(4000);
    }

    @And("^I insert values in QA tab$")
    public void iInsertValuesInQATab(DataTable table) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        List<QA> section = new ArrayList<QA>();
        section = table.asList(QA.class);
        Loginpage page = new Loginpage(base.driver);
        Thread.sleep(2000);
        for (QA wosection : section) {
            page.QAedit(wosection.auditqa, wosection.errors, wosection.errormadeby, wosection.errortype, wosection.filedby, wosection.errdesc);
        }    System.out.println("Entering QA tab values");
    }

    @And("^I click SecondQA tab$")
    public void iClickSecondQATab() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        Loginpage page = new Loginpage(base.driver);
        page.SecondQa();
        System.out.println("Second QA tab");
    }

    @And("^I insert values in Second QA tab$")
    public void iInsertValuesInSecondQATab(DataTable table) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        List<secondqa> secqa = new ArrayList<secondqa>();
        secqa = table.asList(secondqa.class);
        Loginpage page = new Loginpage(base.driver);
        Thread.sleep(2000);
        for (secondqa woqa : secqa) {
            page.SecondQaedit(woqa.needed, woqa.done, woqa.doneby);
        }  System.out.println("Entering Second QA tab values");

    }

    @And("^I click History tab$")
    public void iClickHistoryTab() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        Loginpage page = new Loginpage(base.driver);
        page.History();
        System.out.println("History tab");
    }

    @And("^I click Time Records tab$")
    public void iClickTimeRecordsTab() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        Loginpage page = new Loginpage(base.driver);
        page.TimeRecords();
        System.out.println("Time Records tab");
        Thread.sleep(3000);
    }

    @And("^I clicks stop timer button$")
    public void IclicksStopTimerButton() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        Loginpage page = new Loginpage(base.driver);
        Thread.sleep(5000);
        page.stoptimer();
        System.out.println("Hit stop timer ends");
    }

    @And("^I click on Print PDF button$")
    public void iClickOnPrintPDFButton() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        Loginpage page = new Loginpage(base.driver);
        Thread.sleep(2000);
        page.printpdf();
        System.out.println("Clicks print pdf");
        String currentWindow = base.driver.getWindowHandle();  //Switching frames
        base.driver.switchTo().window(currentWindow);
    }

    @And("^I click Time Records page link$")
    public void iClickTimeRecordsPageLink() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("Clicks Time Records page");
        Loginpage page = new Loginpage(base.driver);
        Thread.sleep(2000);
        page.TimeRecordsGrid();
    }

    @And("^I click on the selected client to open app$")
    public void iClickOnTheSelectedClientToOpenApp() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("Clicks client to open app");
        Loginpage page = new Loginpage(base.driver);
        Thread.sleep(2000);
        page.gotoclient();
        Thread.sleep(20000);
    }

    @And("^I click Add Attachments button$")
    public void iClickAddAttachmentsButton() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("Add Attachments");
        Loginpage page = new Loginpage(base.driver);
        Thread.sleep(2000);
        page.AddAttach();
    }

    @And("^I click on WorkOrders page link$")
    public void iClickOnWorkOrdersPageLink() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("Clicks Work Orders");
        Loginpage page = new Loginpage(base.driver);
        Thread.sleep(20000);
        page.WOgrid();
    }

    @And("^I click KPI Delivery$")
    public void iClickKPIDelivery() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("KPI Delivery");
        Loginpage page = new Loginpage(base.driver);
        Thread.sleep(4000);
        page.kpidelivery();
    }

    @And("^I search for kpi delivery wo$")
    public void iSearchForKpiDeliveryWo(DataTable table) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("KPI Delivery WO#");
        List<kpidelwosearch> delwo = new ArrayList<kpidelwosearch>();
        delwo = table.asList(kpidelwosearch.class);
        Loginpage page = new Loginpage(base.driver);
        Thread.sleep(2000);
        for (kpidelwosearch wo : delwo) {
            page.kpiwosearch(wo.kpidelWO);
        }
    }


    @And("^I click the wo and edit$")
    public void iClickTheWoAndEdit() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("clicks WO and edit");
        Loginpage page = new Loginpage(base.driver);
        page.editkpidelrec();
        Thread.sleep(12000);
    }

    @And("^I click Close button$")
    public void iClickCloseButton() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("Clicks close button in WO form");
        Loginpage page = new Loginpage(base.driver);
        page.CloseWO();
    }

    @And("^I sort the columns in Time Records$")
    public void iSortTheColumnsInTimeRecords() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("Column sorting in Time Records");
        Loginpage page = new Loginpage(base.driver);
        Thread.sleep(7000);
        page.sortcompany();
        Thread.sleep(6000);
        page.sortcompany();
        Thread.sleep(8000);
        page.sortservice();
        Thread.sleep(8000);
        page.sortservice();
        Thread.sleep(8000);
    }

    @And("^user searches with the following global value$")
    public void userSearchesWithTheFollowingGlobalValue(DataTable Table) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("Global Search: record id");
        List<GlobalSearch> keywords = new ArrayList<GlobalSearch>();
        keywords = Table.asList(GlobalSearch.class);
        Loginpage page = new Loginpage(base.driver);
        for (GlobalSearch keyword : keywords) {
            page.GlobalSearch(keyword.globalsearch);
        }
        Thread.sleep(4000);
    }

    @And("^user clicks the first link$")
    public void userClicksTheFirstLink() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("Clicking on Global Search value record id");
        Loginpage page = new Loginpage(base.driver);
        page.GlobalSearchLinkSelect();
        Thread.sleep(10000);
    }

    @Then("^I Click on Logout icon$")
    public void iClickOnLogoutIcon() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("Clicks Logout icon");
        Loginpage page = new Loginpage(base.driver);
        page.clicklogouticon();

    }
    @Then("^I click Logout button$")
    public void iClickLogoutButton() throws Throwable {
        System.out.println("Clicks Logout button");
        Loginpage page = new Loginpage(base.driver);
        Thread.sleep(2000);
        page.logout();
    }


    @And("^I scroll down the web page to bottom$")
    public void iScrollDownTheWebPageToBottom() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        Loginpage page = new Loginpage(base.driver);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        //  js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
        js.executeScript("document.querySelector(table th:last-child').scrollIntoView();");
    }

    @And("^I click on PatraCorp link$")
    public void iClickOnPatraCorpLink() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("Clicks Patracorp logo");
        Loginpage page = new Loginpage(base.driver);
        Thread.sleep(4000);
        page.logo();
    }

    @And("^I edit WO fields$")
    public void iEditWOFields() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("edits WO");
        Loginpage page = new Loginpage(base.driver);
        Thread.sleep(5000);
        page.EditWO();
    }

    @And("^I click on Cancel Changes button$")
    public void iClickOnCancelChangesButton() throws Throwable {
        System.out.println("Click on Cancel Changes button in WO");
        Loginpage page = new Loginpage(base.driver);
        Thread.sleep(5000);
        page.Cancelchanges();
    }

    @Then("^I Click on Add WorkOrder TS_Add WO_09$")
    public void iClickOnAddWorkOrderTS_AddWO_09() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("clicks ADD WO - TS_Add WO_09");
        Loginpage page = new Loginpage(base.driver);
        Thread.sleep(4000);
        page.clickaddworkorder();
        Thread.sleep(4000);
    }

    @Then("^I Enter Add WorkOrder Details$")
    public void iEnterAddWorkOrderDetails(DataTable table) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("Entering ADD WO details");
        List<Certsaddworkorder> users = new ArrayList<Certsaddworkorder>();
        users = table.asList(Certsaddworkorder.class);
        Loginpage page = new Loginpage(base.driver);
        Thread.sleep(12000);
        for (Certsaddworkorder user : users) {
            page.certsaddworkordersbutton(user.addwoprocess, user.addwoisassign, user.addwoishold, user.addwoisemail, user.addwoisdiscard, user.addwoisdelivered,
                    user.addwoistaskcompleted, user.addwoholdreason, user.addwoupdate, user.addwofrompending, user.addworush, user.addwobulk, user.addwoassignto,
                    user.addwostatus, user.addwofolder, user.addworequestor, user.addwosentto, user.addwosummary, user.addwoassignedto);
        }
        Thread.sleep(5000);
        page.addduedates();
        Thread.sleep(8000);
    }

    @Then("^I go to Work Order Details section$")
    public void iGoToWorkOrderDetailsSection() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        Loginpage page = new Loginpage(base.driver);
        page.wodetailsection();
        Thread.sleep(4000);
    }

    @Then("^I Enter details in WO detail section$")
    public void iEnterDetailsInWODetailSection(DataTable table) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        List<Wodetailsectionentry> users = new ArrayList<Wodetailsectionentry>();
        users = table.asList(Wodetailsectionentry.class);
        Thread.sleep(4000);
        Loginpage page = new Loginpage(base.driver);
        for (Wodetailsectionentry user : users) {
            page.wodetailsectionentry(user.noofcerts, user.clientcode, user.clientname, user.wotype, user.branchoffice, user.department, user.division, user.profitcenter,
                    user.certmaster, user.certissuancesystem, user.noofholders, user.certissuedby, user.qaby, user.deliveryby, user.complexity);
        }
    }

    @Then("^I Click on Original Email$")
    public void iClickOnOriginalEmail() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        Loginpage page = new Loginpage(base.driver);
        Thread.sleep(3000);
        page.originalemail();
    }

    @Then("^I Write data in Original Email section$")
    public void iWriteDataInOriginalEmailSection(DataTable table) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        List<descriptionoforiginalemail> users = new ArrayList<descriptionoforiginalemail>();
        users = table.asList(descriptionoforiginalemail.class);
        Thread.sleep(4000);
        Loginpage page = new Loginpage(base.driver);
        for (descriptionoforiginalemail user : users) {
            page.descriptionoforiginalemail(user.originalemail);
        }
    }

    @Then("^I click on Submit button$")
    public void iClickOnSubmitButton() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        Loginpage page = new Loginpage(base.driver);
        Thread.sleep(8000);
        page.addwosubmitbtn();
        Thread.sleep(8000);
    }

    @Then("^I Click on Close on Popup$")
    public void iClickOnCloseOnPopup() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        Loginpage page = new Loginpage(base.driver);
        page.clickclosepopup();
        Thread.sleep(4000);
    }

    @Then("^I Click on Certificate Issuance KPI TS_Certs_CertInsKPI_19$")
    public void iClickOnCertificateIssuanceKPITS_Certs_CertInsKPI_19() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("Clicks KPI - Certificate issuance - TS_Certs_CertInsKPI_19 ");
        Loginpage page = new Loginpage(base.driver);
        page.certissuancekpi();
        Thread.sleep(2000);
    }

    @And("^I Click on Reset button$")
    public void iClickOnResetButton() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        Loginpage page = new Loginpage(base.driver);
        page.ResetButtonClick();
    }

    @And("^I search with the following WO number$")
    public void iSearchWithTheFollowingWONumber(DataTable table) throws Throwable {
        List<wonumbersearch> users = new ArrayList<wonumbersearch>();
        users = table.asList(wonumbersearch.class);
        Thread.sleep(8000);
        Loginpage page = new Loginpage(base.driver);
        for (wonumbersearch user : users) {
            page.wonumbersearch(user.wonumber);
        }
        Thread.sleep(3000);
    }

    @And("^I Selects Workorder$")
    public void iSelectsWorkorder() throws Throwable {
        Loginpage page = new Loginpage(base.driver);
        page.selectworkorder();
        Thread.sleep(11000);
    }

    @Then("^I Change the work order to Particular folder$")
    public void iChangeTheWorkOrderToParticularFolder(DataTable table) throws Throwable {
        List<selectingfolder> users = new ArrayList<selectingfolder>();
        users = table.asList(selectingfolder.class);
        Thread.sleep(4000);
        Loginpage page = new Loginpage(base.driver);
        for (selectingfolder user : users) {
            page.selectingfolder(user.foldername);
        }
        Thread.sleep(6000);
    }

    @Then("^I Close the work order$")
    public void iCloseTheWorkOrder() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        Loginpage page = new Loginpage(base.driver);
        Thread.sleep(8000);
        page.clickcloseworkordertab();
        Thread.sleep(4000);
    }

    @And("^I click on Email Needed KPI$")
    public void iClickOnEmailNeededKPI() throws Throwable {
        System.out.println("Click Email needed KPI");
        Loginpage page = new Loginpage(base.driver);
        Thread.sleep(6000);
        page.EmailKPI();
    }

    @And("^I click on Pending responses KPI$")
    public void iClickOnPendingResponsesKPI() throws Throwable {
        System.out.println("Clicks Pending Response KPI");
        Loginpage page = new Loginpage(base.driver);
        Thread.sleep(6000);
        page.PendingRespKPI();
    }

    @Then("^I Click on Quality Assurance KPI$")
    public void iClickOnQualityAssuranceKPI() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("Clicks KPI - QA");
        Loginpage page = new Loginpage(base.driver);
        page.qakpi();
        Thread.sleep(6000);
    }

    @And("^I click selected QA WO$")
    public void iClickSelectedQAWO() throws Throwable {
        System.out.println("clicks QA WO");
        Loginpage page = new Loginpage(base.driver);
        page.qawo();
        Thread.sleep(10000);
    }

    @And("^I click on completed tab TS_Certs_Comp tab_15$")
    public void iClickOnCompletedTabTS_Certs_CompTab_15() throws Throwable {
        System.out.println("Click on Completed tab - TS_Certs_Comp tab_15");
        Loginpage page = new Loginpage(base.driver);
        Thread.sleep(4000);
        page.completedtab();
    }

    @And("^I do the sorting for all the columns of the tab$")
    public void iDoTheSortingForAllTheColumnsOfTheTab() throws Throwable {
        System.out.println("Working on sorting mechanism");
        Loginpage page = new Loginpage(base.driver);
        Thread.sleep(5000);
        page.sortingwo();
        Thread.sleep(5000);
        page.sortingadddate();
        Thread.sleep(5000);
        page.sortingclientcode();
        Thread.sleep(5000);
        page.sortingsummary();
        Thread.sleep(5000);
        page.sortingstatus();
        Thread.sleep(5000);
        page.sortingduedate();
        Thread.sleep(5000);
        page.sortingrequestor();
        Thread.sleep(5000);
        page.sortingbranchoffice();
        Thread.sleep(5000);
        page.sortingnoofcerts();
        Thread.sleep(5000);
        page.sortingrushbulk();
        Thread.sleep(5000);
        page.sortingwotype();
        Thread.sleep(5000);
        page.sortingcompletedtype();
        Thread.sleep(5000);
        base.driver.findElement(By.cssSelector("#th-WorkOrderNumberCompleted > ul > li:nth-child(1) > span")).click();
        Thread.sleep(6000);
    }

    @And("^I enter search details for columns$")
    public void iEnterSearchDetailsForColumns(DataTable table) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("Entering the search for column search");
        List<ColSe> searching = new ArrayList<ColSe>();
        searching = table.asList(ColSe.class);
        Loginpage page = new Loginpage(base.driver);
        Thread.sleep(5000);
        for (ColSe searche : searching) {
        //   page.Compltdwonum(searche.colwonumber);
            page.enteringcolclientcode(searche.clientcode);
            page.enteringcolsummary(searche.summary);
        /*  page.enteringcolrequestor(searche.requestor);
            page.enteringcolnoofcerts(searche.noofcerts);
            page.enteringcolrushbulk(searche.rushbulk);
            page.enteringthecolsearch(searche.colwonumber);
            page.enteringthestatus(searche.status);
            page.enteringthebranchoffice(searche.branchoffice);
            page.enteringcolpending(searche.pending);
            page.enteringcolwotype(searche.wotype);
            page.enterigncoludpate(searche.update);  */
        }
        base.driver.findElement(By.cssSelector("#dtcompleted > tbody > tr:nth-child(1) > td:nth-child(1) > a")).click();
        Thread.sleep(10000);
    }

    @And("^I work on time record admin$")
    public void iWorkOnTimeRecordAdmin() throws Throwable {
        System.out.print("Working on sorting mechanism of time record admin");
        Loginpage page = new Loginpage(base.driver);
        Thread.sleep(5000);
        page.clickingtimerecordadmin();
        Thread.sleep(5000);
    /*    page.sortingtracompany();
        Thread.sleep(3000);
        page.sortingtraservice();
        Thread.sleep(3000);
        page.sortingtrataskdescription();
        Thread.sleep(3000);
        page.sortingtrawonumber();
        Thread.sleep(3000);
        page.sortingtraemployee();
        Thread.sleep(3000);
        page.sortingtrastarttime();
        Thread.sleep(3000);
        page.sortingtraendtime();
        Thread.sleep(3000);
        page.sortingtrahours();
        Thread.sleep(3000);
        page.sortingtrabillable();
        Thread.sleep(3000);
        page.sortingtraworequired();
        Thread.sleep(3000);         */
    }

    @And("^I select service in service column from time record admin$")
    public void iSelectServiceInServiceColumnFromTimeRecordAdmin(DataTable table) throws Throwable {
        System.out.print("Selecting the service in TRA");
        List<TraSe> services = new ArrayList<TraSe>();
        services = table.asList(TraSe.class);
        Loginpage page = new Loginpage(base.driver);
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
            Thread.sleep(5000);
            page.traclickingtheenteredtaskdescription();
            Thread.sleep(4000);
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

    @And("^I Edit the selected time record$")
    public void iEditTheSelectedTimeRecord(DataTable table) throws Throwable {
        System.out.print("Editing the selected time record");
        List<TraDm> records = new ArrayList<TraDm>();
        records = table.asList(TraDm.class);
        Loginpage page = new Loginpage(base.driver);
        for(TraDm record : records){
            page.editTRAicon();
            Thread.sleep(10000);
            page.editiingthetimerecordtask(record.trtask, record.trstarttime, record.trendtime);
        } Thread.sleep(5000);
    }

    @And("^I  click on discard button to discard workorder$")
    public void iClickOnDiscardButtonToDiscardWorkorder() throws Throwable {
        System.out.print("Clicks discard checkbox");
        Loginpage page = new Loginpage(base.driver);
        page.Discard();
    }

    @And("^I click Ok button on discard alert pop-up$")
    public void iClickOkButtonOnDiscardAlertPopUp() throws Throwable {
        System.out.print("confirm ok button on discard alert");
        Loginpage page = new Loginpage(base.driver);
        page.discardalert();
    }

    @And("^user clicks on discarded tab$")
    public void userClicksOnDiscardedTab() throws Throwable {
        System.out.print("Clicks discarded tab");
        Loginpage page = new Loginpage(base.driver);
        Thread.sleep(1000);
        page.SelectDiscardedTab();
        Thread.sleep(1000);
    }

    @And("^user selects particular work order on discarded tab$")
    public void userSelectsParticularWorkOrderOnDiscardedTab() throws Throwable {
        Loginpage page = new Loginpage(base.driver);
        Thread.sleep(2000);
        page.SelectDiscardedTabWO();
        Thread.sleep(2000);
    }

    @And("^user updates the following details under discarded work order$")
    public void userUpdatesTheFollowingDetailsUnderDiscardedWorkOrder(DataTable table) throws Throwable {
        List<UpdateDiscardedWO> updatediscardedwos=new ArrayList<UpdateDiscardedWO>();
        updatediscardedwos=table.asList(UpdateDiscardedWO.class);
        Loginpage page = new Loginpage(base.driver);
        Thread.sleep(2000);
        for (UpdateDiscardedWO updatediscardedwo:updatediscardedwos)
        {
            page.UpdateDiscardedWODetails(updatediscardedwo.summary,updatediscardedwo.requestor,updatediscardedwo.sentto);
        }
    }

    @And("^user clicks discarded work order submit button$")
    public void userClicksDiscardedWorkOrderSubmitButton() throws Throwable {
        Loginpage page = new Loginpage(base.driver);
        Thread.sleep(2000);
        page.DiscardedWOSubmit();
    }

    @And("^user updates following values under discarded work order detail tab$")
    public void userUpdatesFollowingValuesUnderDiscardedWorkOrderDetailTab(DataTable table) throws Throwable {
        List<Detail> form = new ArrayList<Detail>();
        form = table.asList(Detail.class);
        Loginpage page = new Loginpage(base.driver);
        Thread.sleep(2000);
        for (Detail woform : form) {
            page.Detail(woform.numofcerts, woform.clientcode, woform.clientname, woform.workordertype, woform.branchoffice, woform.department, woform.division, woform.holders,
                    woform.certmaster, woform.profitcenter, woform.certissuancesystem, woform.certissuedby, woform.qaby, woform.deliveryby, woform.insureddelivery, woform.certholderdelivery,
                    woform.carrierfax, woform.amdelievry, woform.twbet, woform.insuredmethod, woform.certholdermethod, woform.carriermethod, woform.csrcontact1,
                    woform.csrcontact2, woform.pages, woform.additionalcomments, woform.comments, woform.complexity);
        }
    }

    @And("^user selects following task from work order time tracking$")
    public void userSelectsFollowingTaskFromWorkOrderTimeTracking(DataTable table) throws Throwable {
        Loginpage page = new Loginpage(base.driver);
        Thread.sleep(3000);
        List<WOStartTimer> tasks=new ArrayList<WOStartTimer>();
        tasks=table.asList(WOStartTimer.class);
        for(WOStartTimer selecttask:tasks)
        {
            page.SelectWOStartTimerTask(selecttask.task);
        }
    }

    @And("^I click change company confirm button$")
    public void iClickChangeCompanyConfirmButton() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        Loginpage page = new Loginpage(base.driver);
        Thread.sleep(3000);
        page.changecomppopup();
    }

    @And("^I click on Incoming Responses tab$")
    public void iClickOnIncomingResponsesTab() throws Throwable {
       System.out.println(" Clicks incoming Responses tab");
        Loginpage page = new Loginpage(base.driver);
        Thread.sleep(3000);
        page.IncomingResp();
        Thread.sleep(5000);
    }

    @And("^I search a record with the wo number under Incoming Responses tab$")
    public void iSearchARecordWithTheWoNumberUnderIncomingResponsesTab(DataTable table) throws Throwable {
        System.out.println(" Search WO# in incoming Responses tab");
        List<IncResWosearch> Incomingsearches = new ArrayList<IncResWosearch>();
        Incomingsearches = table.asList(IncResWosearch.class);
        Loginpage page = new Loginpage(base.driver);
        Thread.sleep(7000);
        for(IncResWosearch IncResWosearch : Incomingsearches) {
            page.IncReswosearch(IncResWosearch.increswo);
        }        Thread.sleep(7000);
    }
    @And("^I click the incomng res wo and edit$")
    public void iClickTheIncomngResWoAndEdit() throws Throwable {
        System.out.println("Clicking WO - Incoming Respose");
        Loginpage page = new Loginpage(base.driver);
        Thread.sleep(3000);
        page.IncResWOclick();
    }

    @And("^I search record with WO number under discarded tab$")
    public void iSearchRecordWithWONumberUnderDiscardedTab(DataTable table) throws Throwable {
        System.out.println(" Search WO# in Discrded tab");
        List<DiscardWOsearch> diswosearches = new ArrayList<DiscardWOsearch>();
        diswosearches = table.asList(DiscardWOsearch.class);
        Loginpage page = new Loginpage(base.driver);
        Thread.sleep(3000);
        for(DiscardWOsearch DiscardWOsearch : diswosearches ){
            page.DiscardWOsearch(DiscardWOsearch.discardwosearch);
            Thread.sleep(3000);
        }
    }

    @And("^I click Mark Rush button TS_Edit WO_11$")
    public void iClickMarkRushButtonTS_EditWO_11() throws Throwable {
      System.out.println(" Clicks Mark Rush button - TS_Edit WO_11");
      Loginpage page = new Loginpage(base.driver);
      Thread.sleep(3000);
      page.markrush();
    }

    @And("^I select Start Time From and To dates$")
    public void iSelectStartTimeFromAndToDates(DataTable table) throws Throwable {
        System.out.println("Selecting Start Time dates in TRA");
        List<StartTime> TRA = new ArrayList<StartTime>();
        TRA = table.asList(StartTime.class);
        Loginpage page = new Loginpage(base.driver);
        Thread.sleep(3000);
        for(StartTime StartTime : TRA){
            page.TRAStarttime(StartTime.from, StartTime.to);
            Thread.sleep(3000);
        }
    }

    @And("^I search a record with the wo number under Completed tab$")
    public void iSearchARecordWithTheWoNumberUnderCompletedTab(DataTable table) throws Throwable {
        System.out.println("Enters Wo# in search box");
        List<CompletedWosearch> completedWosearches = new ArrayList<CompletedWosearch>();
        completedWosearches = table.asList(CompletedWosearch.class);
        Loginpage page = new Loginpage(base.driver);
        Thread.sleep(6000);
        for(CompletedWosearch CompletedWosearch : completedWosearches) {
            page.Compltdwonum(CompletedWosearch.completedWO);  //CompletedWosearch.clientcode, CompletedWosearch.noofcerts, CompletedWosearch.rushbulk
            Thread.sleep(8000);
        }
    }

    @And("^I click Submit button in WO page$")
    public void iClickSubmitButtonInWOPage() throws Throwable {
        System.out.println("Clicks Submit btn in Wo detail page");
        Loginpage page = new Loginpage(base.driver);
        page.Submit();
    }

    @And("^I Click on Reset button under Completed tab$")
    public void iClickOnResetButtonUnderCompletedTab() throws Throwable {
        System.out.println("Clicks Reset btn in Completed tab");
        Loginpage page = new Loginpage(base.driver);
        page.ResetbtnCompletedtab();
    }

    @And("^I click Incoming Responses KPI$")
    public void iClickIncomingResponsesKPI() throws Throwable {
      System.out.println("Clicks KPI - Incoming Responses");
      Loginpage page = new Loginpage(base.driver);
      page.IncomingRespKPI();
    }

    @And("^I click on Important Instructions tab$")
    public void iClickOnImportantInstructionsTab() throws Throwable {
        System.out.println("Clicks Important Instructions tab");
        Loginpage page = new Loginpage(base.driver);
        page.ImportantInstrtab();
    }

    @And("^I click on Important Instructions reset btn$")
    public void iClickOnImportantInstructionsResetBtn() throws Throwable {
        System.out.println("Reset btn - Important Instructions tab");
        Loginpage page= new Loginpage(base.driver);
        Thread.sleep(3000);
        page.ImpReset();
    }

    @And("^I click the Important Instr wo$")
    public void iClickTheImportantInstrWo() throws Throwable {
        System.out.println("Clicks WO - Important Instructions tab");
        Loginpage page= new Loginpage(base.driver);
        Thread.sleep(2000);
        page.ImpInstrWOclick();
    }

    @And("^I update wo with following fields$")
    public void iUpdateWoWithFollowingFields(DataTable table) throws Throwable {
        System.out.println("Edits summary ");
        List<ImportantInstr> fields = new ArrayList<ImportantInstr>();
        fields = table.asList(ImportantInstr.class);
        Loginpage page = new Loginpage(base.driver);
        for(ImportantInstr wofield : fields){
            page.UpdateImpInstr(wofield.summary);
        } Thread.sleep(5000);
    }

    @And("^I click on To Be Discarded tab$")
    public void iClickOnToBeDiscardedTab() throws Throwable {
        System.out.println("Clicks To Be Discarded tab");
        Loginpage page = new Loginpage(base.driver);
        page.ToBeDiscardtab();
        Thread.sleep(3000);
    }

    @And("^get KPI Count for Certificate Issuance$")
    public void getKPICountForCertificateIssuance() throws Throwable {
        System.out.println("Certificate Issuance Available & Total Count is : + CIKPIAvailableCount");
        Thread.sleep(5000);
        Loginpage page = new Loginpage(base.driver);
        page.CIKPIvalue();
    }

    @And("^I get KPI Count for Quality Assurance$")
    public void iGetKPICountForQualityAssurance() throws Throwable {
        System.out.println("QA Available & Total Count is : + QAKPITotalCount");
        Thread.sleep(5000);
        Loginpage page = new Loginpage(base.driver);
        page.QAKPIvalue();
    }

    @And("^I get KPI Count for Delivery$")
    public void iGetKPICountForDelivery() throws Throwable {
        System.out.println("Delivery Available & Total Count is :\" + DeliveryKPIAvailableCount");
        Thread.sleep(5000);
        Loginpage page = new Loginpage(base.driver);
        page.DelKPIvalue();
    }

    @And("^I get KPI Count for Email$")
    public void iGetKPICountForEmail() throws Throwable {
        System.out.println("Email Needed Total Count is : + EMKPITotalCount");
        Thread.sleep(5000);
        Loginpage page = new Loginpage(base.driver);
        page.EmailKPIvalue();
    }

    @And("^I get KPI Count for Pending Responses$")
    public void iGetKPICountForPendingResponses() throws Throwable {
        System.out.println("Pending Responses Total Count is : + PRKPITotalCount");
        Thread.sleep(5000);
        Loginpage page = new Loginpage(base.driver);
        page.PendingKPIValue();
    }

    @And("^I get KPI Count for Incoming Responses$")
    public void iGetKPICountForIncomingResponses() throws Throwable {
        System.out.println("Incoming Response Total Count is : + IRKPITotalCount");
        Thread.sleep(5000);
        Loginpage page = new Loginpage(base.driver);
        page.IncomingKPIValue();
    }

    @And("^I get KPI Count for Due in 30 Mins$")
    public void iGetKPICountForDueIn30Mins(int arg0) throws Throwable {
        System.out.println("Due in 30 Mins Total Count is : + DueKPITotalCount");
        Thread.sleep(5000);
        Loginpage page = new Loginpage(base.driver);
        page.Due30();
    }

    @And("^I get KPI Count for Past Due$")
    public void iGetKPICountForPastDue() throws Throwable {
        System.out.println("Past Due Total Count is : + PastKPITotalCount");
        Thread.sleep(5000);
        Loginpage page = new Loginpage(base.driver);
        page.PastDueKPIvalue();
    }

    @And("^I Click on Incoming Resp Reset button$")
    public void iClickOnIncomingRespResetButton() throws Throwable {
       System.out.println("Reset btn - Incoming resp tab");
       Loginpage page = new Loginpage(base.driver);
       page.IncReset();
    }

    @And("^I click To Be Discarded Reset button$")
    public void iClickToBeDiscardedResetButton() throws Throwable {
        System.out.println("Reset btn - To Be Discarded tab");
        Loginpage page = new Loginpage(base.driver);
        page.ToBeDiscardReset();
    }

    @And("^I verify that Imp Instr wo displays under To Be Discarded tab$")
    public void iVerifyThatImpInstrWoDisplaysUnderToBeDiscardedTab(DataTable table) throws Throwable {
        System.out.println("Searches with WO used in Important Instructions tab");
        List<ToBeDiscard> search = new ArrayList<ToBeDiscard>();
        search = table.asList(ToBeDiscard.class);
        Loginpage page = new Loginpage(base.driver);
        Thread.sleep(3000);
        for(ToBeDiscard wosearch : search) {
            page.ToBeDiscard(wosearch.tobediscardwosearch);
        }
    }

    @And("^I click on a record and edit to check for Incoming Responses func$")
    public void iClickOnARecordAndEditToCheckForIncomingResponsesFunc() throws Throwable {
       System.out.println("Edit a record to move to Incoming Responses tab");
       Loginpage page = new Loginpage(base.driver);
       Thread.sleep(3000);
       page.SelWO();
       Thread.sleep(3000);
       page.editingwofun();
      }

    public class ToBeDiscard {
        public String tobediscardwosearch;

        public ToBeDiscard(String ToBeDiscard) {
            tobediscardwosearch = ToBeDiscard;
        }
    }


    public class CompletedWosearch {
        public String completedWO;  // clientcode, noofcerts, rushbulk;

        public CompletedWosearch(String CompletedWo, String ClientCode, String Noofcerts, String RushBulk) {
            completedWO = CompletedWo;
           /* clientcode = ClientCode;
            noofcerts = Noofcerts;
            rushbulk = RushBulk;*/
        }
    }

    @And("^user clicks on reports button$")
    public void userClicksOnReportsButton() throws Throwable {
        Loginpage page = new Loginpage(base.driver);
        Thread.sleep(3000);
        page.ReportsButton();
        Thread.sleep(3000);
        String currentWindow = base.driver.getWindowHandle();  //Switching frames
        base.driver.switchTo().window(currentWindow);
    }

    @And("^Get the WO value$")
    public void getTheWOValue() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        Loginpage page = new Loginpage(base.driver);
        page.submit1();
        Thread.sleep(5000);
     //   page.WOvalue();
    }

    @And("^Row Text$")
    public void rowText() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        Thread.sleep(5000);
        Loginpage page = new Loginpage(base.driver);
        page.rowcolorstext();
    }

    @And("^Pagination value$")
    public void paginationValue(DataTable table) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        List<pagin> pages = new ArrayList<pagin>();
        pages = table.asList(pagin.class);
        Loginpage page = new Loginpage(base.driver);
        for (pagin page1 : pages) {
            page.pagin(page1.pagevalue);
        }
        Thread.sleep(5000);
        page.pagin1();
    }
    public class pagin
    {
        public String pagevalue;
        public pagin(String Pagevalue)
        {
            pagevalue = Pagevalue;
        }
    }





    //Declaring variables //
    public class SignIn {
        public String email, password;

        public SignIn(String Email, String Password) {
            email = Email;
            password = Password;
        }
    }

    public class pickclient {
        public String company, service;

        public pickclient(String Company, String Service) {
            company = Company;
            service = Service;
        }
    }

    public class Certsaddworkorder {
        public String addwoprocess, addwoisassign, addwoishold, addwoisemail, addwoisdiscard, addwoisdelivered, addwoistaskcompleted, addwoholdreason, addwoupdate, addwofrompending, addworush, addwobulk, addwoassignto,
                addwostatus, addwofolder, addworequestor, addwosentto, addwosummary, addwoassignedto, addwoadddate, addwostartdateoverride, addwoduedateoverride, addwoduedate;

        public Certsaddworkorder(String addwoprocess, String addwoisassign, String addwoishold, String addwoisemail, String addwoisdiscard, String addwoisdelivered, String addwoistaskcompleted, String addwoholdreason, String addwoupdate, String addwofrompending, String addworush, String addwobulk, String addwoassignto, String addwostatus, String addwofolder, String addworequestor, String addwosentto, String addwosummary, String addwoassignedto, String addwoadddate, String addwostartdateoverride, String addwoduedateoverride, String addwoduedate) {
            this.addwoprocess = addwoprocess;
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
            this.addwofolder = addwofolder;
            this.addworequestor = addworequestor;
            this.addwosentto = addwosentto;
            this.addwosummary = addwosummary;
            this.addwoassignedto = addwoassignedto;
            this.addwoadddate = addwoadddate;
            this.addwostartdateoverride = addwostartdateoverride;
            this.addwoduedateoverride = addwoduedateoverride;
            this.addwoduedate = addwoduedate;
        }
    }

    public class Wodetailsectionentry {
        public String noofcerts, clientcode, clientname, wotype, branchoffice, department, division, profitcenter, certmaster, certissuancesystem, noofholders, certissuedby, qaby, deliveryby, complexity;

        public Wodetailsectionentry(String noofcerts, String clientcode, String clientname, String wotype, String branchoffice, String department, String division, String profitcenter, String certmaster, String certissuancesystem, String noofholders, String certissuedby, String qaby, String deliveryby) {
            this.noofcerts = noofcerts;
            this.clientcode = clientcode;
            this.clientname = clientname;
            this.wotype = wotype;
            this.branchoffice = branchoffice;
            this.department = department;
            this.division = division;
            this.profitcenter = profitcenter;
            this.certmaster = certmaster;
            this.certissuancesystem = certissuancesystem;
            this.noofholders = noofholders;
            this.certissuedby = certissuedby;
            this.qaby = qaby;
            this.deliveryby = deliveryby;
            this.complexity = complexity;
        }
    }

    public class descriptionoforiginalemail {
        public String originalemail;
        public descriptionoforiginalemail(String originalemail) {
            this.originalemail = originalemail;
        }
    }

    public class selectingfolder {
        public String foldername;
        public selectingfolder(String foldername) {
            this.foldername = foldername;
        }
    }

    public class wonumbersearch {
        public String wonumber;
        public wonumbersearch(String wonumber) {
            this.wonumber = wonumber;
        }
    }

    public class WorkOrderSearch {
        public String wo, clientcode, summary ;
        public WorkOrderSearch(String WorkOrder, String ClientCode, String Summary) {
            wo = WorkOrder;
            clientcode = ClientCode;
            summary = Summary;
        }
    }

    public class assign {
        public String process, assign;
        public assign(String Process, String Assign) {
            process = Process;
            assign = Assign;
        }
    }

    public class SelectProcessingWOform {
        public String wo, adddate, duedate, assignedto, rush, bulk, frompending, update, process, isassigned, ishold, isemail, isdiscard, isdelivered, istaskcompleted, status, folder, startdateoverride,
                duedateovrride, holdreason, assignto, summary, requestor, sentto;
        public SelectProcessingWOform(String WO, String AddDate, String DueDate, String AssignedTo, String IsHold, String Rush, String Bulk, String FromPending, String Update, String Process, String IsAssigned, String IsEmail,
                                      String IsDiscard, String IsDelivered, String IsTaskCompleted, String Status, String Folder, String StartDateOverride, String DueDateOvrride, String Holdreason, String Assignto,
                                      String Summary, String Requestor, String Sentto) {
            wo = WO;
            adddate = AddDate;
            duedate = DueDate;
            assignedto = AssignedTo;
            ishold = IsHold;
            rush = Rush;
            bulk = Bulk;
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

    public class Detail {
        public String numofcerts, clientcode, clientname, workordertype, branchoffice, department, division, holders, certmaster, profitcenter, certissuancesystem, certissuedby, qaby, insureddelivery, deliveryby,
                certholderdelivery, carrierfax, carrieremail, amdelievry, twbet, insuredmethod, certholdermethod, carriermethod, csrcontact1, csrcontact2, pages, comments, additionalcomments, complexity;


        public Detail(String NumOfCerts, String ClientCode, String ClientName, String WorkOrderType, String BranchOffice, String Department, String Division, String Holders,
                      String Certmaster, String ProfitCenter, String CertIssuanceSystem, String CertIssuedby, String QaBy, String DeliveryBy, String InsuredDelivery,
                      String CertHolderDelivery, String CarrierFax, String CarrierEmail, String AMdelievry, String TWBet, String InsuredMethod, String CertHoldermethod,
                      String CarrierMethod, String CSRcontact1, String CSRcontact2, String Pages, String AdditionalComments, String Comments, String Complexity) {
            numofcerts = NumOfCerts;
            clientcode = ClientCode;
            clientname = ClientName;
            workordertype = WorkOrderType;
            branchoffice = BranchOffice;
            department = Department;
            division = Division;
            holders = Holders;
            certmaster = Certmaster;
            profitcenter = ProfitCenter;
            certissuancesystem = CertIssuanceSystem;
            certissuedby = CertIssuedby;
            qaby = QaBy;
            deliveryby = DeliveryBy;
            insureddelivery = InsuredDelivery;
            certholderdelivery = CertHolderDelivery;
            carrierfax = CarrierFax;
            carrieremail = CarrierEmail;
            amdelievry = AMdelievry;
            twbet = TWBet;
            insuredmethod = InsuredMethod;
            certholdermethod = CertHoldermethod;
            carriermethod = CarrierMethod;
            csrcontact1 = CSRcontact1;
            csrcontact2 = CSRcontact2;
            pages = Pages;
            additionalcomments = AdditionalComments;
            comments = Comments;
            complexity = Complexity;
        }
    }

    public class QA {
        public String auditqa, errors, errormadeby, errortype, filedby, errdesc;
        public QA(String AuditQA, String Errors, String ErrorMadeBy, String ErrorType, String Filedby, String ErrDesc) {
            auditqa = AuditQA;
            errors = Errors;
            errormadeby = ErrorMadeBy;
            errortype = ErrorType;
            filedby = Filedby;
            errdesc = ErrDesc;
        }
    }

    public class secondqa {
        public String needed, done, doneby;
        public secondqa(String Needed, String Done, String Doneby) {
            needed = Needed;
            done = Done;
            doneby = Doneby;
        }
    }

    public class kpidelwosearch {
        public String kpidelWO;

        public kpidelwosearch(String KPIdelWO) {
            kpidelWO = KPIdelWO;
        }
    }

    public class GlobalSearch {
        public String globalsearch;

        public GlobalSearch(String Globalsearch) {
            globalsearch = Globalsearch;
        }
    }

    public class ColSe {
        public String colwonumber, clientcode, summary, status, requestor, noofcerts, rushbulk, branchoffice, pending, wotype, update;
        public ColSe(String Colwonumber, String Clientcode, String Summary, String Requestor, String Noofcerts, String Rushbulk, String Status, String Branchoffice, String Pending, String Wotype, String Update) {
          //  colwonumber = Colwonumber;
            clientcode = Clientcode;
            summary = Summary;
          /*  status = Status;
            requestor = Requestor;
            branchoffice = Branchoffice;
            noofcerts = Noofcerts;
            rushbulk = Rushbulk;
            pending = Pending;
            wotype = Wotype;
            update = Update;*/
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

    public class TraDm{
        public String trtask, trstarttime, trendtime;
        public TraDm(String Trtask, String Trstarttime, String Trendtime){
            trtask = Trtask;
            trstarttime = Trstarttime;
            trendtime = Trendtime;
        }
    }

    public class WOStartTimer
    {
        public String task;
        public WOStartTimer(String task) {
            this.task = task;
        }
    }

 //Incoming Response tab
    public class IncResWosearch {
        public String increswo;

        public IncResWosearch(String IncResWO) {
            increswo = IncResWO;
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
// Discarded Module
    public class DiscardWOsearch {
        public String discardwosearch;
        public DiscardWOsearch(String DiscardWOSearch) {
            discardwosearch = DiscardWOSearch;
        }
    }
    public class UpdateDiscardedWO
    {
        public String summary, requestor, sentto;
        public UpdateDiscardedWO(String Summary, String Requestor, String SentTo) {
            summary = Summary;
            requestor = Requestor;
            sentto = SentTo;
        }
    }

    public class UpdateDiscardedWODetail
    {
        public String ofcerts, clientcode, clientname, workordertype, branchoffice, department, division, ofholders, certmaster, profitcenter, certissuancesystem, ofholdersdatedoffcount, certissuedby,
                qaby, deliveryby, insureddelivery, certholderdelivery, carrierdeliveryfaxemail, carrierdeliveryemail, accountmanagerdelivery, twbetfiled, insuredmethod, certholdermethod, carriermethod,
                csrcontact1, csrcontact2, ofpages, additionadeliverycomments, comments, datedelivery, datecompleted;

        public UpdateDiscardedWODetail(String ofcerts, String clientcode, String clientname, String workordertype, String branchoffice, String department, String division, String ofholders,String profitcenter, String certmaster, String certissuancesystem, String ofholdersdatedoffcount, String certissuedby, String qaby, String deliveryby, String insureddelivery, String certholderdelivery, String carrierdeliveryfaxemail, String accountmanagerdelivery, String twbetfiled, String insuredmethod, String certholdermethod, String carriermethod, String csrcontact1, String csrcontact2, String ofpages, String additionadeliverycomments, String comments, String datedelivery, String datecompleted) {
            this.ofcerts = ofcerts;
            this.clientcode = clientcode;
            this.clientname = clientname;
            this.workordertype = workordertype;
            this.branchoffice = branchoffice;
            this.department = department;
            this.division = division;
            this.ofholders = ofholders;
            this.certmaster = certmaster;
            this.profitcenter = profitcenter;
            this.certissuancesystem = certissuancesystem;
            // this.ofholdersdatedoffcount = ofholdersdatedoffcount;
            this.certissuedby = certissuedby;
            this.qaby = qaby;
            this.deliveryby = deliveryby;
            this.insureddelivery = insureddelivery;
            this.certholderdelivery = certholderdelivery;
            this.carrierdeliveryfaxemail = carrierdeliveryfaxemail;
            // this.carrierdeliveryemail = carrierdeliveryemail;
            this.accountmanagerdelivery = accountmanagerdelivery;
            this.twbetfiled = twbetfiled;
            this.insuredmethod = insuredmethod;
            this.certholdermethod = certholdermethod;
            this.carriermethod = carriermethod;
            this.csrcontact1 = csrcontact1;
            this.csrcontact2 = csrcontact2;
            this.ofpages = ofpages;
            this.additionadeliverycomments = additionadeliverycomments;
            this.comments = comments;
            this.datedelivery = datedelivery;
            this.datecompleted = datecompleted;
        }
    }

    public class ImportantInstr {
        public String summary;
        public ImportantInstr (String Summary) {
            summary = Summary;
        }
    }
}
