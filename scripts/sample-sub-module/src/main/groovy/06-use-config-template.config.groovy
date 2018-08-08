/*
 *  /***************************************************************************
 * Copyright (c) 2017, EPAM SYSTEMS INC
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *     http://www.apache.org/licenses/LICENSE-2.0
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 *  ***************************************************************************
 */

//defaults
cfgExitCode = 0
cfgVar_1 = 'var1'
cfgVar_2 = 'var2'

EXECUTOR {
    includeConfig = '06-config-template.config.groovy'
    includeYaml = '06-sample.yaml'
}

//env specific
environments {
    env1 {
        env = 'test1'
        cfgVar_1 = 'env1-var1'
    }

    env2 {
        env = 'test2'
        EXECUTOR.includeConfig = ''
        cfgVar_1 = 'env2-var2'
    }

}


