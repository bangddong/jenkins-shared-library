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

        stage('Build') {
            when {
                expression {
                    env.JOB_TYPE.build.toBoolean()
                }
            }
            steps {
                echo "Build"
                windriver5600
            }
        }

        stage('Analysis') {
            when {
                expression {
                    env.JOB_TYPE.test.toBoolean()
                }
            }
            steps {
                echo "Test"
                testPolyspace
            }
        }

        stage('Deploy') {
            when {
                expression {
                    env.JOB_TYPE.deploy.toBoolean()
                }
            }
            steps {
                echo "Deploy"
                testVectorCast
            }
        }
    }
}

