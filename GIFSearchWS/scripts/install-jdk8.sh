#!/bin/bash

#USAGE :/bin/bash install-jdk8.sh
#JDK-Functions
function installJDK_8
{
        echo "Install version jdk-8u101-linux-x64"

        wget  wget --no-cookies --no-check-certificate --header "Cookie: gpw_e24=http%3A%2F%2Fwww.oracle.com%2F; oraclelicense=accept-securebackup-cookie" "http://download.oracle.com/otn-pub/java/jdk/8u101-b13/jdk-8u101-linux-x64.tar.gz" -O /opt/jdk-8u101-linux-x64.rpm
        rpm -ivh /root/download/jdk-8u101-linux-x64.rpm

        export JAVA_HOME=/usr/java/jdk1.8.0_25/
        export JAVA_HOME=/usr/lib/jvm/java-1.8.0-openjdk-amd64/
        export PATH=$JAVA_HOME/bin:$PATH
        export PATH=$PATH:$JAVA_HOME/bin

        echo 'export JAVA_HOME=/usr/lib/jvm/java-1.8.0-openjdk-amd64/' >> ~/.bash_profile
        echo 'export PATH=$JAVA_HOME/bin:$PATH' >> ~/.bash_profile
        echo 'export PATH=$PATH:$JAVA_HOME"/bin' >> ~/.bash_profile
}
if [ -f "/usr/java/jdk" ]; then
                echo "JAVA Already Installed in Your System"
else
                installJDK_8
fi
echo "Checking the JAVA_HOME path"
echo $JAVA_HOME
#######################