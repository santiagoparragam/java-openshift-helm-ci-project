FROM nginx:alpine

# Copy configuration and HTML
COPY nginx.conf /etc/nginx/nginx.conf
COPY index.html /usr/share/nginx/html/index.html

# Create temp directories and set full permissions for non-root user
RUN mkdir -p /tmp/client_temp /tmp/proxy_temp /tmp/fastcgi_temp /tmp/uwsgi_temp /tmp/scgi_temp \
    && chmod -R 777 /tmp \
    && chmod -R 777 /var/cache/nginx /var/run /var/log/nginx

USER 1001

EXPOSE 8080

