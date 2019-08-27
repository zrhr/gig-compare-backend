This is a review management server created in Java Spring Boot
## Server User Routes
(All routes proceeded by /api/vl)
| Route Name   | Request Method | Example Request URL | Route           |
| ------------ | -------------- | ------------------- | --------------- |
| all users    | `GET`          | `/users`            | `/users`        |
| users create | `POST`         | `/users`            | `/users`        |
| users login  | `POST`         | `/users/1`          | `/users/:userId`|
| users destroy| `DELETE`       | `/users/1`          | `/users/:userId`|

## Server Gig Routes

| Route Name   | Request Method | Example Request URL | Route           |
| ------------ | -------------- | ------------------- | --------------- |
| all gigs     | `GET`          | `/gigs`             | `/gigs`         |
| one  gig     | `GET`          | `/gigs/1`           | `/gigs/:gig_id` |
| gigs create  | `POST`         | `/gigs`             | `/gigs`         |
| gigs update  | `PATCH`        | `/gigs/1`           | `/gigs/:gig_id` |
| gigs destroy | `DELETE`       | `/cars/1`           | `/cars/:gig_id` |

## Server Review Routes

| Route Name      | Request Method | Example Request URL    | Route               |
| ------------    | -------------- | -------------------    | ---------------     |
| all reviews     | `GET`          | `/reviews`             | `/reviews`          |
| reviews create  | `POST`         | `/reviews`             | `/reviews`          |
| reviews update  | `PATCH`        | `/reviews/1`           | `/reviews/:reviews` |
| reviews destroy | `DELETE`       | `/reviews/1`           | `/reviews/:reviews` |
