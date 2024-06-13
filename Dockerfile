FROM quay.io/keycloak/keycloak:21.0.0

COPY ./config/ /opt/keycloak/data/import/
COPY import-client-scope.sh /opt/keycloak/import-client-scope.sh

ENTRYPOINT [ "sh", "-c", "/opt/keycloak/bin/kc.sh start-dev --import-realm && sh /opt/keycloak/import-client-scope.sh" ]
