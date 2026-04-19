pipeline{
    agent any{
        stages{
            stage('maven'){
                steps{
                     sh 'mvn clean package -DskipTests' 
                }
            }
            stage('docker'){
                steps{
                     sh 'docker-compose up -d --build' 
                }
            }
            stage('check'){
                steps{
                     sh 'echo "build successfully"' 
                }
            }
        }
    }
}