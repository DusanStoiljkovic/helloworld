<img width="1080" height="490" alt="Screenshot 2025-09-18 at 10 17 21" src="https://github.com/user-attachments/assets/e372d5df-2fa1-45ed-b963-e9a67e871bfe" /># HelloWorld — Job Search Platform

<img width="1372" height="784" alt="Screenshot 2025-09-18 at 10 17 39" src="https://github.com/user-attachments/assets/6b303f01-b278-473f-848c-6e3fc59a2c01" /># HelloWorld — Candidate Dashboard

<img width="1378" height="789" alt="Screenshot 2025-09-18 at 10 17 58" src="https://github.com/user-attachments/assets/13ba4305-7523-4c02-a6f8-3029834de7a5" /># HelloWorld — Job Details as Candidate

<img width="1379" height="786" alt="Screenshot 2025-09-18 at 10 18 11" src="https://github.com/user-attachments/assets/6ccceb7b-6132-4957-ba30-c00be70819c8" /># HelloWorld — Set up you acc as Candidate

<img width="1378" height="788" alt="Screenshot 2025-09-18 at 10 18 37" src="https://github.com/user-attachments/assets/9779f8f9-fdcf-48ff-8daa-52883bf28b44" /># HelloWorld — Recruiter Dashboard

<img width="1369" height="786" alt="Screenshot 2025-09-18 at 10 18 55" src="https://github.com/user-attachments/assets/1b0f5ef5-2f90-4321-923f-66a0a565caa8" /># HelloWorld — Job Details as Recruiter




**Author:** Dusan Stoiljkovic  
**Date:** 18.09.2025. 
**Version:** 1.0  

Job Portal Web Application

📌 Overview

A Spring Boot based job portal application that connects job seekers and recruiters. Job seekers can create profiles, apply to jobs, and save postings, while recruiters can post jobs and manage applicants.

🛠️ Tech Stack
	•	Java 17+
	•	Spring Boot 3 (Spring MVC, Spring Data JPA, Spring Security)
	•	Hibernate (ORM)
	•	MySQL (or any relational DB)
	•	Lombok
	•	Maven

⚙️ Architecture

The project follows the MVC (Model-View-Controller) pattern:
	•	Models (Entities) – represent the database tables
	•	Repositories – provide data access with Spring Data JPA
	•	Services – implement business logic
	•	Controllers – expose RESTful endpoints

⸻

## 📂 Project Structure  

- **Entities**  
  - `Users` – represents system users (job seekers or recruiters)  
  - `UsersType` – defines roles (Admin, Recruiter, JobSeeker)  
  - `RecruiterProfile` – recruiter information and company details  
  - `JobCompany` – company details linked to recruiters  
  - `JobLocation` – job location info  
  - `RecruiterJobsDto` – DTO for recruiter job postings  
  - `JobPostActivity` – job posting activity tracking  
  - `JobSeekerProfile` – job seeker personal and professional profile  
  - `JobSeekerApply` – applications submitted by job seekers  
  - `JobSeekerSave` – saved job postings  
  - `Skills` – job seeker skills  

- **Services**  
  - `CustomUserDetailsService` – handles authentication with Spring Security  
  - `UsersService` – user management  
  - `UsersTypeService` – role/permissions management  
  - `RecruiterProfileService` – recruiter management  
  - `JobPostActivityService` – posting and managing jobs  
  - `JobSeekerProfileService` – job seeker profile management  
  - `JobSeekerApplyService` – job applications  
  - `JobSeekerSaveService` – saving jobs  

- **Controllers**  
  - `HomeController` – handles landing pages and general endpoints  
  - `UsersController` – user registration and login  
  - `RecruiterProfileController` – recruiter operations  
  - `JobSeekerProfileController` – job seeker operations  
  - `JobSeekerApplyController` – applying to jobs  
  - `JobSeekerSaveController` – saving jobs  
  - `JobPostActivityController` – job posting management  
