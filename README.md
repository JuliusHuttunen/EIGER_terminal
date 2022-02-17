# EIGER_terminal
A small Java command line app emulating an EIGER language terminal.

##  1. Usage

Clone the repository with ``git clone`` and run with the Java IDE of your choice.

## 2. How it works?

- ``define (int) (variableLabel)`` Define a variable. The value ``int`` must be an integer.
- ``eval (variableLabel) (operator) (variableLabel)`` Compare two variables with an operator. Operators: ``<``, ``>`` and ``=``.
- ``eval`` returns a boolean value or undefined depending of the evaluation outcome.

## 3. Sample code

### Input:

````
define 5 hellothere
define 6 goodbye
eval hellothere < goodbye
eval hellothere > goodbye
eval hellothere = goodbye
eval hellothere = hi
define 5 hi
eval hellothere = hi
define 6 hi
eval hellothere = hi
````

### Output

````
true
false
false
undefined
true
false
````

