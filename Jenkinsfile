pipeline {
    agent { label 'agent1' }

    tools {
        git 'Default'
    }

    environment {
        BOT_TOKEN = credentials('telegram-bot-token')
        CHAT_ID = credentials('chat-id')
    }

    stages {
        stage('Prepare Environment') {
            steps {
                script {
                    sh 'chmod +x ./gradlew'
                }
            }
        }
        stage('Checkstyle Main') {
            steps {
                script {
                    sh './gradlew checkstyleMain'
                }
            }
        }
        stage('Checkstyle Test') {
            steps {
                script {
                    sh './gradlew checkstyleTest'
                }
            }
        }
        stage('Compile') {
            steps {
                script {
                    sh './gradlew compileJava'
                }
            }
        }
        stage('Test') {
            steps {
                script {
                    sh './gradlew test'
                }
            }
        }
        stage('JaCoCo Report') {
            steps {
                script {
                    sh './gradlew jacocoTestReport'
                }
            }
        }
        stage('JaCoCo Verification') {
            steps {
                script {
                    sh './gradlew jacocoTestCoverageVerification'
                }
            }
        }
        stage('Docker Build') {
            steps {
                sh 'docker build -t job4j_devops .'
            }
        }
    }

post {
        always {
            script {
                notify {
                    always {
                        telegram {
                            botToken "${BOT_TOKEN}"
                            chatId "${CHAT_ID}"
                            message "Сборка завершена независимо от результата"
                        }
                    }

                    success {
                        telegram {
                            botToken "${BOT_TOKEN}"
                            chatId "${CHAT_ID}"
                            message "Сборка прошла успешно!"
                        }
                    }

                    failure {
                        telegram {
                            botToken "${BOT_TOKEN}"
                            chatId "${CHAT_ID}"
                            message "Сборка провалилась!"
                        }
                    }
                }
            }
        }
    }
}
