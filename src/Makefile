JAVA_FILE = Lab1

CPP_FILE = maximum.cc

CPP_SHARED_LIB = libmaximum.so

JAVA_CPP_PATH = /ruta/a/javacpp.jar #independent for the area where each person is going to compile

JAVAC = javac

CXX = g++
CXXFLAGS = -shared -o $(CPP_SHARED_LIB)

JAVA = java

JAVA_PARAMS = -cp .:$(JAVA_CPP_PATH) $(JAVA_FILE)

NUMBERS_DIR = ./data
NUMBERS_FILE = $(NUMBERS_DIR)/numMax.txt

all: compile_java compile_cpp run

compile_java:
	$(JAVAC) -cp .:$(JAVA_CPP_PATH) $(JAVA_FILE).java

compile_cpp:
	$(CXX) $(CXXFLAGS) $(CPP_FILE)

run:
	$(JAVA) $(JAVA_PARAMS) $(NUMBERS_FILE)

clean:
	rm -f *.class $(CPP_SHARED_LIB)

.PHONY: all compile_java compile_cpp run clean
