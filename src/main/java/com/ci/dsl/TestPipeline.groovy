package com.ci.dsl

def task

pipelineJob('SuiteRunner'){
    
    parameters {
        activeChoiceParam('Env') {
            description('Select the Env Name from the Dropdown List')
            filterable()
            choiceType('SINGLE_SELECT')
            groovyScript {
                script('["QA", "Stage"]')
                fallbackScript('["Env not recognized"]')
            }
        }
        activeChoiceParam('Suite') {
            description('Select the Suite to test from the Dropdown List')
            filterable()
            choiceType('SINGLE_SELECT')
            groovyScript {
                script('["regression", "smoke"]')
                fallbackScript('["Suite not recognized"]')
            }
        }
    }

    definition {
        cpsScm {
            scm {
                git{
                    branch('master')
                    name('origin')
                    url('https://github.com/jenkinsci/job-dsl-plugin.git')
                }
            }
        }
    }

    stages {
        stage ('Param Validation') {
            steps {
                script{
                    echo "Env Choice   : ${Env}"
                    echo "Suite Choice : ${Suite}"
                    if (Env.equals("Env not recognized") || Suite.equals("Suite not recognized")) {
                        echo "Validation Failure"
                        currentBuild.result = 'ABORTED'
                        return
                    }
                    echo "Param Validation Successful"
                }
            }
        }

        stage ('Running Test suite') {
            steps {
                script{
                    task = Env.equals("QA")?"testOnQa":"testOnStage"
                    sh "./gradlew clean ${task} -PsuiteNature=${Suite}"
                }
            }
        }

        stage ('Posting Results') {
            steps {
                junit "build/test-results/${task}/*.xml"
            }
        }
    }
}