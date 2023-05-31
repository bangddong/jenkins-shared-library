def getCommitMsg() {
    script {
        return sh(script : "git show -s --format=%B ${env.GIT_COMMIT}",
        returnStdout: true).trim().replace(' ', '-spc-')
    }
}