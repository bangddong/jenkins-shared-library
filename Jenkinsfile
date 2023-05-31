@Library("shared-library") _

pipeline {
    agent any
    stages {
        stage ('Initialize') {
            script {
                def jobType = commonUtils.getJobType()
                env.buildFlag = jobType.buildFlag
                env.testFlag = jobType.testFlag
                env.deployFlag = jobType.deployFlag
            }
        }
        stage('Check Environment Value') {
            steps {
                echo "Build Flag : ${buildFlag}"
                echo "Test Flag : ${testFlag}"
                echo "Deploy Flag : ${deployFlag}"
            }
        }

        stage('Build') {
            when {
                expression {
                    env.buildFlag.toBoolean()
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
                    env.testFlag.toBoolean()
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
                    env.deployFlag.toBoolean()
                }
            }
            steps {
                echo "Deploy"
                deployToS3()
            }
        }
    }
}

