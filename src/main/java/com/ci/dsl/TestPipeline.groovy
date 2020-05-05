package com.ci.dsl

def task

job('SuiteRunner'){

    parameters {
        activeChoiceParam('Env') {
            description('Select the Env Name from the Dropdown List')
            choiceType('SINGLE_SELECT')
            groovyScript {
                script('[\'QA\', \'Stage\']')
                fallbackScript('[\'Env not recognized\']')
            }
        }
        activeChoiceParam('Suite') {
            description('Select the Suite to test from the Dropdown List')
            choiceType('SINGLE_SELECT')
            groovyScript {
                script('[\'regression\', \'smoke\']')
                fallbackScript('[\'Suite not recognized\']')
            }
        }
    }

    scm {
        git('https://github.com/jenkinsci/job-dsl-plugin.git','master')
    }

    steps{
        shell{
            command('echo -----Param Validation-----')
        }
    }

}