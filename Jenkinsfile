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
    }

    post {
        always {
            script {

                notify {
                    success {
                        telegram {
                            botToken "${BOT_TOKEN}"
                            chatId "${CHAT_ID}"
                            message """
                                **Сборка завершена успешно!**
                                * Название: ${env.JOB_NAME}
                                * Номер: ${env.BUILD_NUMBER}
                                * Статус: Успешно
                                * Ссылка: ${env.BUILD_URL}
                                """
                        }
                    }
                }
                //println 'post...'
                //
                //def buildInfo = "Build number: ${currentBuild.number}\n" +
                //                "Build status: ${currentBuild.currentResult}\n" +
                //                "Started at: ${new Date(currentBuild.startTimeInMillis)}\n" +
                //                "Duration so far: ${currentBuild.durationString}"
                //telegramSend(message: buildInfo)
            }
        }
    }
}
