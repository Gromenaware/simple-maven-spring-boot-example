pipeline {
    agent any
    tools {
        maven 'maven_3_8_6' 
        jdk 'java_docker'
    }
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
        stage('Unit Test Execution') {
            steps {
                sh 'mvn -Dgroups=unit test'
            }
            post {
                always {
                    junit 'target/surefire-reports/*.xml'
                }
            }
        }
        stage('Integration Test Execution') {
            steps {
                sh 'mvn -Dgroups=integration test'
            }
            post {
                always {
                    junit 'target/surefire-reports/*.xml'
                }
            }
        }
        stage('Deployment') {
            steps {
                sh './jenkins/scripts/deliver.sh'
            }
        }
        stage('Functional Test Execution') {
            steps {
                sh 'mvn -Dgroups=functional test'
            }
            post {
                always {
                    junit 'target/surefire-reports/*.xml'
                }
            }
        }
    }
}