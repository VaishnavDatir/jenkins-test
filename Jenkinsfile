pipeline {
    agent any  // Defines the agent where the pipeline will run
    
    tools {
        maven 'Maven 3' // This should match the name in Global Tool Configuration
    }

    environment {
        // Define environment variables
        GIT_REPO = 'https://github.com/VaishnavDatir/jenkins-test.git'
        BRANCH = 'main'
    }

    stages {
        stage('Checkout') {
            steps {
                // Checkout the code from GitHub
                echo "Checking out code from repository: ${GIT_REPO}, branch: ${BRANCH}"
                checkout scmGit(branches: [[name: '*/main']], extensions: [], userRemoteConfigs: [[credentialsId: 'b34a515e-f44f-4214-b1ba-f56a47818f14', name: 'origin', url: 'https://github.com/VaishnavDatir/jenkins-test.git']])
            }
        }

        // Build Stage
        stage('Build') {
            steps {
                script {
        try {
            echo "Building the application from dir."
            powershell 'mvn clean package'
        } catch (Exception e) {
            currentBuild.result = 'FAILURE'
            error("Build failed: ${e.message}")
        }
    }
            }
        }

        // Test Stage
        stage('Test') {
            steps {
                script {
                   try {
                        echo "Testing the application from dir."
                        powershell 'mvn test'
                    } catch (Exception e) {
                        currentBuild.result = 'FAILURE'
                        error("Tests failed: ${e.message}")
                    }
                }
            }
        }
        
        // Package Stage
        stage('Package') {
            steps {
                script {
                   try {
                        echo "Packaging the application from dir."
                        powershell 'mvn package'
                    } catch (Exception e) {
                        currentBuild.result = 'FAILURE'
                        error("Packaging failed: ${e.message}")
                    }
                }
            }
        }
    }

    post {
        success {
            echo 'Build and Deployment completed successfully!'
        }

        failure {
            echo 'Something went wrong during the build!'
        }

        unstable {
            echo 'Pipeline completed with some warnings.'
        }

        always {
            echo 'Execution completed...'
        }
    }
}
