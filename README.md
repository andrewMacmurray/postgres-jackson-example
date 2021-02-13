# Database to domain example

## What?

Example application using Postgres JSON aggregates and Jackson to deserialize domain models (example for this blog post <post link>)

The application is a spring boot rest api with endpoints that can read `Questionnaires` from postgres

```
GET /questionnaires
GET /questionnaires/{id}
```

Given this schema:

<img width="274" alt="Screenshot 2021-02-13 at 14 06 22" src="https://user-images.githubusercontent.com/14013616/107857245-3b241d80-6e25-11eb-9791-a25c96b806cb.png">

We can use Postgres' `json_agg` and `json_build_object` functions to build JSON objects on read that can be easily deserialized by Jackson

## Run the application

Make sure you have postgres running locally and create a database `questionnaire_example`

```
> pqsl
> CREATE DATABASE questionnaire_example;
```

Run the spring boot server (migrations will happen automatically):

```
> ./gradlew bootRun
```


Then visit `http://localhost:8080/questionnaires` to see the questionnaires responses

<img width="528" alt="Screenshot 2021-02-13 at 18 08 30" src="https://user-images.githubusercontent.com/14013616/107857488-7e32c080-6e26-11eb-9b6a-4c163215ebbe.png">
