Feature:
  Scenario: User info segment should be editable on Homepage
      Given user should be on the homepage "homepage_url"
      When user navigates to sign in page
      Then User clicks Sign in button
      Then User provide firstName "<firstName>"
      Then User provide lastName "<lastName>"
      Then User clicks Sign in button
      Then User clicks the name of the customer
      Then User clicks User Info button
      Then User edits First Name
      And  User edits Last Name
      Then User edits email
      Then User checks Languages
      Then User clicks Save button




