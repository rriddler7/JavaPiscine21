# clean target
rm -rf target

# create target folder
mkdir target

# compile project
javac -d ./target src/java/edu/school21/printer/*/*.java

# copy resources
cp -r ./src/resources ./target

# create jar-archive
jar cfm ./target/images-to-chars-printer.jar ./src/manifest.txt -C target .

# run project
java -jar ./target/images-to-chars-printer.jar /Users/rriddler/Desktop/Java/module04/ex01/ImageToChar/src/resources/image.bmp . 0