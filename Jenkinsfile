@Library("shared-library") _

pipeline {
    agent any
    environment {
        JOB_TYPE = commonUtil.getJobType()
    }
    stages {
        stage('Get JobType') {
            steps {
                echo "JobType : ${JOB_TYPE}"
            }
        }

    }
}

