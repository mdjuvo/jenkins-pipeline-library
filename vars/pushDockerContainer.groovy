#!/usr/bin/env groovy

final REGISTRY = "730036231311.dkr.ecr.us-west-2.amazonaws.com"

def call(image, tag) {
  docker.withRegistry("https://${REGISTRY}", 'ecr:us-west-2:md-aws-credentials') {
    sh "aws ecr describe-repositories --repository-names ${image} || aws ecr create-repository --repository-name ${image}"
    sh "docker tag ${image}:${tag} ${REGISTRY}/${image}:${tag}"
    sh "docker push ${REGISTRY}/${image}:${tag}"
  }
}