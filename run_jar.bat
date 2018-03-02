call gradle clean build -Pweb=false
java -Dgmp.home=./build/gmp-home  -jar ./build/gmp-home/gmp-bootstrap-0.1-SNAPSHOT.jar  dev@sample-sub-module/03-use-freemarker.groovy dev@sample-sub-module/01-accessing-config.groovy

