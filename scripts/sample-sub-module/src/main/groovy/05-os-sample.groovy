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
