#!/usr/bin/env groovy

def call(imageName, tag) {
  sh "docker build -t ${imageName}:${tag} \\."
}