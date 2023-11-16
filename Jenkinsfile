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
            stage('Build et Push des Docker Images') {
                steps {
                    script {
                        docker.build('td2-mise-en-prod')
                    }
                }
            }

            stage('Deploy with Docker Compose') {
                steps {
                    script {
                        // Déploiement avec Docker Compose
                        sh 'docker-compose up'
                    }
                }
            }
        }
} 