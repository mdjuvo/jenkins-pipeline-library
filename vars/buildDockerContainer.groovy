#!/usr/bin/env groovy

def call(imageName) {
  sh "sudo docker build -t ${imageName} \\."
}