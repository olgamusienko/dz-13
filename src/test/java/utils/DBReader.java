package utils;


import models.Person;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class DBReader {

    private final static String URL = "jdbc:postgresql://localhost:5432/postgres";
    private final static String USER_NAME = "postgres";
    private final static String USER_PASSWORD = "postgres";
    private final static String QUERY_SELECT = "select * from people";
    private final static String QUERY_INSERT = "insert into people (id, first_name, last_name, age) values (?,?,?,?)";
    private final static String QUERY_UPDATE = "update people set last_name=? where id=?";
    private final static String QUERY_DELETE = "delete from people where id=?";
    public static List<Person> getPeopleFromDB() {
        List<Person> peopleList = new ArrayList<>();

        try (Connection connection = DriverManager.getConnection(URL, USER_NAME, USER_PASSWORD)) {
            Statement sqlStatement = connection.createStatement();
            ResultSet resultSet = sqlStatement.executeQuery(QUERY_SELECT);
            while (resultSet.next()) {
                Person person = new Person(resultSet.getString("first_name"),
                resultSet.getString("last_name"),
                resultSet.getInt("age"));
                peopleList.add(person);
            }
        } catch (SQLException exception) {

            throw new RuntimeException(String.format("Please check connection string" + ". URL [%s], name [%s], password [%s]", URL, USER_NAME, USER_PASSWORD));


        }
        return peopleList;

    }

    public static void insertPerson(int id, String first_name, String last_name, int age) {
        try (Connection connection = DriverManager.getConnection(URL, USER_NAME, USER_PASSWORD)) {
            PreparedStatement preparedStatement = connection.prepareStatement(QUERY_INSERT);
            preparedStatement.setInt(1, id);
            preparedStatement.setString(2, first_name);
            preparedStatement.setString(3, last_name);
            preparedStatement.setInt(4, age);
            preparedStatement.executeUpdate();

        } catch (SQLException exception) {

            throw new RuntimeException(String.format("Please check connection string" + ". URL [%s], name [%s], password [%s]", URL, USER_NAME, USER_PASSWORD));

        }

    }

    public static void updatePerson(int id, String last_name) {
        try (Connection connection = DriverManager.getConnection(URL, USER_NAME, USER_PASSWORD)) {
            PreparedStatement preparedStatement = connection.prepareStatement(QUERY_UPDATE);
            preparedStatement.setInt(2, id);
            preparedStatement.setString(1, last_name);
            preparedStatement.executeUpdate();
        } catch (SQLException exception) {
            throw new RuntimeException(String.format("Please check connection string" +
                    ". URL [%s], name [%s], pass [%s]", URL, USER_NAME, USER_PASSWORD));
        }
    }
    public static void deletePerson(int id) {
        try (Connection connection = DriverManager.getConnection(URL, USER_NAME, USER_PASSWORD)) {

            PreparedStatement preparedStatement = connection.prepareStatement(QUERY_DELETE);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();

        } catch (SQLException exception) {
            throw new RuntimeException(String.format("Please check connection string" +
                    ". URL [%s], name [%s], pass [%s]", URL, USER_NAME, USER_PASSWORD));
        }
    }

    public static void main(String[] args) {
        System.out.println(getPeopleFromDB());
        insertPerson(6,"Lisa", "Anderson", 38);
        System.out.println(getPeopleFromDB());
        updatePerson(6, "Taylor");
        System.out.println(getPeopleFromDB());
        deletePerson(5);
        System.out.println(getPeopleFromDB());
    }

}
