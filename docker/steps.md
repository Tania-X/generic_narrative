## 关于docker-compose

### 命令
```shell
# 在 “Command” 输入框中，输入你需要执行的 Docker Compose 命令。例如：
docker-compose -f docker-compose.yml up --build -d
# 如果你需要在构建后停止和移除容器，可以添加另一个构建步骤：
docker-compose -f docker-compose.yml down
```

### Docker Compose 文件
```yaml
version: '3'
services:
  web:
    image: nginx
    ports:
      - "80:80"
  db:
    image: mysql
    environment:
      MYSQL_ROOT_PASSWORD: example

```