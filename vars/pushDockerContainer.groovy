#!/usr/bin/env groovy


def call(image, tag) {
  REGISTRY = "registry.juvo.mobi"

  docker.withRegistry("https://${REGISTRY}", "juvo-registry-credentials") {
    sh "docker tag ${image}:${tag} ${REGISTRY}/${image}:${tag}"
    sh "docker push ${REGISTRY}/${image}:${tag}"
  }
}
