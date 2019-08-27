This is a review management server created in Java Spring Boot
(All routes proceeded by /api/v1)
## Server User Routes

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
| gigs destroy | `DELETE`       | `/cars/1`           | `/gigs/:gig_id` |

## Server Review Routes

| Route Name      | Request Method | Example Request URL    | Route                  |
| ------------    | -------------- | -------------------    | ---------------        |
| all reviews     | `GET`          | `/reviews`             | `/reviews`             |
| users/jobs rev  |   `GET`        | `/reviews/1/11`        |`/reviews/userID/:jobID`|
| users  reviews  |   `GET`        | `/reviews/user/11`     |`/reviews/user/:userID` |
| jobs reviews    |   `GET`        | `/reviews/job/11`      | `/reviews/job/:jobID`  |
| reviews create  | `POST`         | `/reviews`             | `/reviews`             |
| reviews update  | `PATCH`        | `/reviews/1`           | `/reviews/:reviewsID`  |
| reviews destroy | `DELETE`       | `/reviews/1`           | `/reviews/:reviewsID`  |
| all reviewRate  | ` GET  `       | `/rating/1`            | `/rating/:jobID`       | 
