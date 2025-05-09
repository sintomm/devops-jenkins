pipeline {
  agent any
  parameters {
    choice(name: 'VERSION', choices: ['1.1', '1.2', '1.3'], description: "Choose yor version")
    booleanParam(name: 'runTest', defaultValue: true, description:"Uncheck if tests should be omitted")
  }
  stages {
    stage('build') {
      steps {
        echo 'Building app..'
        echo "Building version ${NEW_VERSION}"
      }
    }
     stage('test') {
       when {
        expression {
          params.runTest
        }
       }
       steps {
        echo 'Testing app..'
      }
    }
     stage('deploy') {
       steps {
        echo 'Deploying app...'
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