def getJobType() {
    script {
        String commitMsg = sh(script : "git show -s --format=%B ${env.GIT_COMMIT}", returnStdout: true)

        int beginIdx = commitMsg.indexOf('{')
        int endIdx = commitMsg.indexOf('}')
        if (beginIdx == -1 || endIdx == -1) return "default"
        return commitMsg.substring(beginIdx + 1, endIdx)
    }
}