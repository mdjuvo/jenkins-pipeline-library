#!/usr/bin/env groovy


def call(image, tag) {
  REGISTRY = "730036231311.dkr.ecr.us-west-2.amazonaws.com"
  REGION = "us-west-2"

  // Automatically create new repos
  withAWS(region: REGION, credentials: 'md-aws-credentials') {
    sh "aws --region ${REGION} ecr describe-repositories --repository-names ${image} || aws --region ${REGION} ecr create-repository --repository-name ${image}"
  }

  docker.withRegistry("https://${REGISTRY}", "ecr:${REGION}:md-aws-credentials") {
    sh "docker tag ${image}:${tag} ${REGISTRY}/${image}:${tag}"
    sh "docker push ${REGISTRY}/${image}:${tag}"
  }
}