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

/**
 * cmd line argument to start:
 * dev@sample-sub-module/06-use-config-template.groovy
 */

import com.epam.dep.esp.common.json.JsonMapper
import org.slf4j.Logger


Logger scriptLogger = logger

//print all binding
this.binding.variables.each {
    scriptLogger.info "${it.key}==${it.value}"
}

//print variables we need
scriptLogger.info JsonMapper.instance.map(true,gConfig)

return gConfig.varExitCode