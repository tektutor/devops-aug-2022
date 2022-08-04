# Day4

## Waterfall
- is a Framework

- Disadvantages
 - Feedback comes pretty late
 - By the time the customer shared feedback, the product is already complete, the damage is done
 

## Agile
- is Software Development Methodology
- Agile Frameworks
   - SCRUM - one of the popular framework
   - Kanban
   - Extreme Programming (TDD, Pair Programming, CI/CD )
- Fail Fast

## What is Continuous Integration (CI)?
- the code written in committed to source repository several times a time
- engineering practice of Agile ( Fail fast mechanism )
- helps in getting frequent feedbacks
- Tools
    - Continuous Integration Build Server (CI)
      - Jenkins
      - Bamboo
      - Team City
      - Microsoft Team Foundation Server
    - XLR/XLD (XebiaLabs Release/XebiaLabs Deploy)
    - Git/GitHub/GitLab
    - Build Tools ( Maven, Gradle,ms build, etc )
    - TDD ( Java - Junit/TestNg,Mockito, C# - NUnit/MSTest, Moq, Javascript/NodeJS/Angular/ReactJS - Jasmine,Karma)
    - BDD - ( Cucumber,Selenium, Specflow, etc )

## What is Continuous Deployment (CD)?
- The binary that is Unit & Integration Test, can be automatically deployed for further QA Test
- The QA team will have further automated end-to-end functionality test, performance test, stress/load test,etc
- The QA team certified release can further be deployed to Pre-Stage and from there Staging environment for further production like testing

## What is Continuous Delivery (CD)?
- The highest maturity model, wherein the Development Team and the Organization is so confident about their
  CI/CD process and test cases the team (Dev & QA) has added. The confident is so much that you will have automated process to delivery the binaries to your customer or your customer's environment, or it can even go live in Production
  
## What is DevOps?
- Teams
    - Dev Team
    - QA Team
    - System Administration Team
    - All these teams work so closely as a single team
    - Code Repository
       - Dev Team will commit the application code along with Unit & Integaration Test Cases
       - QA Team will commit the E2E, Stree,Load, Performance, etc automated test cases in the same repo
       - System Administration Team will check in Dockerfile, Ansible Playbooks, etc as part of the same repo
- DevOps Engineers
- DevOps Tool
   - Containers - Docker, Podman, etc.,
   - Orchestration Platforms - Docker SWARM, Kubernetes, RedHat OpenShift, AWS ROSA, Azure OpenShift,etc.,
   - Build Tools - Jenkins, Cloudbees, etc.,
   - Pipeline - XLR/XLD, Jenkins, Tekton, etc.,
 
 ## Jenkins
 - CI/CD Build Server
 - developed by Kohsuke Kawaguchi
 - Kohsuke Kawaguchi was a former Sun MicroSystems employee
 - developed a CI/CD tool called Hudson
 - later Oracle acquired Sun MicroSystems
 - Oracle CEO
    - Lary Elison
 - The team that originally developed Hudson they came of Oracle, they forked Hudson source code as Jenkins
 - The part of the Hudson that came out of Oracle maintains the Jenkins, while the team at Oracle maintains the Hudson


