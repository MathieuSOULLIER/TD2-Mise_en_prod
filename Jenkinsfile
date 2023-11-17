pipeline {
    agent any

    stages {
        stage('Clone') {
            steps {
                checkout scm
            }
        }
        stage('Verify cloning') {
            steps {
                script {
                    if (currentBuild.currentResult == 'SUCCESS') {
                        echo 'Le repository a été cloné avec succès!'
                    } else {
                        error 'Échec de la récupération du repository.'
                    }
                }
            }
        }
          stage('ls Verification path') {
                steps {
                  sh 'ls'
                }
            }
            
            stage('Build Docker Image') {
                steps {
                    script{
                        sh 'ls'
                        sh 'docker build -t td2_mise_en_prod .'
                    }
                }
            }
            stage('Deploy with Docker Compose') {
                steps {
                    sh 'docker compose up -d'
                }
            }
        }
} 