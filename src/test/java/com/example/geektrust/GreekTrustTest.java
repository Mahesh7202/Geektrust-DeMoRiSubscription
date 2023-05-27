package com.example.geektrust;

import org.junit.jupiter.api.*;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.regex.Pattern;


class GreekTrustTest {
    private final PrintStream standardOut = System.out;

    private static final Pattern LINE_SEPARATOR_PATTERN = Pattern.compile("\\R");

    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    private String[] argument;
    private String expectedOutput;

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor,true));
    }



    @Test
    @DisplayName("Integration Test #1")
    void runTest1() throws IOException {
        // Arrange
        argument = new String[]{"sample_input/input1.txt"};
        expectedOutput = "RENEWAL_REMINDER MUSIC 23-02-2022\n" +
                "RENEWAL_REMINDER VIDEO 25-04-2022\n" +
                "RENEWAL_REMINDER PODCAST 23-02-2022\n" +
                "RENEWAL_AMOUNT 700";

        // Act
        GreekTrust.main(argument);

        // Assert
        Assertions.assertEquals(normalizeLineSeparators(expectedOutput), normalizeLineSeparators(outputStreamCaptor.toString().trim()));
    }


    @Test
    @DisplayName("Integration Test #2")
    void runTest2(){
        //Arrange
         argument = new String[]{"sample_input/input2.txt"};
         expectedOutput = "RENEWAL_REMINDER MUSIC 27-02-2020\n" +
                "RENEWAL_REMINDER PODCAST 29-12-2019\n" +
                "RENEWAL_AMOUNT 550";
        // Act
        GreekTrust.main(argument);

        // Assert
        Assertions.assertEquals(normalizeLineSeparators(expectedOutput), normalizeLineSeparators(outputStreamCaptor.toString().trim()));
    }


    @Test
    @DisplayName("Integration Test #3")
    void runTest3(){
        //Arrange
         argument = new String[]{"sample_input/input3.txt"};
        expectedOutput = "RENEWAL_REMINDER MUSIC 15-10-2021\n" +
                "RENEWAL_REMINDER VIDEO 15-10-2021\n" +
                "RENEWAL_REMINDER PODCAST 15-08-2021\n" +
                "RENEWAL_AMOUNT 850";
        // Act
        GreekTrust.main(argument);

        // Assert
        Assertions.assertEquals(normalizeLineSeparators(expectedOutput), normalizeLineSeparators(outputStreamCaptor.toString().trim()));
    }

    @Test
    @DisplayName("Integration Test #4")
    void runTest4(){
        //Arrange
         argument = new String[]{"sample_input/input4.txt"};
        expectedOutput = "INVALID_DATE\n" +
                "ADD_SUBSCRIPTION_FAILED INVALID_DATE\n" +
                "ADD_SUBSCRIPTION_FAILED INVALID_DATE\n" +
                "ADD_TOPUP_FAILED INVALID_DATE\n" +
                "SUBSCRIPTIONS_NOT_FOUND";
        // Act
        GreekTrust.main(argument);

        // Assert
                Assertions.assertEquals(normalizeLineSeparators(expectedOutput), normalizeLineSeparators(outputStreamCaptor.toString().trim()));

    }

    @Test
    @DisplayName("Integration Test #5")
    void runTest5(){
        //Arrange
         argument = new String[]{"sample_input/input5.txt"};
        expectedOutput = "ADD_SUBSCRIPTION_FAILED DUPLICATE_CATEGORY\n" +
                "ADD_TOPUP_FAILED DUPLICATE_TOPUP\n" +
                "RENEWAL_REMINDER MUSIC 10-11-2022\n" +
                "RENEWAL_AMOUNT 200";
        //Act
        GreekTrust.main(argument);

        // Assert
                Assertions.assertEquals(normalizeLineSeparators(expectedOutput), normalizeLineSeparators(outputStreamCaptor.toString().trim()));

    }


    @Test
    @DisplayName("Integration Test #6")
    void runTest6(){
        //Arrange
         argument = new String[]{"sample_input/input6.txt"};
        expectedOutput = "RENEWAL_REMINDER MUSIC 10-03-2022\n" +
                "RENEWAL_REMINDER VIDEO 10-03-2022\n" +
                "RENEWAL_REMINDER PODCAST 10-03-2022\n" +
                "RENEWAL_AMOUNT 250";
        //Act
        GreekTrust.main(argument);

        // Assert
                Assertions.assertEquals(normalizeLineSeparators(expectedOutput), normalizeLineSeparators(outputStreamCaptor.toString().trim()));

    }


    @Test
    @DisplayName("Integration Test #7")
    void runTest7(){
        //Arrange
         argument = new String[]{"sample_input/input7.txt"};
        expectedOutput = "ADD_TOPUP_FAILED SUBSCRIPTIONS_NOT_FOUND\n" +
                "SUBSCRIPTIONS_NOT_FOUND";
        //Act
        GreekTrust.main(argument);

        // Assert
                Assertions.assertEquals(normalizeLineSeparators(expectedOutput), normalizeLineSeparators(outputStreamCaptor.toString().trim()));

    }


    @Test
    @DisplayName("Integration Test #8")
    void runTest8(){
        //Arrange
         argument = new String[]{"sample_input/input8.txt"};
        expectedOutput = "SUBSCRIPTIONS_NOT_FOUND";
        //Act
        GreekTrust.main(argument);

        // Assert
                Assertions.assertEquals(normalizeLineSeparators(expectedOutput), normalizeLineSeparators(outputStreamCaptor.toString().trim()));

    }


    @Test
    @DisplayName("Integration Test #9")
    void runTest9(){
        //Arrange
         argument = new String[]{"sample_input/input9.txt"};
        expectedOutput = "ADD_SUBSCRIPTION_FAILED DUPLICATE_CATEGORY\n" +
                "ADD_SUBSCRIPTION_FAILED DUPLICATE_CATEGORY\n" +
                "ADD_SUBSCRIPTION_FAILED DUPLICATE_CATEGORY\n" +
                "ADD_SUBSCRIPTION_FAILED DUPLICATE_CATEGORY\n" +
                "ADD_SUBSCRIPTION_FAILED DUPLICATE_CATEGORY\n" +
                "ADD_SUBSCRIPTION_FAILED DUPLICATE_CATEGORY\n" +
                "ADD_TOPUP_FAILED DUPLICATE_TOPUP\n" +
                "RENEWAL_REMINDER MUSIC 28-03-2022\n" +
                "RENEWAL_REMINDER VIDEO 28-03-2022\n" +
                "RENEWAL_REMINDER PODCAST 28-05-2022\n" +
                "RENEWAL_AMOUNT 700";
        //Act
        GreekTrust.main(argument);

        // Assert
                Assertions.assertEquals(normalizeLineSeparators(expectedOutput), normalizeLineSeparators(outputStreamCaptor.toString().trim()));

    }


    @AfterEach
    public void tearDown() {
        System.setOut(standardOut);
    }

    private String normalizeLineSeparators(String str) {
        return LINE_SEPARATOR_PATTERN.matcher(str).replaceAll("\n");
    }


}