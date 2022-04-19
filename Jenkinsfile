pipeline {
    agent any

    tools {
        maven "MAVEN"
    }

    environment {
        SUITE = "src/test/resources/${params.Suite}.xml"
    }

    stages {
        stage('Build') {
            steps {
//                 git branch: 'develop', url: 'https://github.com/vitaliiyz/Automation-VitalyZaitsev-.git'
                bat 'mvn clean'
            }
        }
        stage('Test run') {
            steps {
                echo "--------------------------------------Started ${env.SUITE}--------------------------------------"
                bat 'mvn clean install test -Dsuite=${env.SUITE}'
            }
        }
        stage('reports') {
            steps {
                script {
                    allure([
                    includeProperties: false,
                    jdk: '',
                    properties: [],
                    reportBuildPolicy: 'ALWAYS',
                    results: [[path: 'target/allure-results']]
                    ])
                }
            }
        }
    }
}
