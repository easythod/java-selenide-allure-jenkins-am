
node {
    DOCKERFILE_PATH = './Dockerfile'
}


pipeline {
  agent {
         dockerfile {
                filename "${DOCKERFILE_PATH}"
                args  '--net=host -e DISPLAY=":0"'
                args '--entrypoint=\'\''
                reuseNode true
        }
  }

 stages {
  stage('Clone scm') {
   steps {
    checkout([$class: 'GitSCM', branches: [
      [name: '*/master']
     ],
     userRemoteConfigs: [
      [url: 'https://github.com/UgenLaps/java-selenide-allure-jenkins-am.git']
     ]
    ])
   }
  }

  stage('Run Tests') {
   steps {
    sh "mvn clean test"
    sh "allure generate --clean"
   }
  }

    stage('Publish Reports') {
        steps{
        publishHTML(
                target: [
                        allowMissing         : false,
                        alwaysLinkToLastBuild: false,
                        keepAll              : true,
                        reportDir            : './allure-report',
                        reportFiles          : 'index.html',
                        reportName           : "Allure Report"
                ]
        )
    }
    }
 }
}

