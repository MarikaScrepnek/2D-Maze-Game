<h1 align="center">
  SFU Parking Mayhem
</h1>
  
  ![mainMenuFINAL](https://media.github.sfu.ca/user/3737/files/242a2f4c-1d36-40cc-b8c7-3072eac61b94)
  ![game](https://media.github.sfu.ca/user/3737/files/182aa9bf-4a22-4d37-bbd3-5a229d8786b9)
  
</p>
  
## Description
Navigate the chaos of SFU’s mid-day parking in this fast-paced game where every decision matters. As a driver trapped in a maze-like parking lot filled with traffic cones, parked cars, and a persistent Concord parking officer, your goal is simple: collect 10 scattered coins to afford a parking pass and escape without penalties. Avoid parked cars, outrun the ever-watchful parking officer, and seize lost student notes for bonus points. But beware—if your score drops below zero or you’re caught without a pass, it’s game over! Can you secure your parking pass before disaster strikes?

## Prerequisites 
Ensure you have the following installed:
  - Java Development Kit (JDK 8 or later)
  - Apache Maven (for building and testing)
  - Git (for version control)

## Installation 
1. Clone the Repository: 
    - Copy and paste the command below into your desired IDE terminal
    - `git clone git@github.sfu.ca:nma96/CMPT276S25_group25.git`
2. Build the Project:
    - Using maven, copy and paste the command below in the /sfuparkingmayhem directory
    - `mvn clean package verify`
    - This will compile the project

## Artifacts
Jar package (sfuparkingmayhem-1.0-SNAPSHOT.jar): located in the sfuparkingmayhem/target directory

JavaDocs (index.html): located in the sfuparkingmayhem/target/reports/apidocs directory

## Running the Game
After building the project, to run the game copy and paste the command below for Mac:
  - `mvn exec:java -Dexec.mainClass="com.sfuparkingmayhem.game.Main"`

Or copy the command below for Windows:
  - `mvn exec:java "-Dexec.mainClass=com.sfuparkingmayhem.game.Main"`

To run the .jar file directly, copy and paste the command below:
  - `java -jar target/sfuparkingmayhem-1.0-SNAPSHOT.jar`

## Testing
To run tests using JUnit and Maven copy and paste the command below:
  - `mvn clean test`

## Our Video Link
https://www.youtube.com/watch?v=gI7IDLpPFyk 

## Helpful Resources:
  - Game: [Youtube Video](https://www.youtube.com/watch?v=PJLLDpaLjds)
  - Concord officer: [Youtube Video](https://www.youtube.com/watch?v=yhx0Ew8ttP4)
  - Concord officer: [GeeksForGeeks](https://www.geeksforgeeks.org/dijkstras-shortest-path-algorithm-in-java-using-priorityqueue/) 

## References for Images/Sprites:
  - [Lost Note](https://clipart-library.com/image_gallery/541546.png) 
  - [Coin](https://png.monster/wp-content/uploads/2022/08/png.monster-90.png) 
  - [Cone](https://www.vecteezy.com/vector-art/32311945-pixel-art-illustration-traffic-cone-pixelated-traffic-cone-traffic-cone-safety-icon-pixelated-for-the-pixel-art-game-and-icon-for-website-and-video-game-old-school-retro)
  - [TicketBooth](https://png.pngtree.com/png-vector/20220610/ourmid/pngtree-carnival-information-ticket-booth-isolated-on-white-background-png-image_4868612.png)
  - [Bush](https://img.itch.zone/aW1nLzEzNTMyODEzLnBuZw==/original/sfw8DA.png)
  - [Vehicles](https://minzinn.itch.io/pixelvehicles)
  - [Parking Sign](https://static.vecteezy.com/system/resources/thumbnails/022/283/619/small_2x/3d-render-blue-parking-sign-isolated-illustration-3d-render-parking-icon-on-white-background-png.png)
  - [UI Buttons and Font](https://kenney.nl/assets/ui-pack)
  - Background Image: OpenAI. (2025). Pixel-art parking lot background for a game menu [AI-generated image]. OpenAI DALL·E.

## Additional References for Game Demo Video:
  - [Music](https://www.youtube.com/watch?v=l7SwiFWOQqM&list=PLwJjxqYuirCLkq42mGw4XKGQlpZSfxsYd&index=5)
  - [Sky](https://stockcake.com/i/peaceful-pixel-sky_1885630_1295168)
  - [Red Cloud](https://www.iconsdb.com/red-icons/cloud-5-icon.html)
