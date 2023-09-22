# NTU SCTP in Software Engineering
 
# Project 2 - Backend Fundamentals With Java Spring Boot and Databases
 
# Soccer Stats API
Soccer Stats API is your go-to database, providing comprehensive information on the statistics of each soccer player for the current Premier League season.
You will be able to search up on players’ statistics based on their characteristics and even update the scores on your own. Stay updated on the goals and assists scored by each player against the opposing club with ease.
 
# Project overview
This project stems from the design of a Spring Boot REST API for a one-to-many relationship between football players and statistics, as well as a many-to-one relationship between football players and football club. Users will be able to search up players based on the characteristics of the player namely their first/last name, football club, position, age, and nationality. The project also includes CRUD components where users can create new data for players, retrieve data for one or all players in the database, update the specific statistics of a player or delete a player from the database. In a many-to-many relationship, one entity usually holds a collection of the other entity. For example, each Player can have multiple Positions, and each Position can have multiple Players
 
# Future Enhancements
In the future, the project will be improved with the following enhancements:
- [ ] To expand the scope of use to include other sports such as basketball etc.
 
# Other Info
To use swagger UI
http://localhost:8080/swagger-ui/index.html#/

#These are the endpoints and how to call the API.

GET All Players
http://localhost:8080/players

GET One Player
http://localhost:8080/players/{id}

POST (Create) Player
http://localhost:8080/players

{
        "firstName": "Alfred",
        "lastName": "Lim",
        "footballclub": "LiverPool",
        "playerposition": "Midfielder",
        "age": 28,
        "nationality": "Singaporean"
}

PUT (Update)
http://localhost:8080/players/{id}

{
        "firstName": "Alfred",
        "lastName": "Lim",
        "footballclub": "Manchester United",
        "playerposition": "Striker",
        "age": 28,
        "nationality": "Singaporean"
}
        
DELETE 
http://localhost:8080/players/{id}

GET Search via PlayerName 
http://localhost:8080/players/search?playerName=Alfred

POST Statistics for Player ID 1 
http://localhost:8080/players/1/statistics
{
    "goals": 2,
    "assists": 3,
    "opposition": "Chelsea",
    "matchDate": "2020-02-20"
}




