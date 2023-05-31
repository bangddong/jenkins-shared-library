@Library("shared-library") _

pipeline {
    agent any
    environment {
        JOB_TYPE = commonUtils.getJobType()
        BUILD_FLAG = JOB_TYPE.buildFlag
        TEST_FLAG = JOB_TYPE.testFlag
        DEPLOY_FLAG = JOB_TYPE.deployFlag
    }
    stages {
        stage('Get JobType') {
            steps {
                echo "Job Type : ${JOB_TYPE}"
            }
        }

        stage('Build') {
            when {
                expression {
                    env.BUILD_FLAG.toBoolean()
                }
            }
            steps {
                echo "Build"
                windriver5600()
            }
        }

        stage('Analysis') {
            when {
                expression {
                    env.TEST_FLAG.toBoolean()
                }
            }
            steps {
                echo "Test"
                testPolyspace()
            }
        }

        stage('Deploy') {
            when {
                expression {
                    env.DEPLOY_FLAG.toBoolean()
                }
            }
            steps {
                echo "Deploy"
                deployToS3()
            }
        }
    }
}

