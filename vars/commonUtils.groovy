def getJobType() {
    String commitMsg = sh(script : "git show -s --format=%B ${env.GIT_COMMIT}", returnStdout: true)

    int beginIdx = commitMsg.indexOf('{')
    int endIdx = commitMsg.indexOf('}')
    if (beginIdx == -1 || endIdx == -1) return "default"

    String tasks = commitMsg.substring(beginIdx + 1, endIdx)
    def buildType = [
            build : tasks.contains("BD"),
            deploy : tasks.contains("DP"),
            test : tasks.contains("TST")
    ]
    return buildType
}