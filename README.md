##Jeffrey Phung 11-20-2015

All pictures are taken from https://openclipart.org/.

"free for commercial and non-commercial use on cards, books, crafts, 
 fashion, merchandise, and services."

###Description:
[Menu Screen:](http://postimg.org/image/g77vu8par/)
[Play Screen:](http://postimg.org/image/4jdtzp05v/)

This project features a Matching Game with 6 categories. Upon entering, 10
blank cards show up and it is up to the player to flip over a card and try to
match that. Non-matching games show for 1 second before turning blank again.
Match all the cards to win and try again if the player wishes.

###Purpose:
To experience Scala and Java interop! It was amazing to see two languages together
with such fluidity.

###File Structure:
```
gameRoot
├── Animals
│   ├── bird.png
│   ├── chicken.png
│   ├── cow.png
│   ├── horse.png
│   └── pig.png
├── Board.scala
├── build.sbt
├── Candies
│   ├── Candy Corn.png
│   ├── Cotton Candy.png
│   ├── Gummy Bear.png
│   ├── Hard Candy.png
│   └── Lollipop.png
├── Colors
│   ├── blue.png
│   ├── green.png
│   ├── orange.png
│   ├── red.png
│   └── yellow.png
├── DirImages.scala
├── Fishes
│   ├── Angel Fish.png
│   ├── Butterfly Fish.png
│   ├── Clown Fish.png
│   ├── Goldfish.png
│   └── Shark.png
├── lib
│   ├── scala-library.jar
│   └── scala-swing_2.11-1.0.1.jar
├── Makefile
├── Matching.java
├── Plants
│   ├── corn.png
│   ├── daisy.png
│   ├── dandelion.png
│   ├── rose.png
│   └── tulips.png
├── project
│   └── target
│       └── config-classes
│           ├── $24b3269060bbba8a2e96$$anonfun$$sbtdef$1.class
│           ├── $24b3269060bbba8a2e96.cache
│           ├── $24b3269060bbba8a2e96.class
│           └── $24b3269060bbba8a2e96$.class
├── README.md
├── Sports
│   ├── basketball.png
│   ├── cricket.png
│   ├── football.png
│   ├── soccer.png
│   └── volleyball.png
└── target
    └── streams
        └── $global
            ├── clean
            │   └── $global
            │       └── streams
            │           └── out
            ├── ivyConfiguration
            │   └── $global
            │       └── streams
            │           └── out
            ├── ivySbt
            │   └── $global
            │       └── streams
            │           └── out
            └── projectDescriptors
                └── $global
                    └── streams
                        └── out

25 directories, 46 files
```
###Prerequisites:
make command or sbt

###How to run:

####Method 1:

```
cd /path/to/folder/
make clean
make
make run
```

####Method 2:

```
cd /path/to/folder/
sbt clean
sbt compile
sbt run
```
