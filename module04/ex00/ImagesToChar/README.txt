# clean target
rm -rf target

# create target folder
mkdir target

# compile project
#javac -sourcepath ./src/java/ -d ./target/ ./src/java/edu/school21/printer/*/*.java
javac -sourcepath ./src/java `find . -name "*.java"` -d target

# run project
java -cp ./target/ Program . 0 ./it.bmp