#!/usr/bin/env groovy

def call(imageName, tag) {
  sh "sudo docker build -t ${imageName}:${tag} \\."
}