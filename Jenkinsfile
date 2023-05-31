@Library("shared-library") _

pipeline {
    agent any
    environment {
        JOB_TYPE = commonUtils.getJobType()
    }
    stages {
        stage('Get JobType') {
            steps {
                echo "Job Type : ${JOB_TYPE}"
            }
        }

    }
}

