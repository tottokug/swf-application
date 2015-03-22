#!/bin/bash
PROFILE=private

VERSION=$(cat pom.xml  |grep version |head -n 1 |perl -pe 's/.*?>(.*?)<.*/\1/g')


# base project compile
mvn clean test
mvn archetype:create-from-project

cp src/main/resources/META-INF/maven/archetype-metadata.xml target/generated-sources/archetype/src/main/resources/META-INF/maven/archetype-metadata.xml

pushd target/generated-sources/archetype/
  pushd src/main/resources/archetype-resources
    rm -rf .settings catalogs deploy.sh pom.skelton
  popd
  mvn clean
  mvn package
popd

# catalog upload
#aws --profile ${PROFILE} s3 cp --acl public-read catalogs/swf-application-1.7.xml s3://mvn.tottokug.com/catalogs/
aws --profile ${PROFILE} s3 cp --acl public-read catalogs/swf-application-1.8.xml s3://mvn.tottokug.com/catalogs/
aws --profile ${PROFILE} s3 cp --acl public-read catalogs/swf-application.xml s3://mvn.tottokug.com/catalogs/

# pom upload
aws --profile ${PROFILE} s3 cp --acl public-read ./target/generated-sources/archetype/pom.xml s3://mvn.tottokug.com/com/tottokug/swf-application-archetype/${VERSION}/swf-application-archetype-${VERSION}.pom

#pom checksum upload
shasum ./target/generated-sources/archetype/pom.xml |cut -d' ' -f1 > ./target/generated-sources/archetype/pom.xml.sha1
aws --profile ${PROFILE} s3 cp --acl public-read ./target/generated-sources/archetype/pom.xml.sha1 s3://mvn.tottokug.com/com/tottokug/swf-application-archetype/${VERSION}/swf-application-archetype-${VERSION}.pom.sha1

# jar upload
aws --profile ${PROFILE} s3 cp --acl public-read ./target/generated-sources/archetype/target/swf-application-archetype-${VERSION}.jar s3://mvn.tottokug.com/com/tottokug/swf-application-archetype/${VERSION}/swf-application-archetype-${VERSION}.jar

#jar checksum upload
shasum ./target/generated-sources/archetype/target/swf-application-archetype-${VERSION}.jar |cut -d' ' -f1 > ./target/generated-sources/archetype/target/swf-application-archetype-${VERSION}.jar.sha1

aws --profile ${PROFILE} s3 cp --acl public-read ./target/generated-sources/archetype/target/swf-application-archetype-${VERSION}.jar.sha1 s3://mvn.tottokug.com/com/tottokug/swf-application-archetype/${VERSION}/swf-application-archetype-${VERSION}.jar.sha1
