package com.niconicocalendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication
public class Application implements CommandLineRunner {
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public void run(String... strings) throws Exception {

		jdbcTemplate.execute("drop table user_tbl if exists");
		jdbcTemplate.execute("create table user_tbl(userId integer, username varchar)");
		
		jdbcTemplate.execute("drop table feelings_tbl if exists");
		jdbcTemplate.execute("create table feelings_tbl(feelingId integer, feeling varchar)");
		String[] feelings = {"niconico","iraira","futsu","shikushiku","utouto"};
		jdbcTemplate.update("insert into feelings_tbl(feelingId, feeling) values(?,?)", 0, feelings[0]);
		jdbcTemplate.update("insert into feelings_tbl(feelingId, feeling) values(?,?)", 1, feelings[1]);		
		jdbcTemplate.update("insert into feelings_tbl(feelingId, feeling) values(?,?)", 2, feelings[2]);
		jdbcTemplate.update("insert into feelings_tbl(feelingId, feeling) values(?,?)", 3, feelings[3]);
		jdbcTemplate.update("insert into feelings_tbl(feelingId, feeling) values(?,?)", 4, feelings[4]);

		jdbcTemplate.execute("drop table feelings_history_tbl if exists");
		jdbcTemplate
				.execute("create table feelings_history_Tbl(userId integer, year integer, month integer, day integer, feelingId integer)");
	}
}
