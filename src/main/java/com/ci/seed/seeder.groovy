package com.ci.seed

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