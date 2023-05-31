def getJobType() {
    script {
        String commitMsg = sh(script : "git show -s --format=%B ${env.GIT_COMMIT}", returnStdout: true)
                            .trim()
                            .replace(' ', '-spc-')
        int beginIdx = commitMsg.indexOf('{')
        int endIdx = commitMsg.indexOf('}')
        if (beginIdx == -1 || endIdx == -1) return ""
        return commitMsg.substring(beginIdx + 1, endIdx)
    }
}