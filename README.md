# Password Handout

## Description 
Password handout is a simple POC code to demonstrate using a hostname as a password 
that then gets sent to a *Password By Encryption* engine

There are 2 issues with this method - the level of entropy is quite low in the hostname 
of a source server so the password is quite weak. The second issue is that the hostname 
can be forged and for that reason it would be anticipated that TLS mutual authentication 
would also be deployed as a counter measure.