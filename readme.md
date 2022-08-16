Models->\n
FK-> IDU, PID\n
\n
user- id(IDU), email, password, role, info\n
donor- id(IDU), info, eligibility, last_donate, blood_type\n
donation - id, donor_id(IDU), request_id(IDU), blood_type\n
visitor- id(IDU), info, post_id(PID)\n
post-id(PID), user_id(IDU),post_info, last status\n
necessary- id, poster_id(IDU), upvoter_id(IDU)\n
blood history - id, user_id(IDU),donor_id(IDU), blood type, action, time\n
\n
Backened API->\n
\n
GetUserByID\n
GetAllUser\n
GetUserAllPost\n
SavePost\n
UpdatePost\n
CheckPass\n
UpdateUserPI-> Success\n
SaveUser-> UserID\n
SavePost\n
UpdatePost\n
\n
\n
GetAllUserEmail [Reg Button Clicked]\n
Security>Redir(UserId) [Login Clicked]\n
\n
+Visitor\n
GetAllPostUnsolved [News feed load]\n
GetAllDonor [Blood Bank Load]\n
SearchDonor [Search Blood]\n
RequestDonor[Requesting]\n
ShowVisitorHistory[History load]\n
UpdateSolved[Solve Clicked]\n
\n
+DONOR\n
\n
LoadEligibility[Request Page Load]\n
GetAllPostUnsolved [News feed load]\n
ShowRequests [Request Page Load]\n
ShowDonorHistory[History load]\n
DoneDonation[Donate Clicked]\n
\n
\n
Frontend API->\n
\n
Dash Page\n
Login Page\n
\n
+Visitor\n
\n
VISITOR DASH\n
PERSONAL INFO\n
Blood Bank\n
Posts\n
\n
+DONOR\n
\n
Donor Dash\n
Personal Info\n
Blood Requests\n
