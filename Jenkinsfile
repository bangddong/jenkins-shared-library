@Library("shared-library") _

pipeline {
    agent any
    environment {
        JOB_TYPE = commonUtils.getJobType()
    }
    stages {
        stage('Get JobType') {
            steps {
                echo "JobType : ${JOB_TYPE}"
            }
        }

    }
}

