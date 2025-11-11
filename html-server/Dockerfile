FROM nginx:alpine
USER root
RUN mkdir -p /var/cache/nginx /var/run /var/log/nginx \
    && chmod -R 777 /var/cache/nginx /var/run /var/log/nginx
USER 1001
COPY index.html /usr/share/nginx/html/index.html
EXPOSE 80
