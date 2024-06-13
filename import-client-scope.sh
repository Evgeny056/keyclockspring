#!/bin/sh

# Установка прав доступа для выполнения скрипта
chmod +x /opt/keycloak/import-client-scope.sh

# Ожидаем запуска Keycloak
sleep 20

/opt/keycloak/bin/kcadm.sh config credentials --server http://keycloak:8080 --realm master --user $KEYCLOAK_ADMIN --password $KEYCLOAK_ADMIN_PASSWORD
