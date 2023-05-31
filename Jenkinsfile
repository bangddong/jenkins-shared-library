@Library("shared-library") _

pipeline {
    agent any
    environment {
        COMMIT_MSG = commonUtil.getCommitMsg()
    }
    stages {
        stage('Test Library') {
            steps {
                echo COMMIT_MSG
                echo "echo"
            }
        }
    }
}

