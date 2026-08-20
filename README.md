CS320 – Software Testing, Automation, and Quality Assurance
Portfolio Submission – Project One & Project Two

This repository contains selected artifacts from my work in CS 320: Software Testing, Automation, and Quality Assurance. These files demonstrate my ability to design unit tests, validate software requirements, apply structured testing techniques, and reflect on testing strategies and mindset.

Included Artifacts

Project One – Contact Service Module
Files included:
Contact.java
ContactService.java
ContactTest.java
ContactServiceTest.java

These artifacts demonstrate requirement-based testing, boundary value analysis, negative testing, and validation of service-layer business logic.

Project Two – Summary & Reflections Report
File included:
Chris Riegger - CS320 - 7-2 Project Two Submission.docx

This report explains my testing approach, alignment to requirements, testing techniques, mindset, and reflections on quality and discipline.

Reflection

How can I ensure that my code, program, or software is functional and secure?
I ensure functionality and security by grounding development in requirement-based testing, boundary value analysis, and negative testing. Every constructor and service method in Project One was validated through JUnit tests that mapped directly to customer requirements. Defensive programming—such as null checks and strict field constraints—prevents invalid data from entering the system and reduces the likelihood of runtime errors.

How do I interpret user needs and incorporate them into a program?
I interpret user needs by translating requirements into explicit validation rules, service behaviors, and test cases. For example, rules such as “contact ID must be unique” or “appointment date cannot be in the past” became concrete implementation constraints and corresponding tests. This approach follows ISTQB principles of traceability and verification, ensuring that the implementation aligns with user expectations.

How do I approach designing software?
I design software with clarity, maintainability, and disciplined testing in mind. I identify the core responsibilities of each class and keep the design modular and simple. Contact objects were made immutable to prevent accidental state changes, while service classes handled updates through controlled methods. This helps ensure consistent behavior, reduces defects, and supports long-term maintainability.

Course Information
Southern New Hampshire University
CS 320 – Software Testing, Automation, and Quality Assurance
Instructor: Dr. Robert Nardelli
Student: Chris D. Riegger
