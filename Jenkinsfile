@Library("shared-library") _

pipeline {
    agent any
    stages {
        stage ('Initialize') {
            steps {
                script {
                    def jobType = commonUtils.getJobType()
                    env.buildFlag = jobType.buildFlag
                    env.testFlag = jobType.testFlag
                    env.deployFlag = jobType.deployFlag
                }
            }
        }
        stage('Check Environment Value2') {
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
        stage('Encrypt') {
            when {
                expression {
                    env.buildFlag.toBoolean()
                }
            }ee
            steps {
                echo "Build"dd
                windriver5600()
            }aaa
        }

        stage('Analysis') {
            when {
                expression {
                    env.testFlag.toBoolean()
                }
            }
            steps {
                echo "Analysis"
                testPolySpace()
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

