# clean target
rm -rf target

# create target folder
mkdir target

# compile project
javac -d ./target src/java/edu/school21/printer/*/*.java

# run project
java -cp target edu.school21.printer.app.Program /Users/rriddler/Desktop/Java/module04/ex00/ImagesToChar/it.bmp . 0