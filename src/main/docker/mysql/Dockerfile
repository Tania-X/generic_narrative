FROM mysql:latest

ENV MYSQL_ROOT_PASSWORD=123456
ENV MYSQL_DATABASE=siyuan
ENV MYSQL_USER=max
ENV MYSQL_PASSWORD=max!123

COPY init.sql /docker-entrypoint-initdb.d/

# Add healthcheck
HEALTHCHECK --interval=1m --timeout=10s --start-period=30s --retries=3 \
  CMD mysqladmin ping -h 127.0.0.1 -u root -p123456 || exit 1

# Optional: specify default command to start MySQL (not really necessary as official image already does it)
CMD ["mysqld"]
