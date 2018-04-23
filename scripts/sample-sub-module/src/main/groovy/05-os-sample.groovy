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

import com.epam.dep.esp.common.OS

List<String> result = new ArrayList<>()
Map<String, String> envVar = new HashMap<>()
envVar.put("testVar", "testOs.var");
OS os = OS.os
int exitCode

switch (os) {
    case OS.win:
        exitCode = os.execCommandLine(['cmd', '/c', 'echo %testVar%'], result, '.', 10, envVar)
        break;

    case OS.linux:
        exitCode = os.execCommandLine(['/bin/bash', '-c', 'echo $testVar'], result, '.', 10, envVar)
        break;
}

logger.info "\nexit code: $exitCode \nresult:\n$result"
