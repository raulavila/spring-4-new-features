package com.raulavila.spring.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;

public class JdbcApplication {

    public static void main(String args[]) {
        SimpleDriverDataSource dataSource = createDataSource();
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

        createDatabase(jdbcTemplate);
        insertData(jdbcTemplate);

        queryDB(jdbcTemplate);
        queryDB_Java8(jdbcTemplate);
    }

	private static void queryDB(JdbcTemplate jdbcTemplate) {
		System.out.println("Java 7 Querying for customer records " +
                            "where first_name = 'Bart':");

        List<Customer> results = jdbcTemplate.query(
                "select * from customers " +
                        "where first_name = ?", 
                new Object[] { "Bart" },
                new RowMapper<Customer>() {
                    @Override
                    public Customer mapRow(ResultSet rs, 
                                           int rowNum) throws SQLException {
                        return new Customer(rs.getLong("id"), 
                                            rs.getString("first_name"),
                                            rs.getString("last_name"));
                    }
                });

        processCustomers(results);
    }

    private static void queryDB_Java8(JdbcTemplate jdbcTemplate) {
		System.out.println("Java 8 Querying for customer records " +
                            "where first_name = 'Bart':");
        List<Customer> results = jdbcTemplate.query(
                "select * from customers " +
                        "where first_name = ?",
                new Object[] { "Bart" },
                (rs, rowNum) -> new Customer(rs.getLong("id"),
                							rs.getString("first_name"),
                							rs.getString("last_name")));

        processCustomers(results);
    }


    private static void processCustomers(List<Customer> results) {
        for (Customer customer : results) {
            System.out.println(customer);
        }
    }


	private static void insertData(JdbcTemplate jdbcTemplate) {
		String[] names = "Bart Simpson;Homer Simpson;Seymour Skinner;Ned Flanders".split(";");
        for (String fullname : names) {
            String[] name = fullname.split(" ");
            System.out.printf("Inserting customer record for %s %s\n", name[0], name[1]);
            jdbcTemplate.update(
                    "INSERT INTO customers(first_name,last_name) values(?,?)",
                    name[0], name[1]);
        }
	}

	private static void createDatabase(JdbcTemplate jdbcTemplate) {
		jdbcTemplate.execute("drop table customers if exists");
        jdbcTemplate.execute("create table customers(" +
                "id serial, first_name varchar(255), last_name varchar(255))");
	}

	private static SimpleDriverDataSource createDataSource() {
		SimpleDriverDataSource dataSource = new SimpleDriverDataSource();
        dataSource.setDriverClass(org.h2.Driver.class);
        dataSource.setUsername("sa");
        dataSource.setPassword("sa");
        dataSource.setUrl("jdbc:h2:~/test");
		return dataSource;
	}
}
