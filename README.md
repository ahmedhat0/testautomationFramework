# testautomationFramework
Using POM 

#### in Sequence To Configure Healenium

```
cd db
```
```
curl  https://raw.githubusercontent.com/healenium/healenium-client/master/example/docker-compose.yaml  -o docker-compose.yaml
```
```
cd db/sql
```
```
curl https://raw.githubusercontent.com/healenium/healenium-client/master/example/init.sql -o init.sql
```
in src/test/resources -- >>  *healenium.properties*
```
recovery-tries = 1
score-cap = 0.5
heal-enabled = true
serverHost = localhost
serverPort = 7878
imitatePort = 8000
```
```
docker-compose up -d 
docker ps
```


