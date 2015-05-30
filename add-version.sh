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
export AWS_DEFAULT_REGION=ap-northeast-1

# catalog 
ARCHETYPE=`cat <<- __EOT__
    <archetype>
      <groupId>com.tottokug</groupId>
      <artifactId>swf-application-archetype</artifactId>
      <version>${VERSION}</version>
      <repository>http://mvn.tottokug.com/</repository>
    </archetype>
__EOT__`
echo $ARCHETYPE
cat pom.xml.skelton |perl -pe "s/##VERSION##/${VERSION}/g" > pom.xml.tmp
ARCHETYPES_ROW=$(cat catalogs/swf-application.xml |grep -n "<archetypes" |head -n 1 |cut -d':' -f1)
ALL_ROW=$(wc -l catalogs/swf-application.xml  |perl -pe "s/\s+(\d+)\s.*/\1/")
cat catalogs/swf-application.xml |head -n ${ARCHETYPES_ROW} > catalogs/tmp.xml
echo -e "${ARCHETYPE}" >> catalogs/tmp.xml
cat catalogs/swf-application.xml |tail -n $(expr  ${ALL_ROW} - ${ARCHETYPES_ROW}) >> catalogs/tmp.xml

cat catalogs/tmp.xml > catalogs/swf-application.xml
cat pom.xml.tmp > pom.xml
rm pom.xml.tmp catalogs/tmp.xml

./deploy.sh

git add . 
git commit -m "${VERSION} added"
git checkout master
git merge ${VERSION}
git push origin master


