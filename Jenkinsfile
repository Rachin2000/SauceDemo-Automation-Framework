pipeline {

    agent any

    tools {
        jdk 'JDK-21'
        maven 'Maven-3.9.14'
    }

    stages {

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