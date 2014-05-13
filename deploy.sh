#!/bin/bash

VERSION=$(cat pom.xml  |grep version |head -n 1 |perl -pe 's/.*?>(.*?)<.*/\1/g')


# base project compile
mvn clean test
mvn archetype:create-from-project



pushd target/generated-sources/archetype/

  
  mvn package
popd

# catalog upload
aws s3 cp --acl public-read catalogs/swf-application.xml s3://mvn.tottokug.com/catalogs/swf-application.xml

# pom upload
aws s3 cp --acl public-read ./target/generated-sources/archetype/pom.xml s3://mvn.tottokug.com/com/tottokug/swf-application/${VERSION}/swf-application-${VERSION}.pom

#pom checksum upload
shasum ./target/generated-sources/archetype/pom.xml |cut -d' ' -f1 > ./target/generated-sources/archetype/pom.xml.sha1
aws s3 cp --acl public-read ./target/generated-sources/archetype/pom.sha1.xml s3://mvn.tottokug.com/com/tottokug/swf-application/${VERSION}/swf-application-${VERSION}.pom.sha1


# jar upload
aws s3 cp --acl public-read ./target/generated-sources/archetype/target/swf-application-archetype-${VERSION}.jar s3://mvn.tottokug.com/com/tottokug/swf-application/${VERSION}/swf-application-${VERSION}.jar

#jar checksum upload
shasum ./target/generated-sources/archetype/target/swf-application-archetype-${VERSION}.jar |cut -d' ' -f1 > ./target/generated-sources/archetype/target/swf-application-archetype-${VERSION}.jar.sha1

aws s3 cp --acl public-read ./target/generated-sources/archetype/target/swf-application-archetype-${VERSION}.jar.sha s3://mvn.tottokug.com/com/tottokug/swf-application/${VERSION}/swf-application-${VERSION}.jar.sha1
