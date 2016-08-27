git clone https://github.com/mbhushan/clara-challenge-backend.git

cd clara-challenge-backend/GIFSearchWS/

mvn clean package

java -jar `ls target/gifsearch-service*.jar` &
