# update packages
sudo apt-get update

# Install git
sudo apt-get install git-core

# Install jdk
sudo apt-get install openjdk-8-jdk

#install
sudo apt-get install maven

JAVA_HOME="/usr/lib/jvm/java-1.8.0-openjdk-amd64/" >> /etc/environment
source /etc/environment

"securerandom.source=file:/dev/./urandom" >> /usr/lib/jvm/java-1.8.0-openjdk-amd64/jre/lib/security/java.security

echo "Checking the JAVA_HOME path"
echo $JAVA_HOME


sudo groupadd tomcat

sudo useradd -s /bin/false -g tomcat -d /opt/tomcat tomcat

cd /tmp

curl -O http://www-eu.apache.org/dist/tomcat/tomcat-8/v8.5.4/bin/apache-tomcat-8.5.4.tar.gz

# install Tomcat to the /opt/tomcat directory.
sudo mkdir /opt/tomcat

# Create the directory, then extract the archive to it 
sudo tar xzvf apache-tomcat-8*tar.gz -C /opt/tomcat --strip-components=1

cd /opt/tomcat

sudo chgrp -R tomcat conf
sudo chmod g+rwx conf
sudo chmod g+r conf/*
sudo chown -R tomcat webapps/ work/ temp/ logs/

sudo ufw allow 8080

cd ~/

