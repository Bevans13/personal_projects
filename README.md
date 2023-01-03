# personal_projects

Project Title - Ark Tracker
The main function of this repository is to be an application used in conjunction with the popular game Ark Survival.
The primary language at the time of writting this is Java, as that is the language I have the most experience with. 
Other languages are possible to be included or implemented as my knowledge base grows. Developed using VSCode w/extensions.

The function of this tracker is to track tamed creatures within the game across multiple maps/saves. 
The stats saved in this tool are the original stats of each tame as those are what are passed down to offspring in the game's mating process.

At present uses Serialization to store and load save data between program launches (currently only serializes the Tames ArrayList<Crreature> as 
there does not appear to be anything additional that would need to be carried over). Open to better forms of storing save data between uses but 
for now this is the most practical solution that I know how to do.

Currently as of V3.0.57 the program is mostly functional, the only difficulty being developing a means of displaying additional 
creatures in the viewing option once the initial view screen is full (so anything over 9 creatures). Once that is figured out the program should 
be able to be used with actual gameplay.

Currently runs from a terminal with Java capabilities. Upon completion of initial program it is intended to learn more about making it launchable outside 
of a terminal. (Perhaps by exporting as a .jar file?)

