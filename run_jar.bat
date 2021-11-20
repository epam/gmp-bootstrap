REM Path to your base folder. We use current in this example.
set WORK_FOLDER=%CD%
java -Dgmp.home=file:///%WORK_FOLDER%/build/gmp-home/ -Dgmp.log.home=%WORK_FOLDER%/build/gmp-home/log -jar ./build/gmp-home/gmp-bootstrap-0.2-SNAPSHOT.jar  dev@sample-sub-module/03-use-freemarker.groovy dev@sample-sub-module/01-accessing-config.groovy

