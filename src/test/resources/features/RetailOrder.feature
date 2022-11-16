@RetailOrderPage
Feature: Retail Order Page
#Note: For this section, you need to first have orders in place. At least one order must be present

@CancelOrder
Scenario: Verify User can cancel the order 
Given User is on retail website
When User click on Sign in option
And User enter email 'Hakimi@gmail.com' and password 'Hakimi1111111@'
And User click on login button
And User should be logged in into Account

And User click on Orders section 
And User click on first order in list 
And User click on Cancel The Order button
And User select the cancelation Reason 'Bought wrong item'
And User click on Cancel Order button
Then a cancelation message should be displayed 'Your Order Has Been Cancelled'

@returnOrder
Scenario: Verify User can Return the order 
Given User is on retail website
When User click on Sign in option
And User enter email 'Hakimi@gmail.com' and password 'Hakimi1111111@'
And User click on login button
And User should be logged in into Account
And User click on Orders section 
And User click on first order in list 
And User click on Return Items button
And User select the Return Reason 'Item damaged'
And User select the drop off service 'FedEx'
And User click on Return Order button
Then a cancelation message should displayed 'Return was successfull'

@ReviewOrder
Scenario: Verify User can write a review on order placed
Given User is on retail website
When User click on Sign in option
And User enter email 'Hakimi@gmail.com' and password 'Hakimi1111111@'
And User click on login button
And User should be logged in into Account
And User click on Orders section 
And User click on first order in list 

And User click on Review button 
And User write Review headline 'urgent' and 'bring fast' 
And User click Add your Review button
Then a review message should be displayed 'Your review was added successfully'