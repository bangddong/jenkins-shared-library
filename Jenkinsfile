@Library("shared-library") _

def jobType = commonUtils.getJobType()

pipeline {
    agent any
    stages {
        stage('Get JobType') {
            steps {
                echo "Job Type : ${jobType}"
            }
        }

        stage('Build') {
            when {
                expression {
                    jobType.buildFlag.toBoolean()
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
                    jobType.testFlag.toBoolean()
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
                    jobType.deployFlag.toBoolean()
                }
            }
            steps {
                echo "Deploy"
                deployToS3()
            }
        }
    }
}

