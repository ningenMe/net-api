# net-api
[![ci-test](https://github.com/ningenMe/net-api/actions/workflows/ci-test.yml/badge.svg)](https://github.com/ningenMe/net-api/actions/workflows/ci-test.yml)
[![cd-resource-push](https://github.com/ningenMe/net-api/actions/workflows/cd-resource-push.yml/badge.svg)](https://github.com/ningenMe/net-api/actions/workflows/cd-resource-push.yml)
[![cd-code-deploy](https://github.com/ningenMe/net-api/actions/workflows/cd-code-deploy.yml/badge.svg)](https://github.com/ningenMe/net-api/actions/workflows/cd-code-deploy.yml)

趣味開発のバックエンド全般  

## domain
[api.ningenme.net](https://api.ningenme.net)

## document
|            |url                             |  
|----------- |------------------------------- |  
|swagger     |https://static.ningenme.net/net-api/swagger |
|javadoc     |https://static.ningenme.net/net-api/javadoc |  
|test        |https://static.ningenme.net/net-api/test |  
|jacoco      |https://static.ningenme.net/net-api/jacoco |  

## architecture
|            |      architecuture             |  
|----------- |------------------------------- |  
|routing     |cloudfront + auto load balancer |
|hosting     | ecs                            |  
|ci/cd       | github actions, aws codedeploy |  
|application | Spring Boot                    |  

## history

|version  |repository                                                       |tech stack|  
|------   |---------                                                        |----------- |  
|v3 (this)|[net-api](https://github.com/ningenMe/net-api)                   |spring + ecs|  
|v2       |[ningenme-net-api](https://github.com/ningenMe/ningenme-net-api) |spring + ec2|  
|v1       |[ningenMe.net.API](https://github.com/ningenMe/ningenMe.net.API) |laravel + ec2|  