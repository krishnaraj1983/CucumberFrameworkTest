$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("pwc.feature");
formatter.feature({
  "line": 1,
  "name": "Login into account",
  "description": "Existing stackoverflow user should be able to login into account using correct credentials",
  "id": "login-into-account",
  "keyword": "Feature"
});
formatter.before({
  "duration": 9556028800,
  "status": "passed"
});
formatter.scenario({
  "line": 4,
  "name": "Login into account with correct details",
  "description": "",
  "id": "login-into-account;login-into-account-with-correct-details",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 5,
  "name": "I navigate to the PwCDigitalPulse website",
  "keyword": "Given "
});
formatter.step({
  "line": 6,
  "name": "I am viewing the ‘Home’ page",
  "keyword": "When "
});
formatter.step({
  "line": 7,
  "name": "I am presented with a carousel displaying 3 featured articles",
  "keyword": "Then "
});
formatter.step({
  "line": 8,
  "name": "Clicking the ‘Next’ button on the carousel will load the next 3 featured articles",
  "keyword": "And "
});
formatter.step({
  "line": 9,
  "name": "Clicking the ‘Previous’ button on the carousel will load the previous 3 featured articles",
  "keyword": "And "
});
formatter.match({
  "location": "PWCStepDefinitions.user_navigates_to_pwc_website()"
});
formatter.result({
  "duration": 2862266300,
  "status": "passed"
});
formatter.match({
  "location": "PWCStepDefinitions.homePageHeading()"
});
formatter.result({
  "duration": 141678600,
  "status": "passed"
});
formatter.match({
  "location": "PWCStepDefinitions.displaying_3_featured_articles()"
});
formatter.result({
  "duration": 475500300,
  "status": "passed"
});
formatter.match({
  "location": "PWCStepDefinitions.ClickOnNext()"
});
formatter.result({
  "duration": 659560700,
  "status": "passed"
});
formatter.match({
  "location": "PWCStepDefinitions.ClickOnPrevious()"
});
formatter.result({
  "duration": 947268500,
  "status": "passed"
});
formatter.after({
  "duration": 36400,
  "status": "passed"
});
formatter.before({
  "duration": 8557719800,
  "status": "passed"
});
formatter.scenario({
  "line": 11,
  "name": "Login into account with correct details",
  "description": "",
  "id": "login-into-account;login-into-account-with-correct-details",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 12,
  "name": "I navigate to the PwCDigitalPulse website",
  "keyword": "Given "
});
formatter.step({
  "line": 13,
  "name": "I click on the ‘Magnifying glass’ icon to perform a search",
  "keyword": "When "
});
formatter.step({
  "line": 14,
  "name": "I enter the text \"Single page applications\"",
  "keyword": "And "
});
formatter.step({
  "line": 15,
  "name": "I submit the search",
  "keyword": "And "
});
formatter.step({
  "line": 16,
  "name": "I am taken to the search results page",
  "keyword": "Then "
});
formatter.step({
  "line": 17,
  "name": "I am presented with at least 1 search result",
  "keyword": "And "
});
formatter.match({
  "location": "PWCStepDefinitions.user_navigates_to_pwc_website()"
});
formatter.result({
  "duration": 2579889200,
  "status": "passed"
});
formatter.match({
  "location": "PWCStepDefinitions.clickonButton()"
});
formatter.result({
  "duration": 352649000,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Single page applications",
      "offset": 18
    }
  ],
  "location": "PWCStepDefinitions.enterValue(String)"
});
formatter.result({
  "duration": 122787300,
  "status": "passed"
});
formatter.match({
  "location": "PWCStepDefinitions.submit()"
});
formatter.result({
  "duration": 77769200,
  "status": "passed"
});
formatter.match({
  "location": "PWCStepDefinitions.searchResults()"
});
formatter.result({
  "duration": 1389223600,
  "status": "passed"
});
formatter.match({
  "location": "PWCStepDefinitions.searchResult()"
});
formatter.result({
  "duration": 13637400,
  "status": "passed"
});
formatter.after({
  "duration": 274600,
  "status": "passed"
});
formatter.before({
  "duration": 8378032600,
  "status": "passed"
});
formatter.scenario({
  "line": 19,
  "name": "Verify the correct details",
  "description": "",
  "id": "login-into-account;verify-the-correct-details",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 20,
  "name": "I navigate to the PwCDigitalPulse website",
  "keyword": "Given "
});
formatter.step({
  "line": 21,
  "name": "I select ‘Contact us’ from the hamburger menu",
  "keyword": "When "
});
formatter.step({
  "line": 22,
  "name": "I am taken to the ‘Contact us’ page",
  "keyword": "Then "
});
formatter.step({
  "line": 23,
  "name": "I am presented with the below options for contacts",
  "rows": [
    {
      "cells": [
        "Heading",
        "Contact"
      ],
      "line": 24
    },
    {
      "cells": [
        "PwC Digital Services",
        "https://digital.pwc.com/en/contact-us.html"
      ],
      "line": 25
    },
    {
      "cells": [
        "Digital Pulse editorial team",
        ""
      ],
      "line": 26
    },
    {
      "cells": [
        "Careers at PwC",
        "https://www.pwc.com/gx/en/careers.html"
      ],
      "line": 27
    },
    {
      "cells": [
        "General enquiries",
        "https://www.pwc.com/gx/en.html"
      ],
      "line": 28
    }
  ],
  "keyword": "And "
});
formatter.match({
  "location": "PWCStepDefinitions.user_navigates_to_pwc_website()"
});
formatter.result({
  "duration": 2546768000,
  "status": "passed"
});
formatter.match({
  "location": "PWCStepDefinitions.clickontheMenu()"
});
formatter.result({
  "duration": 1418864600,
  "status": "passed"
});
formatter.match({
  "location": "PWCStepDefinitions.contactUsMenu()"
});
formatter.result({
  "duration": 1145858200,
  "status": "passed"
});
formatter.match({
  "location": "PWCStepDefinitions.verifyContactDetails(DataTable)"
});
formatter.result({
  "duration": 227255000,
  "status": "passed"
});
formatter.after({
  "duration": 27900,
  "status": "passed"
});
});