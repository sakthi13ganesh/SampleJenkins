package com.ci.seed

import org.jenkinsci.plugins.scriptsecurity.scripts.ScriptApproval

ScriptApproval scriptApproval = ScriptApproval.get()
scriptApproval.pendingScripts.each {
    scriptApproval.approveScript(it.hash)
}

job("Seeder (Master Job)") {

    scm {
        git {
            branch("master")
            remote {
                name("origin")
                url("https://github.com/sakthi13ganesh/SampleJenkins")
            }
        }
    }

    steps {
        dsl {
            external("JenkinsFile")
        }
    }
}