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
 * dev@sample-sub-module/03-use-freemarker.groovy
 */
import com.google.common.collect.MultimapBuilder
import com.google.common.collect.SetMultimap
import org.slf4j.Logger

/**
 * This sample is demonstrating how to access configuration variables
 */

// Accessing logger. Logger is provided by gmp by default the name of the logger is the filename of script, "test" in this case.
// It is not necessary to add variable "Logger scriptLogger" but it is easier to use it to have autocomplete in IDE

Logger scriptLogger = logger

//Accessing configuration variables
// "gConfig" is a config object "common.variable.msg" - variable name
scriptLogger.info gConfig.common.variable.msg
scriptLogger.info gConfig.global.variable.msg

//Exit code usage. Any numeric exit code except zero (0) leads to failing script chain and none zero exit code goes to system.
// !!!! groovy scripts returns the result of latest calculated value, so it is important to return 0
// !!!! or anything else if you want to eliminate unexpected results
//exit code = 0

//search unique name/file entry for serverX
ConfigObject servers = gConfig.servers
SetMultimap<String, String> hostFilesMap = MultimapBuilder.hashKeys().hashSetValues().build();

//iterate each server from configuration
servers.each {
    scriptLogger.info("server: $it.key file:$it.value.file")
    //put into guava multimap
    hostFilesMap.put(it.value.name,it.value.file)
}

//print unique name/file entry
hostFilesMap.entries().each {
    scriptLogger.info("name: $it.key file:$it.value")
}

return gConfig.varExitCode
