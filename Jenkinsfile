@Library("shared-library") _

pipeline {
    agent any
    environment {
        COMMIT_MSG = commonUtil.getCommitMsg()
    }
    stages {
        stage('Test') {
            steps {
                echo COMMIT_MSG
            }
        }
    }
}

