FROM nginx:alpine

# Remove the default config and replace with our version
COPY nginx.conf /etc/nginx/nginx.conf
COPY index.html /usr/share/nginx/html/index.html

# Use non-root user compatible with OpenShift
USER 1001

EXPOSE 8080

