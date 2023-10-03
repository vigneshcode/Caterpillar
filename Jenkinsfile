pipeline {
  agent any
  stages {
    stage('Build') {
      parallel {
        stage('Build') {
          steps {
            echo 'Building'
          }
        }

        stage('Test') {
          steps {
            echo 'Testing'
          }
        }

      }
    }

    stage('Deploy') {
      steps {
        echo 'Deploy'
        mail(subject: 'Build Success', body: 'Build Success', to: 'dtechyogi@gmail.com')
      }
    }

  }
  environment {
    branchName = 'master'
  }
}