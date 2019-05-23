#!/usr/bin/env groovy


def call(image, tag) {
  REGISTRY = "730036231311.dkr.ecr.us-west-2.amazonaws.com"
  docker.withRegistry("https://${REGISTRY}", 'ecr:us-west-2:md-aws-credentials') {
    sh "aws --region us-west-2 ecr describe-repositories --repository-names ${image} || aws --region us-west-2 ecr create-repository --repository-name ${image}"
    sh "docker tag ${image}:${tag} ${REGISTRY}/${image}:${tag}"
    sh "docker push ${REGISTRY}/${image}:${tag}"
  }
}