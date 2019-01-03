# NimGame

REST API for the NimGame (https://en.wikipedia.org/wiki/Nim) based on Spring Boot and Maven.

REST-Routes:

1. /game (POST)
2. /game/{id} (GET)       
3. /game/{id} (PUT)
4. /game/{id} (DELETE)

Route 1 creates a new game. Requestbody is a valid Game-Entity.

Route 2 gets a game by its id. PathVariable is a game-id. RequestBody is null.

Route 3 updates a game through a given game move. PathVariable is a game-id. RequestBody is a valid Move-Entity.

Route 4 deletes a game by its id. PathVariable is a game-id.
