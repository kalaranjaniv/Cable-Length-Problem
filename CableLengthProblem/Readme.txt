Introduction:

Many science fiction stories take place on distant planets in galaxies far, far, away. Some of the best writers will spend time researching the relevant scientific fields of today to make their futuristic technology seem believable to a modern day audience. As a budding young writer participating in the National Novel Writing Month (NaNoWriMo) in November, you'd like to do some technological research as well to make sure your own SF universe is up to par.

In your own SF novel, humanity has spread out throughout the galaxy and has come to colonize many a planet. Aside from the obvious requirement of interstellar space flight in your book, you'd like to keep all other technologies, computers especially, similar to what is available in today's world. That means the computer networks on many of the colonized planets will still be designed by running copper or fiber optic cable between the computers.

Modern computer networks use packet switching which means that you do not have to physically run a separate cable between every pair of computers. It's enough that the computer network remains strongly connected. In other words, it's enough that for every pair of computers on the network, some path exists such that packets traveling to and fro between the computers can reach their destinations by being forwarded through any number of computers in-between.

This property of packet switching allows us to minimize how much cable has to be laid down to allow every computer on the network to communicate with every other. As a budding SF writer, you'd like to know the absolute minimum total length of cable that would be required to create a computer network between all the cities on your newly colonized planet, assuming there are no redundant or aggregate links in the network. When performing your calculations, you may assume that the planet is a perfect sphere, all the cables are run along the surface of the planet, and that no surface obstructions (like rivers or mountain ranges) exist to impede the run of cable.

The input to this problem will specify the diameter of the planet in question, and it will include a list of city coordinates given in degrees of latitude and longitude. For those who are not as cartographically savvy as they'd like, latitude is an angular measurement ranging from -90� at the South pole to +90� at the North pole and with 0� located at a planet's equator. Longitude is an angular measurement ranging between -180� and +180� with 0� specifying the prime meridian. By convention negative longitude represents locations to the West of the prime meridian, and positive longitude presents locations to the East.

Input:

Input to this problem will begin with a line containing a single integer N (1 = N = 100) indicating the number of data sets. Each data set consists of the following components:

A line containing a single decimal number D (1 = D = 1,000,000) specifying the diameter (in kilometers) of the planet in question.
A line containing a single decimal number L (1 = L = 1,000,000) giving the total length of cable (in kilometers) available for building a network on the newly colonized planet.
A line containing a single integer C (1 = C = 100) indicating the number of cities this planet contains.
A series of C lines, each of which contains two decimal numbers of the form "X Y" respectively specifying the latitude and longitude (both in degrees) of one city with (-90 = X = 90) and (-180 = X = 180).
Output:

For each data set in the input, print a single line. Print either "IS POSSIBLE" if the available length of cable L is enough to network all the cities, or print "IS NOT POSSIBLE" if the available length of cable L is too short.

Sample Input:

2
12742
5900
3
51.3 0
42.5 -75
48.8 3
12742
620
2
30.266 97.75
30.45 91.1333
Sample Output:

IS POSSIBLE
IS NOT POSSIBLE