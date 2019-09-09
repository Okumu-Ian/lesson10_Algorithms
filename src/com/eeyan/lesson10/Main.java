package com.eeyan.lesson10;

public class Main {

    /*1. Adding
    * 2. Searching(Linear) ==>
    * 3. Deleting */

    //Array that will occupy as many as 50 digits
    private int [] arrayOfNumbers = new int[50];

    //The number of elements to initially add
    private int numOfElements = 10;

    //Method to generate random numbers
    private void generateRandomNumbers(){

        for (int i = 0; i < numOfElements; i++) {
            //generate random values
            int randNumber = (int) (Math.random() * 10) * 10;

            //assigning values to positions
            arrayOfNumbers[i] = randNumber;
        }
    }


    public static void main(String[] args) {

        Main main = new Main();

        main.generateRandomNumbers();
        main.printArrays();
        main.addValueToArray(25);
        System.out.println("The values were found at: "+main.searchValues(25));

        main.addValueToSpecificIndex(3,7000);

        main.printArrays();

        main.deleteValueFromSpecificIndex(6);

        main.printArrays();


    }


    //printing out the table-like structure
    private void printArrays(){
        System.out.println("----------");
        for (int i = 0; i < numOfElements; i++) {
            System.out.print("| " + i + " | " + arrayOfNumbers[i] + " |\n");
            System.out.print("----------\n");
        }
    }

    //using linear search to locate value
    private String searchValues(int searchValue){

        String valuesInPositions = "";

        int i = 0;
        while (i < numOfElements){
            if(arrayOfNumbers[i] == searchValue){
                valuesInPositions = valuesInPositions + i + ":";
            }
            i++;
        }

        if(valuesInPositions.length() < 1){
            return "None";
        }else {
            return valuesInPositions;
        }
    }

    private void addValueToArray(int valueToAdd){
        numOfElements++;
        arrayOfNumbers[numOfElements - 1] = valueToAdd;
    }

    private void addValueToSpecificIndex(int index, int valueToAdd){

        int maxIndex = numOfElements + 1;
        if(index > maxIndex){
            System.out.println("Hey you can not add to that index!!");
        }else{
            int [] tempValues = new int[numOfElements - index];
            int x = 0;
            for (int i = index; i < numOfElements; i++) {
                tempValues[x] = arrayOfNumbers[i];
                x++;
            }

            arrayOfNumbers[index] = valueToAdd;
            numOfElements++;

            int y = 0;
            for (int i = (index + 1); i < numOfElements; i++) {
                arrayOfNumbers[i] = tempValues[y];
                y++;
            }
        }

    }


    private void deleteValueFromSpecificIndex(int index){
        if(index >= numOfElements){
            System.out.println("Hey, delete existing things!!!");
        }else{
            for (int i = index; i <(numOfElements - 1) ; i++) {
                arrayOfNumbers[i] = arrayOfNumbers[i + 1];
            }
            numOfElements--;
        }
    }

}