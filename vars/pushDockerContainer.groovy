#!/usr/bin/env groovy

final REGISTRY = "730036231311.dkr.ecr.us-west-2.amazonaws.com"

def call(image, tag) {
  docker.withRegistry(REGISTRY, 'ecr:us-west-2:md-aws-credentials') {
    sh "sudo docker tag ${image}:${tag} ${REGISTRY}/${image}:${tag}"
    sh "sudo docker push ${REGISTRY}/${image}:${tag}"
  }
}