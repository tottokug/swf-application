#!/bin/bash
if [ $# -ne 1 ] ;
then
  echo "USE ./add-version.sh VERSION"
  exit
fi
CURRENT_BRANCH=$(git branch --contains |cut -d' ' -f2)

if [ ${CURRENT_BRANCH} != "master" ];
then
  echo "./add-version is run only master branch"
  exit
fi

VERSION=$1
echo "VERSION=${VERSION}"
git checkout -b ${VERSION}


# catalog 
ARCHETYPE=`cat <<__EOT__
    <archetype>
      <groupId>com.tottokug</groupId>
      <artifactId>swf-application-archetype</artifactId>
      <version>${VERSION}</version>
      <repository>http://mvn.tottokug.com/</repository>
    </archetype>
__EOT__`
echo $ARCHETYPE
cat pom.xml.skelton |perl -pe "s/##VERSION##/${VERSION}/g" > pom.xml.tmp
sed -e "/\s*<archetypes/a ${ARCHETYPE}" catalogs/swf-application.xml


