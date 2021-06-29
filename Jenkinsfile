pipeline {
    agent any
    tools {
        maven 'maven_325' 
        jdk 'java_9'
    }
    stages {
        stage('Checkout'){
            steps {
            git 'https://bitbucket.org/itnove/simple-maven-spring-boot-example.git'
            }
        }
        stage('Build') {
            steps {
                sh 'mvn -B -DskipTests clean package'
            }
        }
        stage('Unit Test') {
            steps {
                sh 'mvn -Dgroups=unit test'
            }
            post {
                always {
                    junit 'target/surefire-reports/*.xml'
                }
            }
        }
        stage('Integration Test') {
            steps {
                sh 'mvn -Dgroups=integration test'
            }
            post {
                always {
                    junit 'target/surefire-reports/*.xml'
                }
            }
        }
        stage('Deliver') {
            steps {
                sh './jenkins/scripts/deliver.sh'
            }
        }
        stage('Functional Test') {
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
