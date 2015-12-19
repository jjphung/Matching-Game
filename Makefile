# Written by Jeffrey Phung 
# 11-12-2015


# Variables
RM = @rm
SC = @scalac
JC = @javac


# Entry point
compile: 

	@echo Compiling scala files: Board.scala, DirImages.scala...
	$(SC) DirImages.scala Board.scala

	@echo Compiling java files: Matching.java...
	$(JC) -cp lib/*:. Matching.java

# Rule for execution
run:
	@echo Running...
	@java -cp lib/*:. Matching

clean:
	$(RM) -f *.class
