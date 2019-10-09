#!/usr/bin/env groovy

def call(def branchName, def commitHash) {
  def now = new Date()
  buildTs = now.format("yyyy.MM.dd.HH.mm.ss", TimeZone.getTimeZone('UTC'))
  return "${buildTs}." + cleanBranchName(branchName) + ".${commitHash}"
}


def static cleanBranchName(String branchName) {
  return branchName.replaceAll("/", "-")
}