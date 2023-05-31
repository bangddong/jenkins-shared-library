def getJobType() {
    String commitMsg = sh(script : "git show -s --format=%B ${env.GIT_COMMIT}", returnStdout: true)
    def buildType = [
            build : "",
            deploy : "",
            test : ""
    ]

    int beginIdx = commitMsg.indexOf('{')
    int endIdx = commitMsg.indexOf('}')
    if (beginIdx == -1 || endIdx == -1) return buildType

    String tasks = commitMsg.substring(beginIdx + 1, endIdx)
    buildType.build = tasks.contains("BD")
    buildType.deploy = tasks.contains("DP")
    buildType.test = tasks.contains("TST")

    return buildType
}