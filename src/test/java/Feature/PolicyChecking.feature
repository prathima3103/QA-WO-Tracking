
Feature: Policy Checking 

  Scenario: Login Functionality.

    Given I navigate to login page of policy checking app
    And I enter login credentials for PC
      | email                  | password |
      | ********************   | ******   |
    And I click on Sign In button for PC
    And I select a client for PC
      | company |
      | USI     |
    And I click on the selected client to open app for PC

    And Pagination value for PC
      | pagevalue |
      | 50        |
    And Row text for PC

    Then I Click on Add Policy for PC
    Then I Enter Add WorkOrder Details for PC
      | Folder            | AddRequestor                | AddSummary              | AddSentTo            |
      | Policies to Check | Testrequestor@patracorp.net | test summary automation | sentto@patracorp.com |
    Then I go to Work Order Details section for PC
    Then I Enter details in WO detail section for PC
      | ClientCode | ClientName | PolicyType  | LinesOfCoverage | Csr  | PolicyStatus | CarrierName | Am | PolicyDetails | NoOf| NoOfDocumentsRetrieved | PolicyNumber |EffectiveDate       | BranchOffice | Department |Division    | ProfitCenter | PolicyCheckedBy | QaBy      | DeliveryBy   | SecondQa     | SecondCheckDocument |ThirdCheckDocument | PolicyCheckedAgainst | NoOfAI | NoOfCoverages | NoOfDocuments | NoOfEndorsements | NoOfHazards | NoOfIMItems | NoOfLocations| NoOfVehicles| RequestFor |BillingType | ComplexityType | Comments |
      | 5          | TEST code  | Aviation    | Test            | Test | All Matches  | Test        |    |               |  1  | 5                      | 12345        |04/25/2018 04:11 AM | No           | ERU        |Not Updated |              | Bujji Babu    | Sushma    | Aneeta K | Bharat Ajay | XYZ                 | XYZ               |                      |123    | 123           | 123           | 123              | 123         | 233         | 12          | 12        | QA Team       | AB         | Easy           |xyz       |
    Then I Click on Original Email for PC
    Then I Write data in Original Email section for PC
      | originalEmail                                                                                                                                                                                                                                                                                                                      |
      | automation testing purpose - @Nu$hA Please see below and attached for certificate request MARY SAFFIOTI Commercial Lines Assistant Account Manager USI Insurance Services LLC 12 Gill Street, Suite 5500, Woburn, MA 01801 781-939-2002  f: 781.376.5035 Mary.Saffioti@usi.com<mailto:Mary.Saffioti@usi.com> www.usi.com<http://www.usi.com/> |
    Then I click on Submit button for PC
    Then I Click on Close on Popup for PC

    And user searches with the following global value for PC
      | globalsearch |
      | 129964   |
    And user clicks the first link for PC
    And I assign that WO for PC
    And I click Mark Rush button for PC
    And i click start timer button in the WO form for PC
    And I clicks start timer in timer pop-up section for PC
    And I enter details in the WO form for PC
      | process | status      | folder               | startdateoverride   | duedateovrride      | requestor          | sentto                | summary                     |
      |         | In Progress | Certificate Requests | 01/25/2018 04:11 AM | 02/26/2018 04:11 AM | e.anusha@kpcom.com | usicert@patracorp.com | testing automation - Anusha |
    Then I Enter details in WO detail section for PC
      | ClientCode | ClientName | PolicyType  | LinesOfCoverage | Csr  | PolicyStatus | CarrierName | Am | PolicyDetails | NoOf| NoOfDocumentsRetrieved | PolicyNumber |EffectiveDate       | BranchOffice | Department |Division    | ProfitCenter | PolicyCheckedBy | QaBy      | DeliveryBy   | SecondQa     | SecondCheckDocument |ThirdCheckDocument | PolicyCheckedAgainst |NoOfAI | NoOfCoverages | NoOfDocuments | NoOfEndorsements | NoOfHazards | NoOfIMItems | NoOfLocations| NoOfVehicles| RequestFor |BillingType | ComplexityType | Comments |
      | 5          | TEST code  | Aviation    | Test            | Test | All Matches  | Test        |    |               |  1  | 5                      | 12345        |21/01/2019 04:11 AM | Alaska       | 103        | 178 |              | renuka Gundu    | Sushma    | Aneeta K | Bharat Ajay | XYZ                 | XYZ               |                      |123    | 123           | 123           | 123              | 123         | 123         | 123          | 123         | QA Team       | AB         | Easy           |xyz       |
    And I click Attachments tab for PC
    And I click Emails tab for PC
    And I click History tab for PC
    And I click QA tab for PC
    And I click Time Records tab for PC
    And I click Add Attachments button for PC
    And I click on Print PDF button for PC
    And I clicks stop timer button for PC
    Then I Close the work order for PC
    And I click on WorkOrders page link for PC

    Then I Click on Policies to Check KPI for PC
    And Get the KPI Value for Policies to Check
    And I search a record with the wo number for PC
      | wo | clientcode | summary               |
      |    |            | test summary automation |
    And I Selects Workorder for PC
    And I edit WO fields for PC
    And I click Submit button in WO page for PC
    Then I Close the work order for PC
    And I click on WorkOrders page link for PC

    Then I Click on Checklist Processing KPI for PC
    And Get the KPI Value for Checklist Processing
    And I search a record with the wo number for PC
      | wo     | clientcode | summary                  |
      |        |            | test summary automation|
    And I Selects Workorder for PC
    And I assign that WO with process qa for PC
    And I click Submit button in WO page for PC
    Then I Close the work order for PC

    Then I Click on Quality Assurance KPI for PC
    And Get the KPI Value for Quality Assurance
    And I search a record with the wo number for PC
      | wo     | clientcode | summary                  |
      |        |            | test summary automation |
    And I Selects Workorder for PC
    And I click QA tab for PC
    Then I Enter details in QA section for PC
      | Qa | NoOfErrors | ErrorMadeBy | ErrorType | ErrorFiledBy| ErrorDescription |
      | QA | 1          | Sushma      | Premium   | Sushma      | XYZ              |
    And I assign that WO with process Delivery for PC
    And I click Submit button in WO page for PC
    Then I Close the work order for PC

    And I click KPI Delivery for PC
    And Get the KPI Value for Policy Delivery
    And I search a record with the wo number for PC
      | wo     | clientcode | summary               |
      |        |            | test summary automation |
    And I Selects Workorder for PC
    And I click on Email and Task completed radio buttons
    Then I Close the work order for PC
    And I click on completed tab for PC
    And user searches with the following global value for PC
      | globalsearch |
      | 4704     |
    And user clicks the first link for PC
    Then I Close the work order
    And I click on Pending responses KPI for PC
    And Get the KPI Value for Pending Responses
    And I search a record with the wo number for PC
      | wo     | clientcode | summary                  |
      |        |            | test summary automation |
    And I click the wo and edit for PC
    And I assign that WO with folder Incoming Responses for PC
    And I edit WO fields for PC
    Then I Close the work order for PC

    And I click on Incoming Responses tab for PC
    And Get the KPI Value for Incoming Responses
    And I search a record with the wo number for PC
      | wo     | clientcode | summary                  |
      |        |            | test summary automation |
    And I click the incomng res wo and edit for PC
    And user updates the following details under discarded work order for PC
      | summary                | requestor              | sentto     |
      | ^^ Can be Discarded ^^ | e.anusha@patracorp.com | automation |
    And I  click on discard button to discard workorder for PC
    And I click Ok button on discard alert pop-up1 for PC
    And user clicks discarded work order submit button for PC
    Then I Close the work order for PC

    And user clicks on discarded tab for PC
    And I search record with WO number under discarded tab for PC
      | discardwosearch |
      | 88760         |
    And user selects particular work order on discarded tab for PC
    Then I Close the work order for PC

    And user clicks on reports button for PC
    And I click Time Records page link for PC
    And I work on time record admin for PC
    And I select Start Time From and To dates for PC
      | from               | to                 |
      | 12/01/2018 2:05 AM | 12/31/2018 1:00 AM |
    And I select service in service column from time record admin for PC
      | Trcompany | Trservice            | Trtaskdescription    | Trworkordernumber | Tremployee |
      | USI       | Certificate Issuance | Certificate Issuance |           | renuka Gundu  |
    And I Edit the selected time record for PC
      | trtask             | trstarttime         | trendtime           |
      | Checking Responses | 08/12/2018 11:56 PM | 08/12/2018 11:59 PM |

    And I click on Time Rec Open tab for PC

    And I click on patra corp link for PC
    Then I Click on Logout icon for PC
    Then I click Logout button for PC
