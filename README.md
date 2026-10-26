# CS320
SNHU CS320 Software Test, Automation QA
Module Eight Portfolio Item

Q: How can I make sure my code is functional and Secure?
A: Test it against the requirements, not against what I think the code does. I used boundary tests (e.g., 10 chars pass, 11 chars fails), negative tests that input bad data on purpose, and coverage to locate gaps. Validating input everywhere it can get in matters, too. The phone number check lives in both the constructor and the setter, because otherwise bad data could sneak in through an update. Having another person review the work also helps, since I tend to have the same blind spots in both my code and tests.

Q: How do I interpret users needs and put them into a program?
A: I turn each requirement into a specific rule and then a test, like "phone number must be exactly 10 digits" or "the ID can't be changed." If a requirement isn't clear, I should ask early on. I read required as "not null," so empty strings still get through, which is something that should be cleared up with the client (for example, a customer might have an international number that requires a country code).

Q: How do I approach designing software?
A: I keep it simple and build the tests alongside the code. I employ small classes that each do one job, like a Contact that validates itself and a ContactService that manages the list. I also try to keep things cleaned up as I go. Copy-pasting during the milestones left me with repeated code that I had to fix later, so I would rather not create that sort of technical debt again.
