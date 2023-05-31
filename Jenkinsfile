@Library("shared-library") _

pipeline {
    agent any
    environment {
        COMMIT_MSG = commomUtil.getCommitMsg()
    }
    stages {
        stage('Test') {
            steps {
                echo COMMIT_MSG
            }
        }
    }
}

