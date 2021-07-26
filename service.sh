#!/bin/bash

function install() {
  helm repo add prometheus-community https://prometheus-community.github.io/helm-charts
  helm repo add bitnami https://charts.bitnami.com/bitnami

  helm install postgres bitnami/postgresql -f ./postgresql.yml
  helm install kafka bitnami/kafka -f ./kafka.yml
  helm install market ./market-chart
  return
}

function destroy() {
  helm uninstall market
  helm uninstall kafka
  helm uninstall postgres
  return
}

case "$1" in
"install")
  install
  ;;
"destroy")
  destroy
  ;;
esac