#!/usr/bin/env groovy

def call(def branchName, def commitHash) {
  def now = new Date()
  buildTs = now.format("yy.MM.dd.HH.mm.ss", TimeZone.getTimeZone('UTC'))
  return "rev-" + cleanBranchName(branchName) + "-${buildTs}-${commitHash}"
}


def static cleanBranchName(String branchName) {
  return branchName.replaceAll("/", "-")
}