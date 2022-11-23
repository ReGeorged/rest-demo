
# Books api demo test launch parameters

#### სისტემაზე მეივენის არსებობის შემთხვევაში ტესტების გაშვება შესაძლებელია maven surefire- ით

### maven target and source jdk -11

#### ყველა ტესტის გასაშვებად:
     mvn clean test

#### იუზერნეიმის პარამეტრის გადასაცემად (მაგალითად):
    mvn clean test -D user-name=customNa23qq2
    
    in case of no parameters default value is generated fromdefaultTestData.json

#### პირველი ქეისის გასაშვებად:
    mvn clean test -Dtest=UserTest

#### მეორე  ქეისის გასაშვებად:
     mvn clean test -Dtest=AuthTest
#### პარამეტრის გადაცემა მეორე ქეისისათვის:
     mvn clean test -D user-name=custom -Dtest=AuthTest

#### სისტემაზე ელურის არსებობის შემთხვევაში ელიურის ყველა რეპორტის აწევა:
    allure serve allure-results