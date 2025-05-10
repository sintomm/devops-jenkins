pipeline {
  agent any
  tools {
    maven 'maven-3.9.9'
  }

  stages {
    stage('init') {
      script {
        load gv = script.groovy
      }
    }
    stage('build jar') {
      steps {
         script {
            gv.buildApp()
         }
      }
    }

    stage('build image') {
       steps {
          script {
            gv.builImage()
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

}