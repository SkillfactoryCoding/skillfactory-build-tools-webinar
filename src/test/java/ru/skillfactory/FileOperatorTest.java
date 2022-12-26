package ru.skillfactory;

import org.junit.Test;

import java.io.IOException;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class FileOperatorTest {

    @Test
    public void testWhenWeReadFileShouldGetSomeData() throws IOException {
        FileOperator fileOperator = new FileOperator();
        String line = fileOperator.read("/Users/ilmax/Desktop/1.txt");
        assertThat("Could not read file", line, is("SkillFactory"));
    }

    @Test
    public void testWhenWeReadFileAsLineShouldGetNotEmptyCollection() throws IOException {
        FileOperator fileOperator = new FileOperator();
        List<String> strings = fileOperator.readAsList("C://Users//Ilmax//Desktop//1.txt");
        assertThat("Could not read file", strings.size(), is(1));
        assertThat("Could not calculate read strings", fileOperator.getStringRead(), is(1L));
    }

    @Test
    public void writeToFileTest() throws IOException {
        FileOperator fileOperator = new FileOperator();
        fileOperator.write("Zoom", "C://Users//Ilmax//Desktop//2.txt");
        String readData = fileOperator.read("C://Users//Ilmax//Desktop//2.txt");
        assertThat("Could not read file", readData, is("Zoom"));
    }

}