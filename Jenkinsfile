pipeline {
  agent any
  environment {
    NEW_VERSION = '1.1.1.1.1'
  }
  parameters {
    choice(name: 'VERSION', choices: ['1.1', '1.2', '1.3'], description: "Choose yor version")
    booleanParam(name: 'runTest', defaultValue: true, description:"Uncheck if tests should be omitted")
  }
  stages {

      stage('init') {
        steps {
          script {
            gv = load "script.groovy"
          }
        }
    }

    stage('build') {
      steps {
         script {
            gv.buildApp()
         }
      }
    }
     stage('test') {
       when {
        expression {
          params.runTest
        }
       }
       steps {
        script {
          gv.testApp()
        }
      }
    }
     stage('deploy') {
       steps {
          script {
            gv.deployApp()
          }
      }
     }
  }
  post {
    always {
      echo "Jenkins finished his jobs"
    }
    success {
      echo "Yep, build was success"
    }
    failure {
         echo "Build failed"
    }
  }
}