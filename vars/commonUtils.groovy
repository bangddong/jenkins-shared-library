def getJobType() {
    String commitMsg = sh(script : "git show -s --format=%B ${env.GIT_COMMIT}", returnStdout: true)
    def buildType = [
            buildFlag : false,
            deployFlag : false,
            testFlag : false
    ]

    int beginIdx = commitMsg.indexOf('{')
    int endIdx = commitMsg.indexOf('}')
    if (beginIdx == -1 || endIdx == -1) return buildType

    String tasks = commitMsg.substring(beginIdx + 1, endIdx)
    buildType.buildFlag = tasks.contains("BD")
    buildType.deployFlag = tasks.contains("DP")
    buildType.testFlag = tasks.contains("TST")

    return buildType
}