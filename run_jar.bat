call gradle clean build -Pweb=false
#Path to your base folder
set WORK_FOLDER=
java -Dgmp.home=file:///%WORK_FOLDER%/build/gmp-home/ -Dgmp.log.home=%WORK_FOLDER%/build/gmp-home/log -jar ./build/gmp-home/gmp-bootstrap-0.2-SNAPSHOT.jar  dev@sample-sub-module/03-use-freemarker.groovy dev@sample-sub-module/01-accessing-config.groovy

