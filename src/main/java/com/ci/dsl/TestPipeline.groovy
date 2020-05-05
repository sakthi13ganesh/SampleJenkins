package com.ci.dsl

def task

job('SuiteRunner'){

    parameters {
        activeChoiceParam('Env') {
            description('Select the Env Name from the Dropdown List')
            choiceType('SINGLE_SELECT')
            groovyScript {
                script('return[\'QA\', \'Stage\']')
                fallbackScript('return[\'Env not recognized\']')
            }
        }
        activeChoiceParam('Suite') {
            description('Select the Suite to test from the Dropdown List')
            choiceType('SINGLE_SELECT')
            groovyScript {
                script('return[\'regression\', \'smoke\']')
                fallbackScript('return[\'Suite not recognized\']')
            }
        }
    }

    scm {
        git('https://github.com/sakthi13ganesh/SampleJenkins.git','master')
    }

    steps{
        shell{
            command('echo -----Param Validation-----')
        }
    }

}