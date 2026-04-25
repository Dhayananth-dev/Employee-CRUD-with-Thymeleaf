pipeline{
    agent any
    tools{
        maven 'maven'
    }
    stages{
        stage("maven clean pkg"){
            steps{
                sh 'mvn clean package -DskipTests'
            }
        }
        stage("Docker compose"){
            steps{
                sh 'sudo docker-compose up -d --build'
            }
        }
    }

}