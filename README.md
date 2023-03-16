# Challenge2

We need to write code that will query the meta data of an instance within AWS or Azure or GCP and provide a json formatted output. 

Install below required softwares in VM inorder to exeute the python code:
sudo pip3 install pipenv
pipenv install
sudo pip3 install requests

RUN Command:
python3 instmetdata.py

Using below CURL commands also we can get the metadtaoutput in JSON format for the instance :

Create Token
TOKEN=`curl --request PUT "http://169.254.169.254/latest/api/token" --header "X-aws-ec2-metadata-token-ttl-seconds: 21600"` 

pass the token to the GET request. Adding /latest/meta-data/ to the end of the URI will view all categories 
curl --write-out "\n" --request GET "http://169.254.169.254/latest/meta-data/ami-id" --header "X-aws-ec2-metadata-token: $TOKEN"

Instance metadata categories
curl --write-out "\n" --request GET "http://169.254.169.254/latest/" --header "X-aws-ec2-metadata-token: $TOKEN"

Add the word user-data see the data added to user-data when the instance was built
curl --write-out "\n" --request GET "http://169.254.169.254/latest/user-data" --header "X-aws-ec2-metadata-token: $TOKEN"

Dynamic data contains information about the instance identity documents,types of information included in dynamic data are account ID, region, and certificates
curl --write-out "\n" --request GET "http://169.254.169.254/latest/dynamic/instance-identity/document" --header "X-aws-ec2-metadata-token: $TOKEN"

Store output in json format :
curl --write-out "\n" --request GET "http://169.254.169.254/latest/dynamic/instance-identity/document" --header "X-aws-ec2-metadata-token: $TOKEN"-H "Accept: application/json" -o metadata.json
