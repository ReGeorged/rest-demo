# Books api demo test launch commands & parameters
### maven target and source jdk -11
#### სისტემაზე მეივენის არსებობის შემთხვევაში ტესტების გაშვება შესაძლებელია maven surefire- ით
<em> ყველა ბრძანება უნდა გაიშვას შესაბამისი დირექტორიიდან !</em>

#### ყველა ტესტის გასაშვებად:
    mvn clean test
#### იუზერნეიმის პარამეტრის გადასაცემად (მაგალითად):
    mvn clean test -D user-name=customNa23qq2

<em>in case of no parameters default value is generated fromdefaultTestData.json</em>

    

#### პირველი ქეისის გასაშვებად:
    mvn clean test -Dtest=AuthCasesTest

#### მეორე  ქეისის გასაშვებად:
     mvn clean test -Dtest=AuthScenarioTest
#### პარამეტრის გადაცემა მეორე ქეისისათვის:
     mvn clean test -D user-name=custom -Dtest=AuthScenarioTest

#### სისტემაზე ელურის არსებობის შემთხვევაში ელიურის ყველა რეპორტის აწევა:
    allure serve allure-results


<em>რეპოზიტორიაში არსებობს მეორე ბრენჩი, surefire & allure dependencie-ების გარეშე</em>