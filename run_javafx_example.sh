#!/bin/bash

# Example script to compile and run any JavaFX application from the root directory
# Copy this file to run_javafx.sh and update the JAVAFX_PATH to match your installation

# Set the JavaFX path (absolute path)
# UPDATE THIS PATH TO MATCH YOUR JAVA FX INSTALLATION
JAVAFX_PATH="/path/to/your/javafx-sdk/lib"

# Check if a Java file was provided as an argument
if [ $# -eq 0 ]; then
    echo "Usage: $0 <PathToJavaFile> [Additional JavaFX modules]"
    echo "Example: $0 snippets/module-1/m1_db/Module1DiscussionDemo.java"
    echo "Example: $0 src/MyApplication.java javafx.media"
    exit 1
fi

# Get the Java file path
JAVA_FILE_PATH="$1"

# Extract the directory and file name
JAVA_DIR=$(dirname "$JAVA_FILE_PATH")
JAVA_FILE=$(basename "$JAVA_FILE_PATH")
CLASS_NAME="${JAVA_FILE%.java}"

# Check if the file exists
if [ ! -f "$JAVA_FILE_PATH" ]; then
    echo "Error: File $JAVA_FILE_PATH not found!"
    exit 1
fi

# Set default modules
MODULES="javafx.controls,javafx.fxml"

# Add additional modules if provided
if [ $# -gt 1 ]; then
    MODULES="$MODULES,$2"
fi

# Save current directory
CURRENT_DIR=$(pwd)

# Change to the Java file directory
cd "$JAVA_DIR" || exit 1

echo "Compiling $JAVA_FILE..."
# Compile the Java file
javac --module-path "$JAVAFX_PATH" --add-modules $MODULES "$JAVA_FILE"

if [ $? -eq 0 ]; then
    echo "Compilation successful!"
    echo "Running $CLASS_NAME..."
    # Run the application with native access enabled to avoid warnings
    java --module-path "$JAVAFX_PATH" --add-modules $MODULES --enable-native-access=javafx.graphics $CLASS_NAME
else
    echo "Compilation failed!"
    # Change back to original directory
    cd "$CURRENT_DIR"
    exit 1
fi

# Change back to original directory
cd "$CURRENT_DIR"
