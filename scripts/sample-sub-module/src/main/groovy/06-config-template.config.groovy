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

//It is possible to create config template and use substitution from higher config layer
//This is service section

/**
 * cmd line argument to start:
 * xxx@sample-sub-module/06-use-config-template.config.groovy
 */


varExitCode = cfgExitCode
demo {
    var1 = cfgVar_1
    var2 = cfgVar_2
    var3 = "var3=${cfgVar_1} and ${cfgVar_2}"
    const1 = 'some constant value'
}