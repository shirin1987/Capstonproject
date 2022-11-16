Feature: Sign In Feature 

@loginScenario
Scenario: Verify user can sign in into Retail Application 

Given User is on retail website 
When User click on Sign in option 
And User enter email 'Hakimi@gmail.com' and password 'Hakimi1111111@' 
And User click on login button 
Then User should be logged in into Account 

 

 
@createAccountScenario
Scenario: Verify user can create an account into Retail Website 

Given User is on retail website 

When User click on Sign in option 

And User click on Create New Account button 

And User fill the signUp information with below data 

| name     | email                   | password  | confirmPassword | 

| panthers | panaadfaaaaf@tekschool.us | Tek@123e45 | Tek@123e45       | 

And User click on SignUp button 

Then User should be logged into account page 