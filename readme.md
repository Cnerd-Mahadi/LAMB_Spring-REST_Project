Models->  
FK-> IDU, PID  
  
user- id(IDU), email, password, role, info  
donor- id(IDU), info, eligibility, last_donate, blood_type  
donation - id, donor_id(IDU), request_id(IDU), blood_type  
visitor- id(IDU), info, post_id(PID)  
post-id(PID), user_id(IDU),post_info, last status  
necessary- id, poster_id(IDU), upvoter_id(IDU)  
blood history - id, user_id(IDU),donor_id(IDU), blood type, action, time  
  
Backened API->  
  
GetUserByID  
GetAllUser  
GetUserAllPost  
SavePost  
UpdatePost  
CheckPass  
UpdateUserPI-> Success  
SaveUser-> UserID  
SavePost  
UpdatePost  
  
  
GetAllUserEmail [Reg Button Clicked]  
Security>Redir(UserId) [Login Clicked]  
  
+Visitor  
GetAllPostUnsolved [News feed load]  
GetAllDonor [Blood Bank Load]  
SearchDonor [Search Blood]  
RequestDonor[Requesting]  
ShowVisitorHistory[History load]  
UpdateSolved[Solve Clicked]  
  
+DONOR  
  
LoadEligibility[Request Page Load]  
GetAllPostUnsolved [News feed load]  
ShowRequests [Request Page Load]  
ShowDonorHistory[History load]  
DoneDonation[Donate Clicked]  
  
  
Frontend API->  
  
Dash Page  
Login Page  
  
+Visitor  
  
VISITOR DASH  
PERSONAL INFO  
Blood Bank  
Posts  
  
+DONOR  
  
Donor Dash  
Personal Info  
Blood Requests  


EXTRA->  
https://lamb-backend.herokuapp.com/user/register
https://lamb-backend.herokuapp.com/visitor/dash  
  
  









"username": "TAFSIR",  
"email": "donor@gmail.com",  
"password": "1234",  
"role": "donor",  
"phone": "0174569875",  
"area": "B",
"dob": "10-10-1999",  
  
"eligibility": "YES",    
"last_donate": "10-10-2021",    
"blood_type": "O+"    

