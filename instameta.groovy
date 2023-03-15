pipeline {
    agent any

    stages {
        stage("Using curl example") {
            steps {
                script {
                        response1 = sh(script: "curl --request PUT "http://169.254.169.254/latest/api/token" --header "X-aws-ec2-metadata-token-ttl-seconds: 21600", returnStdout: true).trim()
                        echo response1
                        response2 = sh(script: "curl --write-out "\n" --request GET "http://169.254.169.254/latest/meta-data/ami-id" --header "X-aws-ec2-metadata-token: $TOKEN", returnStdout: true).trim()
                        echo response2
                        response3 = sh(script: "curl --write-out "\n" --request GET "http://169.254.169.254/latest/" --header "X-aws-ec2-metadata-token: $TOKEN", returnStdout: true).trim()
                        echo response3
                        sresponse4 = sh(script: "url --write-out "\n" --request GET "http://169.254.169.254/latest/user-data" --header "X-aws-ec2-metadata-token: $TOKEN", returnStdout: true).trim()
                        echo response4
                        response5 = sh(script: "curl --write-out "\n" --request GET "http://169.254.169.254/latest/dynamic/instance-identity/document" --header "X-aws-ec2-metadata-token: $TOKEN" -o output.json, returnStdout: true).trim()
                        echo response5

                    
                }
            }
        }
    }
}
