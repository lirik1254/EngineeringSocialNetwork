package org.example.engineeringsocialnetwork;

import org.example.engineeringsocialnetwork.entities.Course;
import org.example.engineeringsocialnetwork.entities.Info;
import org.example.engineeringsocialnetwork.entities.Project;
import org.example.engineeringsocialnetwork.entities.User;
import org.example.engineeringsocialnetwork.factory.CourseFactory;
import org.example.engineeringsocialnetwork.factory.ProjectFactory;
import org.example.engineeringsocialnetwork.factory.UserFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class InputOutputTest {
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    InputOutput inputOutput = new InputOutput();

    public void setInput(String buffer) {
        ByteArrayInputStream in = new ByteArrayInputStream(buffer.getBytes());
        System.setIn(in);

        inputOutput.setScanner(new Scanner(System.in));
    }

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @Test
    public void getNumInputInBordersTest() {
        setInput("1\n");

        assertEquals(1, inputOutput.getNumInput(1, 3, "alo"));
    }

    @Test
    public void getNumInputOutBordersTest() {
        setInput("0\n2\n");

        assertEquals(2, inputOutput.getNumInput(1, 3, ""));
        assertEquals("Введенное число должно быть в диапазоне от 1 до 3", outputStreamCaptor.toString().trim());
    }

    @Test
    public void getNumInputWithAdditionalStringTest() {
        setInput("1\n");

        inputOutput.getNumInput(1, 3, "aloha");

        assertEquals("aloha", outputStreamCaptor.toString().trim());
    }

    @Test
    public void exitAnswerTest() {
        setInput("0\n");

        inputOutput.getStart();
        assertEquals(inputOutput.getMessage(), outputStreamCaptor.toString());
    }

    @Test
    public void mainInfoAnswerTest() {
        setInput("1\n0\n");

        inputOutput.getStart();
        assertTrue(outputStreamCaptor.toString().contains(Info.MAIN_INFO));
    }

    @Test
    public void courseFactoryAnswerTest() {
        setInput("2\n0\n");
        CourseFactory courseFactory = new CourseFactory();
        StringBuilder courses = new StringBuilder();
        for (Course course : courseFactory.getCourses()) {
            courses.append(course.toString());
        }


        inputOutput.getStart();
        assertTrue(outputStreamCaptor.toString()
                .trim()
                .replace("\n", "")
                .replace("\r", "")
                .contains(courses.toString()
                        .trim())
        );
    }

    @Test
    public void projectFactoryAnswerTest() {
        setInput("3\n0\n");
        ProjectFactory projectFactory = new ProjectFactory();
        StringBuilder projects = new StringBuilder();
        for (Project project : projectFactory.getProjects()) {
            projects.append(project.toString());
        }

        inputOutput.getStart();
        assertTrue(outputStreamCaptor.toString()
                .trim()
                .replace("\n", "")
                .replace("\r", "")
                .contains(projects.toString()
                        .trim())
        );
    }

    @Test
    public void userFactoryAnswerTest() {
        setInput("4\n0\n");
        UserFactory userFactory = new UserFactory();
        StringBuilder users = new StringBuilder();
        for (User user : userFactory.getUsers()) {
            users.append(user.toString());
        }

        inputOutput.getStart();
        assertTrue(outputStreamCaptor.toString()
                .trim()
                .replace("\n", "")
                .replace("\r", "")
                .contains(users.toString()
                        .trim())
        );
    }

    @Test
    public void legalInformationInfoAnswerTest() {
        setInput("5\n0\n");

        inputOutput.getStart();
        assertTrue(outputStreamCaptor.toString().contains(Info.LEGAL_INFORMATION));
    }
}
