Feature: To verify the cheque book request 

Scenario Outline: Verify the login with valid credentials

 Given Customer Opens the browser and enters valid VP demo <URL>
 When Customer enter valid <username> and <password>
 And Customer Clicks on the Login button
 Then Customer should be navigated to the Home Page
 
 Examples:
 |URL|username|password|
 |https://vtdemoqa.crm4.dynamics.com/main.aspx|demouser@vtonline04.onmicrosoft.com|qnfvi7m85xwnV/zpHQoAzw==|
 
 Scenario Outline: Select the customer from customer search
 Given Customer in to the home page of VP demo application
 When Customer click on the Customer search
 And Enters the Customer Name as <customerName> and clicks the Search button
 Then Search result should be displayed with the given customer
 
 Examples:
 |customerName|
 |Thomas Miller|
 
 Scenario: Select the customer from search result and raise the check book request from new service request
 Given Customer in to new service request page
 When Customer selects the New Service request
 And Click on the subject drop down from Case Details
 And Select the value as Cheque book request under Retail service requests--> Accounts--> Cheque book request
 And Select the value from Cheque book delivery drop down and select the Cheque book leaves
 And Click on the Ingenius link on the top right corner to validate the track number as --
 And Click the Save button
 Then Click on the Administration page and validat the Tracking number and status

 Scenario:
 Given when customer raise the cheque book request
 When Click on the Profile button and Click the Signout 
 Then Close the browser