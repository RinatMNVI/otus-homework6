
function build() {
  docker build --tag rinatm/billingservice:v1 ./billingservice
  docker build --tag rinatm/notification:v1 ./notification
  docker build --tag rinatm/orderservice:v1 ./orderservice
  docker build --tag rinatm/userservice:v6 ./userservice
}

function delete() {
  docker rmi rinatm/billingservice:v1
  docker rmi rinatm/notification:v1
  docker rmi rinatm/orderservice:v1
  docker rmi rinatm/userservice:v6
}

case "$1" in
"build")
  build
  ;;
"delete")
  delete
  ;;
esac