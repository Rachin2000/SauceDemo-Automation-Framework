pipeline {

    agent any

    stages {

        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Run Tests') {
            steps {
                bat 'mvn clean test'
            }
        }
    }

    post {

        always {
            archiveArtifacts artifacts: 'test-output/**/*',
            allowEmptyArchive: true
        }

    }
}