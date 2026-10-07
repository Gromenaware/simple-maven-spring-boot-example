pipeline {
    
    agent any

    stages {
        stage('Checkout code'){
            steps {
                git 'https://github.com/Gromenaware/simple-maven-spring-boot-example.git'
            }
        }
        stage('Build Application') {
            steps {
                sh 'mvn -B -DskipTests clean package'
            }
        }
        stage('Test Execution') {
            steps {
                sh 'mvn test'
            }
        }
    }
    
    post {            
        always {
            junit 'target/surefire-reports/*.xml'
        }
        success {
            archiveArtifacts artifacts: 'target/*.war', followSymlinks: false
        }
    }
}
