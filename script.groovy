def buildApp() {
  echo "Building app..."
  sh 'mvn package'
};

def buildImage() {
  echo "Building docker image and push to docker hub..."
  withCredentials([usernamePassword(credentialsId: 'docker-hub-credentials', passwordVariable: 'PASS', usernameVariable: 'USER')]) {
    sh 'docker build -t yom/demo-app:1.0'
    sh 'echo $PASS | docker login -u $USER --password-stdin'
    sh 'docker push'
  }
};

def deployApp() {
     echo 'Deploying app...'
};


return this